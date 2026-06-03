INSERT INTO quadra (
    id_quadra,
    nome,
    localizacao,
    status
) VALUES
(1, 'Ginásio Municipal', 'Rua João Nunes, nº 300', 'Disponível'),
(2, 'Campo Suíço', 'Rua João Nunes, nº 300 - Ao lado do Ginásio', 'Disponível'),
(3, 'Arena Beach', 'Rua Genésio Flôres Viana - Centro', 'Disponível'),
(4, 'Arena SOS Beach', 'Rua Genésio Flôres Viana', 'Disponível')
ON DUPLICATE KEY UPDATE
    nome = VALUES(nome),
    localizacao = VALUES(localizacao),
    status = VALUES(status);