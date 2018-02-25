## TXT FILES TO DATABASE

**UPDATE V1.1**

>  - Agora é possivel adicionar varios arquivos **TXT** de uma só vez.
>  - As informações das operações de cada arquivo são guardadas em um relátorio contendo a data, horário, usuario, querys lançadas e possiveis erros capturados.


**SOBRE:**

> Software capaz de ler arquivos **TXT**, tratar as linhas determinadas transformando em um Objeto Java e logo em seguida    transformando em
> uma Query **SQL** e adicionando no banco de dados, no exemplo acima é
> utilizado o **PostgreSQL 10**. Testado também no **MySQL** sendo necessário
> apenas a importação da biblioteca **JDBC** do banco desejado.

**OBSERVAÇÃO:**

> A estrutura do projeto e as credenciais do banco deve ser trocadas de
> acordo com as suas necessidades. Segue junto ao projeto, o arquivo
> **.SQL** da tabela utilizada e o arquivo **.TXT** utilizado.

## CÓDIGOS

**TABELA SQL:**


```SQL
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
```

**TXT 1:**

    Relatorio de Pagamento de Boleto Bancario
    Lançamentos baixados: 17	Valor total (Baixas): Indefinida
    Lançamentos não baixados: 0
    NumeroDocumento     Cedente   Sacado   ValorDocumento   Valor Baixa
    10 Banese Pedro 1250 1250
    20 Caixa Lucas 300 300
    30 Pichau Rafael 450 450
    40 Submarino Mateus 820 820
    50 Nestle Gabriel 4321 4321
    60 HP Caio 120 120
    70 Intel Kaio 50 50
    80 Kabum Jose 10 10
    90 Banese Gustavo 60 60
    100 Kabum Falcao 7800 7800
    110 Pichau Sardela 78 78
    120 Banese Oliveira 12 12
    130 Americanas Jeferson 14 14
    140 Bradesco Paiva 900 900
    150 Banese Alex 942 942
    160 BB Victor 1115 1115
    170 Netshoes Mano 960 960
    
**TXT 2:**

    Relatorio de Pagamento de Boleto Bancario
    Lançamentos baixados: 1 Valor total (Baixas): Indefinida
    Lançamentos não baixados: 0
    NumeroDocumento     Cedente   Sacado   ValorDocumento   Valor Baixa
    00007 Google Maria 8500 8500

## VÍDEO DEMONSTRATIVO:

**[TXTsToBD Vídeo Demonstração Versão 1.0](https://www.youtube.com/watch?v=JCFhfn2xbcg)**
**[TXTsToBD Vídeo Demonstração Versão 1.1](https://www.youtube.com/watch?v=3gHM9sW4B20)**

