package Clases;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class XML extends TratamientoArchivos {
    File archivoXML = new File("puntuacion.xml");
    ArrayList<Persona> listaPersonas = new ArrayList<>();
    @Override
    public void Escritura(ArrayList<Persona> p1) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document documento = documentBuilder.newDocument();

        Element raiz = documento.createElement("historial");
        documento.appendChild(raiz);

        Iterator i = p1.iterator();

        while (i.hasNext()) {
            Persona pp = (Persona) i.next();

            Element jugador = documento.createElement("jugador");
            raiz.appendChild(jugador);

            Element nombre = documento.createElement("nombre");
            nombre.appendChild(documento.createTextNode(pp.getNombre()));
            jugador.appendChild(nombre);

            Element coins = documento.createElement("coins");
            coins.appendChild(documento.createTextNode(Float.toString(pp.getCoin())));
            jugador.appendChild(coins);

            Element time = documento.createElement("time");
            time.appendChild(documento.createTextNode(Integer.toString(pp.getTiempo())));
            jugador.appendChild(time);
            try {
                documento.getDocumentElement().normalize();
            } catch (Exception e) {

            }
            Node jugador1 = documento.getElementsByTagName("jugador").item(0);

            NodeList lista = jugador1.getChildNodes();

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(documento);

        StreamResult streamResult = new StreamResult(new File("puntuacion.xml"));

        transformer.transform(source, streamResult);
    }

    @Override
    public void Lectura() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        ArrayList<String> nombre = new ArrayList<>();
        ArrayList<Integer> tiempo = new ArrayList<>();
        ArrayList<Float> coins = new ArrayList<>();
        try {
            doc = dBuilder.parse(archivoXML);
            doc.getDocumentElement().normalize();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        NodeList nList = doc.getElementsByTagName("jugador");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);


            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;


                nombre.add(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                tiempo.add(Integer.parseInt(eElement.getElementsByTagName("time").item(0).getTextContent()));
                coins.add(Float.parseFloat(String.valueOf(eElement.getElementsByTagName("coins").item(0).getTextContent())));
                if (coins.get(temp) < 0)
                    coins.set(temp, (float) 0);
                Persona p1 = new Persona(nombre.get(temp),tiempo.get(temp),coins.get(temp));
                listaPersonas.add(p1);
            }
        }
        //System.out.println(nombre);
        //System.out.println(tiempo);
        //System.out.println(coins);
    }

    public ArrayList<Persona> devuelveInfo(){
        return listaPersonas;
    }

    public void creado(){
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document documento = documentBuilder.newDocument();

        Element raiz = documento.createElement("historial");
        documento.appendChild(raiz);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource source = new DOMSource(documento);

        StreamResult streamResult = new StreamResult(new File("puntuacion.xml"));

        try {
            transformer.transform(source, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}






