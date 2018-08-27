CREATE TABLE medicamento (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE medico (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE paciente (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	data_nascimento DATE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE prescricao (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_medico_fk BIGINT(20) NOT NULL,
	id_paciente_fk BIGINT(20) NOT NULL,
	data_prescricao DATE NOT NULL,
	FOREIGN KEY (id_medico_fk) REFERENCES medico(id),
	FOREIGN KEY (id_paciente_fk) REFERENCES paciente(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE prescricao_medicamento (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_prescrica_fk BIGINT(20) NOT NULL,
	id_medicamento_fk BIGINT(20) NOT NULL,
	FOREIGN KEY (id_prescrica_fk) REFERENCES prescricao(id),
	FOREIGN KEY (id_medicamento_fk) REFERENCES medicamento(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE dispensacao (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_prescrica_fk BIGINT(20) NOT NULL,
	id_medicamento_fk BIGINT(20) NOT NULL,
	data_dispensacao DATE NOT NULL,
	FOREIGN KEY (id_prescrica_fk) REFERENCES prescricao(id),
	FOREIGN KEY (id_medicamento_fk) REFERENCES medicamento(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



