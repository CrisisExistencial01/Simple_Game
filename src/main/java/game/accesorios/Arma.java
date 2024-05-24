package game;

public class Arma{
    private String nombre;
    private int poderDeAtaque;
    int tipoDeDaño;
    
    public Arma(String nombre, int poderDeAtaque, int tipoDeDaño){
        this.nombre = nombre;
        this.poderDeAtaque = poderDeAtaque;
        this.tipoDeDaño = tipoDeDaño;
    }

    public int getPoderDeAtaque(){
        return this.poderDeAtaque;
    }
}