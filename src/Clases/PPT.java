package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PPT extends Game {

    public PPT(ArrayList<Persona> pp) {
        ap1 = pp;
    }

    public void Start() {
        play();
    }

    public void play() {
        HashMap<Persona, String> ch1 = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            do {
                System.out.println("Jugador " + ap1.get(0).getNombre() + " elige tu accion: (piedra/papel/tijera)");
                choice = sc.next().toLowerCase();
                ch1.put(ap1.get(0), choice);
            } while (isCorrect(choice));
            do {
                System.out.println("Jugador " + ap1.get(1).getNombre() + " elige tu accion: (piedra/papel/tijera)");
                choice = sc.next().toLowerCase();
                ch1.put(ap1.get(1), choice);
            } while (isCorrect(choice));
            if (ch1.get(ap1.get(0)).equals(ch1.get(ap1.get(1))))
                System.out.println("Ambos habeis sacado lo mismo. REPETICION DE TIRADA!");
        } while (ch1.get(ap1.get(0)).equals(ch1.get(ap1.get(1))));
        checkWinner(ch1.get(ap1.get(0)), ch1.get(ap1.get(1)));
    }

    private void checkWinner(String resp1, String resp2) {
        boolean check = true;
        if (resp1.equals("piedra") && resp2.equals("papel")) {
            System.out.println("Jugador " + ap1.get(1).getNombre() + " gana!");
            check = true;
        }
        if (resp2.equals("piedra") && resp1.equals("papel")) {
            System.out.println("Jugador " + ap1.get(0).getNombre() + " gana!");
            check = false;
        }
        if (resp1.equals("papel") && resp2.equals("tijera")) {
            System.out.println("Jugador " + ap1.get(1).getNombre() + " gana!");
            check = true;
        }
        if (resp1.equals("tijera") && resp2.equals("papel")) {
            System.out.println("Jugador " + ap1.get(0).getNombre() + " gana!");
            check = false;
        }
        if (resp1.equals("piedra") && resp2.equals("tijera")) {
            System.out.println("Jugador " + ap1.get(0).getNombre() + " gana!");
            check = false;
        }
        if (resp1.equals("tijera") && resp2.equals("piedra")) {
            System.out.println("Jugador " + ap1.get(1).getNombre() + " gana!");
            check = true;
        }
        if (check){
            Aux.Rewards(ap1.get(1),ap1.get(0));
        }else{
            Aux.Rewards(ap1.get(0),ap1.get(1));
        }
    }

    private boolean isCorrect(String choice) {
        switch (choice) {
            case "tijera":
            case "papel":
            case "piedra":
                return false;
            default:
                return true;
        }
    }
}
