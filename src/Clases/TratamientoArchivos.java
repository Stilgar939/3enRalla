package Clases;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;

public abstract class TratamientoArchivos {

    public void Lectura() throws ParserConfigurationException, TransformerException {} ;

    public void Escritura(ArrayList<Persona> p1) throws ParserConfigurationException, TransformerException {} ;


}
