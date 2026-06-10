package flekos.menu2plantuml;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    private String id;
    private String nombre;
    private String navegacion;
    private String url;
    private List<String> perfiles;
    private List<MenuItem> children = new ArrayList<>();
    
    public void addChild(MenuItem child) {
        children.add(child);
    }

    public boolean isAllowed(String perfil) {
        return perfiles.contains(perfil);
    }
    
    public MenuItem(String id, String nombre, String navegacion, String url, List<String> perfiles) {
        this.nombre = nombre;
        this.perfiles = perfiles;
        this.navegacion = navegacion;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNavegacion() {
        return navegacion;
    }

    public void setNavegacion(String navegacion) {
        this.navegacion = navegacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<String> perfiles) {
        this.perfiles = perfiles;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }
    
    
}
