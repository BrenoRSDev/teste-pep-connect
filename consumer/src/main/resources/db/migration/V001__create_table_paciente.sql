CREATE TABLE paciente (
	id number GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
	codigo number NOT NULL,
	nome varchar(200) NOT NULL,
	cpf varchar(11) NOT NULL,
	data_nascimento date NOT NULL,
	CONSTRAINT paciente_pk PRIMARY KEY (id),
    CONSTRAINT paciente_akey UNIQUE (cpf)
);