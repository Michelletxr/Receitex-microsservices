CREATE TABLE public.users
(
    role       smallint
        CONSTRAINT users_role_check
            CHECK ((role >= 0) AND (role <= 2)),
    id         UUID NOT NULL PRIMARY KEY,
    role_type  VARCHAR(31) NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);

-- Inserindo dados na tabela public.users
INSERT INTO public.users (role, id, role_type, first_name, last_name)
VALUES
    (1, '4f6d11c7-82cf-4d6a-a0c3-56a1f79149d1', 'medico', 'João', 'Silva'),
    (1, '9bfb08e7-3ae2-4b8e-b5b5-24f346b30972', 'medico', 'Maria', 'Santos'),
    (0, 'a46d25c1-ec22-4d3b-b9a7-ec5ab3ac2df7', 'paciente', 'Pedro', 'Gomes');
