## FILES TO DATABASE

**SOBRE:**

> Software capaz de ler arquivos (cujo conteudo seja composto por texto), tratar as linhas determinadas transformando em
> Query **SQL** e adicionando no banco de dados.

**UPDATES:**

>**UPDATE V1.2**
>  - Foi adicionado um controle do tamanho dos arquivos de LOG, ao atingir determinado tamanho um novo arquivo de LOG é gerado, 
> evitando ter um único e gigantesco arquivo, o que dificultaria a consulta do mesmo.

>**UPDATE V1.1**
>  - Agora é possivel adicionar varios arquivos de uma só vez.
>  - As informações das operações de cada arquivo são guardadas em um LOG (relátorio contendo a data, horário, usuario, querys lançadas e possiveis erros capturados).

## CÓDIGOS

**TABELAS SQL:**

```SQL
CREATE TABLE public.carro
(
  numero_chassi integer NOT NULL,
  nome character varying NOT NULL,
  cor character varying NOT NULL,
  ano integer NOT NULL,
  potencia integer NOT NULL,
  valor double precision NOT NULL,
  CONSTRAINT carro_pkey PRIMARY KEY (numero_chassi)
)
```
```SQL
CREATE TABLE public.pessoa
(
  cpf integer NOT NULL,
  rg integer NOT NULL,
  idade integer NOT NULL,
  nome character varying NOT NULL,
  CONSTRAINT pessoa_pkey PRIMARY KEY (cpf),
  CONSTRAINT pessoa_rg_key UNIQUE (rg)
)
```

```SQL
CREATE TABLE public.venda
(
  id_venda SERIAL,
  data_venda character varying NOT NULL,
  id_pessoa_fk integer NOT NULL,
  id_carro_fk integer NOT NULL,
  CONSTRAINT venda_pkey PRIMARY KEY (id_venda),
  CONSTRAINT venda_id_carro_fk_fkey FOREIGN KEY (id_carro_fk)
      REFERENCES public.carro (numero_chassi) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT venda_id_pessoa_fk_fkey FOREIGN KEY (id_pessoa_fk)
      REFERENCES public.pessoa (cpf) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT venda_id_carro_fk_key UNIQUE (id_carro_fk)
)
```

**ARQUIVO CONSUMIDO:**

```
carro;123;Ferrari;Vermelha;2016;480;2500000.0
pessoa;076;1245;19;Pedro
venda;076;123;2018-05-06 12:28
```


**OBSERVAÇÃO:**

>A estrutura do projeto e as credenciais do banco deve ser trocadas de acordo com as suas necessidades, assim como a importação da biblioteca JDBC do banco desejado.

