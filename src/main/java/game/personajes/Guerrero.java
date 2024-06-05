package game.personajes;
import game.accesorios.Arma;
import game.accesorios.Pocion;
public class Guerrero extends Personaje {
    private int fuerza;
    public Guerrero(String nombre, int hp, int ataque, int defensa, Pocion pocion, Arma arma, int fuerza){
        super(nombre, hp, ataque, defensa, pocion, arma);
        this.fuerza = fuerza;
    }
    public void atacar(Personaje enemigo){
        int daño = this.calcularDaño() - enemigo.defensa;
        enemigo.hp -= daño;
    }
    public int calcularDaño(){
        return this.ataque + this.arma.getPoderDeAtaque() + this.fuerza;
    }
}