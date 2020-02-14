import Clases.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        ArrayList<Persona> alp1;
        File f = new File("puntuacion.xml");
        if(!f.exists()) {
            XML x = new XML();
            x.creado();
        }
        alp1 = Aux.XMLReader();
        //TODO intentar colocal lambda para hacer las bet
        Aux.Bet(alp1.get(0));
        Aux.Bet(alp1.get(1));
        Collections.shuffle(alp1);
        Aux.choseGame(alp1);
        Aux.XMLUpdate(alp1);
    }
}
