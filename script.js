// =====================
// MENU RESPONSIVO
// =====================

const menuLinks =
document.querySelectorAll(
    '.nav-link'
);

const navbarCollapse =
document.querySelector(
    '.navbar-collapse'
);

menuLinks.forEach(link => {

    link.addEventListener('click', () => {

        if(navbarCollapse.classList.contains('show')){

            navbarCollapse.classList.remove('show');

        }

    });

});

// =====================
// SCROLL SUAVE
// =====================

document.querySelectorAll(
    'a[href^="#"]'
).forEach(anchor => {

    anchor.addEventListener(
        'click',
        function(e){

        e.preventDefault();

        const section =
        document.querySelector(
            this.getAttribute('href')
        );

        if(section){

            section.scrollIntoView({
                behavior:'smooth'
            });

        }

    });

});

// =====================
// ANIMAÇÃO DOS CARDS
// =====================

const cards =
document.querySelectorAll(
    '.custom-card, .evento-card, .stat-card'
);

cards.forEach(card => {

    card.addEventListener(
        'mouseenter',
        () => {

        card.style.transform =
        'translateY(-8px)';

    });

    card.addEventListener(
        'mouseleave',
        () => {

        card.style.transform =
        'translateY(0px)';

    });

});

// =====================
// ALERTA BOTÃO EVENTOS
// =====================

const btnEventos =
document.querySelector('#btn-eventos');

if(btnEventos){

    btnEventos.addEventListener('click', () => {

        alert(
            'Confira os próximos eventos esportivos da comunidade!'
        );

    });

}