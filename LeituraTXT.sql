CREATE TABLE leitura.tabela_txt
(
  num_documento integer NOT NULL,
  cedente_documento character varying,
  sacado_documento character varying,
  valor_documento double precision,
  valor_baixa double precision,
  CONSTRAINT tabela_txt_pkey PRIMARY KEY (num_documento)
)
WITH (
  OIDS=FALSE
);