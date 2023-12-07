-- Script de Migração para Inserir Dados de Documentos

-- Inserir dados na tabela 'atestados'
INSERT INTO atestado (emissao, id, vencimento, paciente_id, descricao, nome_medico, nome_paciente, titulo)
VALUES
    ('2023-11-22 08:00:00', 1, '2023-12-22 08:00:00', '259b6a32-44e4-4227-bbcf-7f4ab21d4130', 'Descrição do atestado 1', 'Dr. José', 'Fulano de Tal', 'Atestado Médico 1'),
    ('2023-11-23 10:30:00', 2, '2023-12-23 10:30:00', '259b6a32-44e4-4227-bbcf-7f4ab21d4130', 'Descrição do atestado 2', 'Dra. Maria', 'Ciclano da Silva', 'Atestado Médico 2');

COMMIT;

-- Inserir dados na tabela 'receita'
INSERT INTO receita (emissao, id, vencimento, paciente_id, codido, descricao, nome_medico, nome_paciente, titulo)
VALUES
    ('2023-11-22 10:00:00', 1, '2023-12-22 10:00:00', '259b6a32-44e4-4227-bbcf-7f4ab21d4130', 'COD001', 'Descrição da receita 1', 'Dr. José', 'Joana Silva', 'Receita para dor de cabeça'),
    ('2023-11-23 11:00:00', 2, '2023-12-23 11:00:00', '259b6a32-44e4-4227-bbcf-7f4ab21d4130', 'COD002', 'Descrição da receita 2', 'Dra. Ana', 'Luiz Ferreira', 'Receita para alergia');

COMMIT;

-- Inserir dados na tabela 'requisicao'
INSERT INTO requisicao (emissao, id, paciente_id, descricao, nome_medico, nome_paciente, titulo)
VALUES
    ('2023-11-22 08:30:00', 1, '259b6a32-44e4-4227-bbcf-7f4ab21d4130', 'Exame de sangue', 'Dr. João Silva', 'Maria da Silva', 'Exame de Rotina'),
    ('2023-11-23 10:00:00', 2, '259b6a32-44e4-4227-bbcf-7f4ab21d4130', 'Consulta de rotina', 'Dra. Ana Souza', 'José Oliveira', 'Consulta Médica');

COMMIT;


