-- CONSULTAS

SELECT *
FROM quadra;

SELECT *
FROM reserva;

SELECT r.id_reserva,
       r.nome_usuario,
       r.data_reserva,
       r.horario,
       q.nome AS nome_quadra,
       q.localizacao,
       q.status
FROM reserva r
INNER JOIN quadra q
        ON r.id_quadra = q.id_quadra;

SELECT horario
FROM reserva
WHERE data_reserva = '2026-06-02'
  AND id_quadra = 1;


-- INSERÇÃO

INSERT INTO reserva (
    nome_usuario,
    data_reserva,
    horario,
    id_quadra
) VALUES (
    'Usuário Teste',
    '2026-06-02',
    '08:00:00',
    1
);


-- ATUALIZAÇÃO

UPDATE quadra
SET nome = 'Ginásio Municipal',
    localizacao = 'Rua João Nunes, nº 300',
    status = 'Disponível'
WHERE id_quadra = 1;

UPDATE quadra
SET nome = 'Campo Suíço',
    localizacao = 'Rua João Nunes, nº 300 - Ao lado do Ginásio',
    status = 'Disponível'
WHERE id_quadra = 2;

UPDATE quadra
SET nome = 'Arena Beach',
    localizacao = 'Rua Genésio Flôres Viana - Centro',
    status = 'Disponível'
WHERE id_quadra = 3;

UPDATE quadra
SET nome = 'Arena SOS Beach',
    localizacao = 'Rua Genésio Flôres Viana',
    status = 'Disponível'
WHERE id_quadra = 4;


-- REMOÇÃO

DELETE FROM reserva
WHERE nome_usuario = 'Usuário Teste'
  AND data_reserva = '2026-06-02'
  AND horario = '08:00:00'
  AND id_quadra = 1;