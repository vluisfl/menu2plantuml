package flekos.menu2plantuml;

public class PlantUMLGenerator {
/*
    public static String generate(MenuItem root, String profile) {
        StringBuilder sb = new StringBuilder();
        sb.append("@startuml\n");
        sb.append("skinparam linetype ortho\n");
        sb.append("title Menu navegación - perfil: " + profile + "\n");

        generateTree(sb, root, profile);

        sb.append("\n* Inicio");
        sb.append("\n@enduml");
        return sb.toString();
    }

    private static void generateTree(StringBuilder sb, MenuItem parent, String perfil) {
        for (MenuItem child : parent.getChildren()) {
            if (!child.isAllowed(perfil)) continue;

            //sb.append("[" + parent.getNombre() + "] --> [" + child.getNombre() + "]\n");

            sb.append("[" + parent.getNombre() + "] --> [" + child.getNombre() + "]\n");

            generateTree(sb, child, perfil);
        }
    }
*/
    public static String generate(MenuItem root, String perfil) {
        StringBuilder sb = new StringBuilder();
        sb.append("@startmindmap\n");
        sb.append("skinparam linetype ortho\n");
        sb.append("title Menu navegación - perfil: " + perfil + "\n");

        sb.append("\n* Inicio \n");
        
        generateTree(sb, root, perfil, 2);

        
        sb.append("\n@endmindmap");
        return sb.toString();
    }

    private static void generateTree(StringBuilder sb, MenuItem parent, String perfil, int nivel) {
        for (MenuItem child : parent.getChildren()) {
            if (!child.isAllowed(perfil)) continue;

            //sb.append("[" + parent.getNombre() + "] --> [" + child.getNombre() + "]\n");


            StringBuilder sbAsterisco = new StringBuilder();

            for (int i = 0; i < nivel; i++) {
                sbAsterisco.append("*");
            }

            sb.append(sbAsterisco.toString() + "_ " + child.getNombre()  + "\n");

            generateTree(sb, child, perfil, nivel+1);
        }
    }

}
