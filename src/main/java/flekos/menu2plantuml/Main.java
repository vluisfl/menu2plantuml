package flekos.menu2plantuml;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.out.println("Usage: java -cp target/menu2plantuml-1.0.jar flekos.menu2plantuml.Main perfil12.puml 12");
            System.exit(1);
        }


        String perfil = args[1];

        InputStream is = Main.class.getClassLoader().getResourceAsStream("menu_fext.xml");

        MenuItem root = MenuParser.parse(is);

        String plant = PlantUMLGenerator.generate(root, perfil);

        System.out.println(plant);

        List<String> lineas = Arrays.asList(plant);
        
        Files.write(Paths.get(args[0]), lineas, StandardCharsets.UTF_8);
        
    }
}
