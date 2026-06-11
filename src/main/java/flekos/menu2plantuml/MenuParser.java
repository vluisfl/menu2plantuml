package flekos.menu2plantuml;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MenuParser {

    public static MenuItem parse(InputStream is) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new InputStreamReader(is, "UTF-8")));

        Element root = doc.getDocumentElement();
        MenuItem rootItem = new MenuItem(null,"ROOT",null,null, Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12"));

        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i) instanceof Element) {
                rootItem.addChild(parseElement((Element) nodes.item(i)));
            }
        }
        return rootItem;
    }

    private static MenuItem parseElement(Element el) {
        String nombre = el.getAttribute("nombre");
        String perfilesAttr = el.getAttribute("perfiles");
        List<String> perfiles = Arrays.asList(perfilesAttr.split(";"));

        MenuItem item = new MenuItem(null, nombre, null, null, perfiles);

        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i) instanceof Element) {
                item.addChild(parseElement((Element) children.item(i)));
            }
        }

        return item;
    }
}
