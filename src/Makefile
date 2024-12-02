LEX = jflex.jar analisador.flex
COMP_FILES = Main.java Analisador.java
DEFAULT_INPUT = teste.lan

all: lex comp default_test

lex:
	java -jar $(LEX)

comp: Analisador.java
	javac $(COMP_FILES)

default_test:
	java Main $(DEFAULT_INPUT)

%.lan: lex comp
	java Main $@

clean:
	rm -f *.class Analisador.java *.java~