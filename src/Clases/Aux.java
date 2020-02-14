package Clases;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aux {

    public static String menu() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                                                                      |");
        System.out.println("|                                                                      |");
        System.out.println("|                      A que juego quieres jugar?                      |");
        System.out.println("|                                                                      |");
        System.out.println("|                                                                      |");
        System.out.println("|                                                                      |");
        System.out.println("|      1. Piedra, Papel, Tijera                                        |");
        System.out.println("|                                                                      |");
        System.out.println("|      2. Ahorcado                                                     |");
        System.out.println("|                                                                      |");
        System.out.println("|      3. Adivina el numero                                            |");
        System.out.println("|                                                                      |");
        System.out.println("|      4. Blackjack                                                    |");
        System.out.println("|                                                                      |");
        System.out.println("|                                                                      |");
        System.out.println("|                                                                      |");
        System.out.println("+----------------------------------------------------------------------+");


        return Chose();
    }

    public static String Chose() {
        Scanner sc = new Scanner(System.in);
        String chose;
        do {
            chose = sc.nextLine();
        } while (choseWhisely(chose));
        return chose;
    }

    public static boolean choseWhisely(String chose) {
        switch (chose) {
            case "1":
            case "2":
            case "3":
            case "4":
                return false;
            default:
                System.out.println("Eso no es un numero entre el 1 y el 4!");
                return true;
        }
    }

    public static boolean isCorrect(String mv) {
        switch (mv) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
                return false;
            default:
                return true;
        }
    }

    //TODO clonner para copiar una persona del arraylist a jugador 1/2
    public static ArrayList<Persona> XMLReader() {
        XML x = new XML();
        ArrayList<Persona> jugadores = new ArrayList<>();
        ArrayList<Persona> jugadoresPartida = new ArrayList<>();
        ArrayList<String> listaNombres = new ArrayList<>();
        try {
            x.Lectura();
            jugadores = x.devuelveInfo();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        String nombre = askName(listaNombres);
        listaNombres.add(nombre);
        if (compruebaplayers(nombre, jugadores, jugadoresPartida)) {
            Persona p1 = new Persona(nombre);
            jugadoresPartida.add(p1);
        }
        nombre = askName(listaNombres);
        listaNombres.add(nombre);
        if (compruebaplayers(nombre, jugadores, jugadoresPartida)) {
            Persona p1 = new Persona(nombre);
            jugadoresPartida.add(p1);
        }
        return jugadoresPartida;
    }

    private static boolean compruebaplayers(String nombre, ArrayList<Persona> jugadores, ArrayList<Persona> jugadoresPartida) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (nombre.equals(jugadores.get(i).getNombre())) {
                Persona p1 = new Persona(jugadores.get(i).getNombre(), jugadores.get(i).getTiempo(), jugadores.get(i).getCoin());
                jugadoresPartida.add(p1);
                return false;
            }
        }
        return true;
    }

    private static String askName(ArrayList<String> listaNombres) {
        String nombre;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Dime tu nombre! (AVISO! Los nombres deben ser UNICOS!)");
            nombre = sc.next();
        } while (listaNombres.contains(nombre));
        System.out.println("Nombre aceptado");
        return nombre;
    }

    public static void Rewards(Persona ganador, Persona perdedor) {

        ganador.setCoin(ganador.getCoin()+ganador.bet+perdedor.bet);
        perdedor.setCoin(perdedor.getCoin()-perdedor.bet);

    }

    public static void choseGame(ArrayList<Persona> alp) {
        String chose = Aux.menu();
        switch (chose) {
            case "1":
                PPT ppt1 = new PPT(alp);
                ppt1.Start();
                break;
            case "2":
                Ahorcado a1 = new Ahorcado(alp);
                a1.Start();
                break;
            case "3":
                Number n1 = new Number(alp);
                n1.Start();
                break;
            case "4":
                Blackjack b1 = new Blackjack(alp);
                b1.Start();
                break;
        }
    }

    public static void Bet(Persona p1) {
        Scanner sc = new Scanner(System.in);
        float bet = 0;
        if (p1.getCoin() <= 100) {
            System.out.println("Jugador " + p1.getNombre() + " no posees suficientes dinero para elegir, tu apuesta sera de 100 coins");
            bet = 100;
        } else {
            do {
                System.out.println("Jugador " + p1.getNombre() + " selecciona tu apuesta: (coins actuales ->  " + p1.getCoin() + " )");
                try {
                    bet = sc.nextFloat();
                } catch (Exception e) {
                    System.out.println("ESO NO ES UN NUMERO POSITIVO");
                }
            } while (bet <= 0 || bet >= p1.getCoin());
        }
        p1.setBet(bet);
    }

    public static void XMLUpdate(ArrayList<Persona> ap1) throws TransformerException, ParserConfigurationException {
        XML x = new XML();
        x.Escritura(ap1);
    }
}
