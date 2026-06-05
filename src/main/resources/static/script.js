// =====================
// MENU RESPONSIVO
// =====================
const menuLinks = document.querySelectorAll('.nav-link');
const navbarCollapse = document.querySelector('.navbar-collapse');

menuLinks.forEach(link => {
    link.addEventListener('click', () => {
        if (navbarCollapse.classList.contains('show')) {
            navbarCollapse.classList.remove('show');
        }
    });
});

// =====================
// SCROLL SUAVE
// =====================
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();

        const section = document.querySelector(this.getAttribute('href'));

        if (section) {
            section.scrollIntoView({ behavior: 'smooth' });
        }
    });
});

// =====================
// ANIMAÇÃO CARDS
// =====================
const cards = document.querySelectorAll('.custom-card, .evento-card, .stat-card');

cards.forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.style.transform = 'translateY(-8px)';
    });

    card.addEventListener('mouseleave', () => {
        card.style.transform = 'translateY(0px)';
    });
});

// =====================
// FORM RESERVA
// =====================
const formReserva = document.querySelector('#formReserva');

if (formReserva) {
    formReserva.addEventListener('submit', async function (e) {
        e.preventDefault();

        const data = document.querySelector('#dataReserva').value;

        const reserva = {
            nomeUsuario: document.querySelector('#nome').value,
            dataReserva: data,
            horario: document.querySelector('#horario').value,
            quadra: {
                idQuadra: parseInt(document.querySelector('#quadra').value)
            }
        };

        try {
            const response = await fetch('/reservas', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(reserva)
            });

            if (response.ok) {
                alert('Reserva realizada com sucesso!');
                formReserva.reset();
                carregarHorarios();
                carregarReservas();
            } else {
                const erro = await response.text();
                console.log("ERRO BACKEND:", erro);
                alert("Erro ao salvar reserva");
            }

        } catch (error) {
            console.error(error);
            alert('Erro de conexão com servidor.');
        }
    });
}

// =====================
// DATE PICKER (PT-BR)
// =====================
flatpickr("#dataReserva", {
    dateFormat: "Y-m-d",
    minDate: "today",
    locale: {
        firstDayOfWeek: 1
    }
});

// =====================
// HORÁRIOS DISPONÍVEIS
// =====================
const campoQuadra = document.getElementById('quadra');
const campoData = document.getElementById('dataReserva');
const campoHorario = document.getElementById('horario');

const horariosDisponiveis = [
    '08:00',
    '09:00',
    '10:00',
    '11:00',
    '14:00',
    '15:00',
    '16:00',
    '17:00',
    '18:00',
    '19:00',
    '20:00'
];

async function buscarHorariosOcupados(quadraId, data) {
    const resposta = await fetch(
        `/reservas/ocupados?data=${data}&quadraId=${quadraId}`
    );

    if (!resposta.ok) {
        throw new Error('Erro ao buscar horários ocupados');
    }

    return await resposta.json();
}

async function carregarHorarios() {
    campoHorario.innerHTML = '<option value="">Selecione um horário</option>';

    const quadra = campoQuadra.value;
    const data = campoData.value;

    if (!quadra || !data) {
        campoHorario.disabled = true;

        const option = document.createElement('option');
        option.value = '';
        option.textContent = 'Escolha a quadra e a data primeiro';
        option.disabled = true;

        campoHorario.appendChild(option);
        return;
    }

    campoHorario.disabled = false;

    try {
        const horariosOcupados = await buscarHorariosOcupados(quadra, data);

        horariosDisponiveis.forEach(function (horario) {
            const option = document.createElement('option');

            option.value = horario;

            if (horariosOcupados.includes(horario)) {
                option.textContent = horario + ' - Reservado';
                option.disabled = true;
            } else {
                option.textContent = horario;
            }

            campoHorario.appendChild(option);
        });

    } catch (erro) {
        console.error(erro);

        const option = document.createElement('option');
        option.value = '';
        option.textContent = 'Erro ao carregar horários';
        option.disabled = true;

        campoHorario.appendChild(option);
    }
}

if (campoQuadra && campoData && campoHorario) {
    campoQuadra.addEventListener('change', carregarHorarios);
    campoData.addEventListener('change', carregarHorarios);
}

// =====================
// PROTEGER NOMES
// =====================
function protegerNome(nome) {
    if (!nome) {
        return 'Usuário';
    }

    return nome
        .trim()
        .split(' ')
        .map(function (parte) {
            if (parte.length <= 1) {
                return parte;
            }

            return parte.charAt(0) + '*'.repeat(parte.length - 1);
        })
        .join(' ');
}

// =====================
// BUSCAR RESERVAS
// =====================
async function carregarReservas() {
    const listaReservas = document.getElementById('listaReservas');

    if (!listaReservas) {
        return;
    }

    try {
        const resposta = await fetch('/reservas');

        if (!resposta.ok) {
            throw new Error('Erro ao buscar reservas');
        }

        const reservas = await resposta.json();

        listaReservas.innerHTML = '';

        if (reservas.length === 0) {
            listaReservas.innerHTML = `
                <tr>
                    <td colspan="4" class="text-center">
                        Nenhuma reserva cadastrada.
                    </td>
                </tr>
            `;
            return;
        }

        reservas.forEach(function (reserva) {

            const horario = reserva.horario
                ? reserva.horario.substring(0, 5)
                : '-';

            const quadra = reserva.quadra && reserva.quadra.nome
                ? reserva.quadra.nome
                : 'Quadra não informada';

            const linha = document.createElement('tr');

            linha.innerHTML = `
                <td>${protegerNome(reserva.nomeUsuario)}</td>
                <td>${quadra}</td>
                <td>${reserva.dataReserva}</td>
                <td>${horario}</td>
            `;

            listaReservas.appendChild(linha);
        });

    } catch (erro) {
        console.error(erro);

        listaReservas.innerHTML = `
            <tr>
                <td colspan="4" class="text-center">
                    Erro ao carregar reservas.
                </td>
            </tr>
        `;
    }
}

carregarHorarios();
carregarReservas();

// =====================
// MODAL RESERVAS
// =====================
const modalReservas = document.getElementById('modalReservas');

if (modalReservas) {
    modalReservas.addEventListener('shown.bs.modal', carregarReservas);
}