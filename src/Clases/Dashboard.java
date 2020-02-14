package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Dashboard {
    int len = 8, turnos = 0, mv;
    char[][] board = new char[len][len];
    HashMap<Integer, Integer> altura = new HashMap<Integer, Integer>();
    Scanner sc = new Scanner(System.in);

    public void Start() {
        fillBoard();
        showBoard();
        playGame();
    }

    private void playGame(){
        do {
            nextMove();
        }while (winner());
    }

    private void fillBoard() {
        for (int i = 0; i < len; i++) {
            for (int k = 0; k < len; k++) {
                board[i][k] = ' ';
            }
            altura.put(i, 7);
        }
    }


    public void showBoard() {
        System.out.println("      1   2   3   4   5   6   7   8   ");
        System.out.println("+---------------------------------------+");
        for (int i = 0; i < 8; i++) {
            System.out.print("|     ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "   ");
            }
            System.out.print("  |");
            System.out.println("\n|                                       |");

        }
        System.out.println("+---------------------------------------+");

    }

    public void nextMove() {
        // hashset para la altitud de la tabla
        String nextmv = "";
        do {
            System.out.println("En que columna deseas poner la siguiente ficha?");
            nextmv = sc.next();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (Aux.isCorrect(nextmv));
        int alt = altura.get(Integer.parseInt(nextmv) - 1);
        if (alt == -1) {
            System.out.println("Esa columna esta llena");
            showBoard();
            nextMove();
        }
        makeMove(nextmv);

    }

    // para los turnos coger el turno % si es 0 una X si es 1 una O
    private void makeMove(String nextmv) {
        mv = Integer.parseInt(nextmv);
        mv -= 1;
        if (turnos % 2 == 0) {
            board[altura.get(mv)][mv] = 'X';
        } else {
            board[altura.get(mv)][mv] = 'O';
        }
        turnos++;
        altura.replace(mv, altura.get(mv) - 1);
        showBoard();
    }

    public boolean winner() {
        int count = 0;
        HashMap<Integer,Integer> checkedPositions = new HashMap<>();
        Character variable;
        for (int m = -1; m < 2; m++) {
            for (int n = -1; n < 2; n++) {
                try {
                    variable = board[altura.get(mv) + n][mv + m];
                }catch (Exception e){
                    variable = '0';
                }
                System.out.println(variable);
                System.out.println(count);
                if (mv+m < 0 ||mv + m >= 8 || (mv)+n < 0 || (mv)+n >= 8)
                    continue;
                if (variable.equals(board[altura.get(mv)+n][mv+m])) {
                    count++;
                    if (variable.equals(board[altura.get(mv)+(n*-1)][mv+(m*-1)])){
                        count++;
                    }else{
                        variable = board[altura.get(mv)+n][mv+m];
                        m = -1;
                        n = -1;
                    }
                    if (count == 4) {
                        System.out.println("HAS GANADO!");
                        return false;
                    }
                } else if (variable.equals('0')) {
                    continue;
                }else{
                    return true;
                }
            }
        }
        return true;
    }
}
