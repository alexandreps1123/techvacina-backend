-- Dados de teste

-- Endereços
-- Endereço Posto 1 (CAPS II)
INSERT INTO endereco (id, cidade, estado, pais, bairro, linha, cep) 
VALUES (1, 'Brasília', 'DF', 'Brasil', 'Asa Norte', 'SGAN 905 Módulo D', '70790054');
-- Endereço Posto 2 (HRAN)
INSERT INTO endereco (id, cidade, estado, pais, bairro, linha, cep) 
VALUES (2, 'Brasília', 'DF', 'Brasil', 'Asa Norte', 'Setor Médico Hospitalar Norte, Quadra 101 - Área Especial', '70710905');
-- Endereço Posto 3 (Centro de Saúde de Brasília Nº 11)
INSERT INTO endereco (id, cidade, estado, pais, bairro, linha, cep) 
VALUES (3, 'Brasília', 'DF', 'Brasil', 'Asa Norte', 'SGAN 905 modulo D', '70297400');

-- Endereço Cliente 1
INSERT INTO endereco (id, cidade, estado, pais, bairro, linha, cep) 
VALUES (4, 'Brasília', 'DF', 'Brasil', 'Asa Sul', 'SQS 106 Bloco F', '70340060');
-- Endereço Cliente 2
INSERT INTO endereco (id, cidade, estado, pais, bairro, linha, cep) 
VALUES (5, 'Brasília', 'DF', 'Brasil', 'Asa Norte', 'SQN 303 Bloco E', '70735050');

-- Clientes
-- Cliente 1
INSERT INTO cliente (id, cpf, nome, telefone, endereco_id)
VALUES (1, '0001', 'Joana', '555-0001', 4);
-- Cliente 2
INSERT INTO cliente (id, cpf, nome, telefone, endereco_id)
VALUES (2, '0007', 'Celso', '555-0002', 5);

-- Doenças
-- Covid
INSERT INTO doenca (id, nome)
VALUES (1, 'Covid-19');
-- Gripe Influenza
INSERT INTO doenca (id, nome)
VALUES (2, 'Influenza');
-- Hepatite
INSERT INTO doenca (id, nome)
VALUES (3, 'Hepatite');

-- Postos de Saúde
-- Posto 1 (CAPS II)
INSERT INTO posto_de_saude (id, nome, endereco_id)
VALUES (1, 'CAPS II', 1);
-- Posto 2 (HRAN)
INSERT INTO posto_de_saude (id, nome, endereco_id)
VALUES (2, 'HRAN', 2);
-- Posto 3 (Centro de Saúde de Brasília Nº 11)
INSERT INTO posto_de_saude (id, nome, endereco_id)
VALUES (3, 'Centro de Saúde de Brasília Nº 11', 3);

-- Vacinas
-- Pfizer
INSERT INTO vacina (id, nome, doses, intervalo_entre_doses, tempo_de_eficacia, doenca_id)
VALUES (1, 'Pfizer', 1, 0, 180, 1);
-- Moderna
INSERT INTO vacina (id, nome, doses, intervalo_entre_doses, tempo_de_eficacia, doenca_id)
VALUES (2, 'Moderna', 1, 0, 365, 1);

-- Lote
-- Lote Pfizer
INSERT INTO lote_vacina (id, vacina_id, quantidade, recebimento, validade, posto_id)
VALUES (1, 1, 1000, '2022-07-01', '2023-07-01', 1);
-- Lote Moderna
INSERT INTO lote_vacina (id, vacina_id, quantidade, recebimento, validade, posto_id)
VALUES (2, 2, 1000, '2022-07-15', '2022-12-01', 1);