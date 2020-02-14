package Clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;



public class Ahorcado extends Game {
    public Ahorcado(ArrayList<Persona> pp) {
        ap1 = pp;
    }

    Scanner sc = new Scanner(System.in);
    public void Start(){
        System.out.println("JUGADOR " + ap1.get(0).getNombre()+" escoge la palabra oculta! ");
        String palabra = sc.nextLine().toLowerCase();

        Adivina(palabra);
    }
    public void Adivina(String palabra){
        HashSet<Character> hs = new HashSet<>();
        Character chose;
        String respuesta="";
        for (int intentos = 7; intentos > 0; intentos--){
            do {
                System.out.println("Jugador " + ap1.get(1).getNombre() +" dime una letra! ");
                chose = sc.next().charAt(0);
                chose = Character.toLowerCase(chose);
            }while (chose >= 'a' && chose <= 'z' && (hs.contains(chose)));
            hs.add(chose);
            respuesta = unifica(chose, respuesta);
            if (palabra.indexOf(chose) != -1)
                intentos++;
            visualiza(palabra, hs);
            System.out.println("Te quedan " + intentos + " intentos!");
        }
        System.out.println("Jugador "+ap1.get(0).getNombre()+" gana!");
        Aux.Rewards(ap1.get(0),ap1.get(1));

    }
    public void visualiza( String palabra, HashSet hs){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < palabra.length(); i++){
            if (hs.contains(palabra.charAt(i))){
                sb.append(palabra.charAt(i));
                count++;
            }else{
                sb.append('_');
            }
        }
        if (count == palabra.length()){
            System.out.println("Jugador "+ap1.get(1).getNombre()+" GANA!");
            System.out.println("La palabra era: " + palabra);
            Aux.Rewards(ap1.get(1),ap1.get(0));
        }
        System.out.println("Letras usadas: " + hs.toString());
        System.out.println("PALABRA: " + sb.toString()+"\n");
    }

    public String unifica(Character chose, String respuesta){
        StringBuilder sb = new StringBuilder(respuesta);
        if (respuesta.indexOf(chose) > 0) {
            sb.append(chose);
            System.out.println(sb.toString());
            return sb.toString();
        }else{
            return sb.toString();
        }
    }
}
