package Clases;

import java.util.ArrayList;
import java.util.Scanner;
//TODO GUESSTHENUMBER DONE
public class Number extends Game implements Comparable<Integer>{
    //TODO compare TO para comparar los dos numeros
    public Number(ArrayList<Persona> pp) {
        ap1 = pp;
    }
    public void Start() {
        int number;
        System.out.println("El intervalo sera entre 0 a 200\n");
        System.out.println("Jugador " + ap1.get(0).getNombre()+ " escoge numero");
        number = choseNumber();
        int chose = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Jugador " + ap1.get(1).getNombre()+ ", preparate para elegir numeros\n");

        for (int tries = 8; tries > 0; tries--){
            try {
                System.out.println("Elige un numero");
                chose = sc.nextInt();
                hint(chose, number);
                System.out.println("Te quedan " + tries + " intentos");
            } catch (Exception e) {
                System.out.println("ESO NO ES UN NUMERO!");
                chose = -1;
            }
            if (chose == number){
                System.out.println("Jugador " + ap1.get(1).getNombre()+ " has ganado! \n");
                Aux.Rewards(ap1.get(1),ap1.get(0));
                break;
            }else if (tries == 1){
                System.out.println("Jugador " + ap1.get(0).getNombre()+ " has ganado! \n");

                Aux.Rewards(ap1.get(0),ap1.get(1));
                break;
            }
        }

        System.out.println("El numero era " + number + "!");
    }

    private void hint(int chose, int number) {
        if (number < chose)
            System.out.println("El numero es mas pequeño");
        if (number > chose)
            System.out.println("El numero es mas grande");
    }

    private int choseNumber() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            try {
                System.out.println("Elige un numero");
                num = sc.nextInt();
            } catch (Exception e) {
                System.out.println("ESO NO ES UN NUMERO VALIDO!");
                num = 2000;
            }
        } while (num < 0 || num > 200);
        return num;
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
