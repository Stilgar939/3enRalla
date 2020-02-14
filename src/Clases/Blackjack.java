package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
// TODO BLACKJACK DONE
public class Blackjack extends Game {
    public Blackjack(ArrayList<Persona> pp) {
        ap1 = pp;
    }
    public void Start() {

        ArrayList<Integer> deck = new ArrayList<Integer>();
        fillDeck(deck);
        int t1,t2;
        System.out.println("Jugador " + ap1.get(0).getNombre() + " preparate para jugar");
        t1 = play(deck);
        System.out.println("Jugador " + ap1.get(1).getNombre() + " preparate para jugar");
        t2 = play(deck);
        if (t1 > 21 && t2 > 21){
            System.out.println("Ambos os habeis pasado. EMPATE");
        }
        if (t1 > t2){
            if (t1 > 21){
                System.out.println("JUGADOR "+ap1.get(1).getNombre()+" GANA!");
                Aux.Rewards(ap1.get(1),ap1.get(0));
            }else{
                System.out.println("JUGADOR "+ap1.get(0).getNombre()+" GANA!");
                Aux.Rewards(ap1.get(0),ap1.get(1));
            }
        }else if (t1 < t2){
            if (t2 > 21){
                System.out.println("JUGADOR "+ap1.get(0).getNombre()+" GANA!");
                Aux.Rewards(ap1.get(0),ap1.get(1));
            }else{
                System.out.println("JUGADOR "+ap1.get(1).getNombre()+" GANA!");
                Aux.Rewards(ap1.get(1),ap1.get(0));
            }
        }
    }

    private int play(ArrayList<Integer> deck) {
        ArrayList<Integer> pdeck = new ArrayList<>();
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int turn,total;
        for (turn = 1;turn < deck.size(); turn++) {
            if (turn < 3) {
                pdeck.add(deck.get(r.nextInt(deck.size()+1)));
                deck.remove(pdeck.get(turn-1));
                total = muestraDeck(pdeck);
            } else {
                Character chose;
                    System.out.println("Quieres otra carta? (pulsa cualquer caracter para recibir pulsa n para plantarte)");
                    chose = sc.next().charAt(0);
                if (!chose.equals('n')){
                    pdeck.add(deck.get(r.nextInt(deck.size()+1)));
                    deck.remove(pdeck.get(turn-1));
                    total = muestraDeck(pdeck);
                    if (total > 21){
                        System.out.println("TE HAS PASADO! HAS PERDIDO!\n\n");
                        return total;
                    }
                }else{
                    total = muestraDeck(pdeck);
                    return total;
                }
            }
        }
        return Integer.parseInt(null);
    }

    private int muestraDeck(ArrayList<Integer> pdeck){
        System.out.println("Tu baraja ahora mismo es " + pdeck.toString());
        int total = 0;
        for (int k = 0; k < pdeck.size(); k++) {
            total += pdeck.get(k);
        }
        System.out.println("El numero total es: " + total+"\n");
        return total;
    }

    private void fillDeck(ArrayList<Integer> deck) {
        for (int k = 0; k < 4; k++) {
            for (int i = 1; i < 14; i++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);
    }
}
