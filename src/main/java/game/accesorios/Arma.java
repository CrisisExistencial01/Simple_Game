package game.accesorios;

public class Arma{
    private String nombre;
    private int poderDeAtaque;
    DamageType dmgType;

    public Arma(String nombre, int poderDeAtaque, DamageType dmgType){
        this.nombre = nombre;
        this.poderDeAtaque = poderDeAtaque;
        this.dmgType = dmgType;
    }

    public int getPoderDeAtaque(){
        return this.poderDeAtaque;
    }
    public DamageType getDmgType(){
        return this.dmgType;
    }
}