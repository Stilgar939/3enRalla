package Clases;

public class Persona {
    private String nombre;
    private int tiempo;
    private float coin;
    public float bet = 100;

    public Persona(String nombre, int tiempo, float coin) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.coin = coin;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
        tiempo = 0;
        coin = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public float getCoin() {
        return coin;
    }

    public void setCoin(float coin) {
        this.coin = coin;
    }

    public float getBet() {
        return bet;
    }

    public void setBet(float bet) {
        this.bet = bet;
    }
}

