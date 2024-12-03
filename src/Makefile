#   Bernardo Lucas de Araujo Dias - 20.1.8011
#   Ronaldo Luiz de Freitas Santos - 20.1.8113

LEX = jflex.jar analisador.flex
COMP_FILES = Main.java Analisador.java
DEFAULT_INPUT = teste.lan

# Gera o analisador léxico, utiliza-o para compilar, e roda um arquivo de teste
all: lex comp default_test

lex:
	java -jar $(LEX)

comp: Analisador.java
	javac $(COMP_FILES)

default_test:
	java Main $(DEFAULT_INPUT)

# Complemento para rodar outros arquivos além do default
%.lan: lex comp
	java Main $@

# Apaga os arquivos gerados pelo analisador.
clean:
	rm -f *.class Analisador.java *.java~