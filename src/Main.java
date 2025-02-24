import java.io.FileNotFoundException;
import java.io.FileReader;

import lexer.TK;
import lexer.Token;

public class Main {

    @SuppressWarnings({"CallToPrintStackTrace"})
    public static void main(String[] args) {
        if(args.length != 1){
            help();
            System.exit(0);
        }

        try{
            Analisador lex = new Analisador(new FileReader(args[0]) );
            Token t = lex.nextToken();

            while(t.tk != TK.EOF){
                System.out.println(t.toString());
                t = lex.nextToken();
            }

            System.out.println(t.toString());

        }catch(FileNotFoundException e){
            System.out.println("O arquivo " + args[0] + " não foi encontrado.");
        }catch(Exception e){
            System.out.println("Erro ao processar " + args[0] );
            e.printStackTrace();
        }
    }

    public static void help(){
        System.out.println(" Analisador léxico para a linguagem LANG.");
        System.out.println(" Versão: 0.1");
        System.out.println(" Executar: make");
        System.out.println(" Apagar arquivos gerados: make clean");
    }
}