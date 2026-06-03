CREATE TABLE IF NOT EXISTS quadra (
    id_quadra INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    localizacao VARCHAR(150) NOT NULL,
    status VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS reserva (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL,
    data_reserva DATE NOT NULL,
    horario TIME NOT NULL,
    id_quadra INT NOT NULL,

    CONSTRAINT fk_reserva_quadra
        FOREIGN KEY (id_quadra)
        REFERENCES quadra(id_quadra),

    CONSTRAINT uk_reserva_quadra_data_horario
        UNIQUE (id_quadra, data_reserva, horario)
);