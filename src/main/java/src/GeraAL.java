package src;

import java.nio.file.Paths;

public class GeraAL {
	
	public static void main(String[] args) {
		
		String rootPath = Paths.get("").toAbsolutePath().toString();
		String subPath = "/src/main/java/src/";
		
		String file[] = {rootPath + subPath + "scanner.flex"};
		
		jflex.Main.main(file);
		
	}

}