# Analisador Léxico da Linguagem Lang

Este projeto é um analisador léxico desenvolvido em Java utilizando **JFlex** para a linguagem de programação fictícia chamada **Lang**. O analisador identifica e categoriza os tokens de entrada da linguagem e os imprime no terminal, servindo como a primeira etapa de um compilador para Lang.

---

## Objetivo

O objetivo principal deste projeto é processar o código-fonte de Lang e reconhecer elementos como palavras-chave, identificadores, operadores, números, caracteres ASCII, e outros tokens definidos pela gramática da linguagem. Além disso, o analisador trata erros léxicos, sinalizando caracteres inválidos ou estruturas não reconhecidas.

---

## Funcionalidades

- **Identificação de Tokens**: 
  - Palavras-chave (`if`, `else`, `data`, `iterate`, etc.)
  - Operadores (`+`, `-`, `*`, `/`, `&&`, etc.)
  - Números inteiros e decimais.
  - Caracteres de escape (`'\n'`, `'\t'`, etc.).
  - Representações ASCII (`'\065'`, `'\\n'`).
  - Identificadores válidos.

- **Tratamento de Comentários**:
  - Comentários de linha iniciados por `--`.
  - Comentários de bloco delimitados por `{-` e `-}`.

- **Detecção de Erros Léxicos**:
  - Caracteres ou sequências inválidas são sinalizados com mensagens de erro descritivas.

- **Saída no Terminal**:
  - Para cada token identificado, o programa imprime uma linha contendo o tipo do token, a posição no código-fonte (linha e coluna) e, se aplicável, o valor associado.

---

## Pré-requisitos

- **Java**: Versão 8 ou superior.
- **JFlex**: Ferramenta para gerar o analisador léxico.
- **Compilador Java**: Para compilar os arquivos gerados pelo JFlex.
- **MakeFile**: Para gerar arquivos e executar a analise lexica.
---

## Estrutura do Projeto

📂 src/ 
  ├── Analisador.flex # Arquivo JFlex com as definições do analisador léxico.
  ├── Token.java # Classe que representa os tokens reconhecidos.
  ├── TK.java # Enum com os tipos de tokens.
  ├── Analisador.java # Classe principal gerada pelo JFlex. 
  └── test.lang # Arquivo de exemplo para teste.

  ---

## Como Executar

### 1. Gerar o Analisador Léxico
Certifique-se de ter o **JFlex** instalado. Navegue até o diretório do projeto e execute:

```bash
java -jar jflex.jar src/Analisador.flex

```
---

### 2.Compilar o Código
Compile os arquivos Java (incluindo o analisador gerado):

```bash
Copiar código
javac src/*.java
```
Se não houver erros, os arquivos compilados (.class) serão gerados no mesmo diretório.

---

### 3. Executar o Analisador Léxico
Agora, você pode executar o analisador léxico. Para isso:

Passe um arquivo de código-fonte da linguagem Lang como entrada para o analisador.

Execute o seguinte comando com o Makefile:

```bash
Copiar código
make test.lan
O arquivo test.lang é um exemplo de código Lang que acompanha o projeto.  
```
---

### 4.Verificando o Resultado

O analisador imprimirá no terminal uma lista de tokens identificados no código-fonte, com suas respectivas linhas, colunas e valores. Exemplo de saída:

Entrada no arquivo test.lan

```
data x = '\065';  -- declaração de variável com valor ASCII
if x > 10 {
    print x;
} else {
    print 0;
}
```
Saida do terminal esperada:

```
Linha: 1, Coluna: 1, Tipo: TK.DATA
Linha: 1, Coluna: 6, Tipo: TK.IDENTIFIER, Valor: x
Linha: 1, Coluna: 8, Tipo: TK.ASSIGN
Linha: 1, Coluna: 10, Tipo: TK.ASCII, Valor: A
Linha: 1, Coluna: 15, Tipo: TK.SEMICOLON
...
```

---

### Limpeza dos arquivos gerados

No terminal execute este comando

```
make clean
```
