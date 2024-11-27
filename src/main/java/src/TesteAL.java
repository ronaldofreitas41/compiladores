package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteAL {

	public static void leToken(String token) throws IOException {
		AnalisadorLexico lexical = new AnalisadorLexico(new StringReader(token));
		lexical.yylex();
	}

	public static List<String> leArquivoLan(String nomeArq){
		List<String> result = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(nomeArq))) {
			String line;
			while ((line = br.readLine()) != null) {
				// Divide a linha por espaços e adiciona os elementos ao resultado
				String[] parts = line.split(" ");
				for (String part : parts) {
					// Ignora strings vazias ou apenas espaços
					if (!part.equals(" ")) {
						result.add(part);
						leToken(part);
					}else{
						System.err.println("token não interpretado");
					}
				}
			}
		} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;

	}

	public static void main(String[] args) throws IOException{

		leArquivoLan("C:/Users/ronal/Documents/compiladores/src/main/java/src/teste.lan");

	}

}
