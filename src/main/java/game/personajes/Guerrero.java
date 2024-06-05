package game.personajes;
import game.accesorios.Arma;
import game.accesorios.Pocion;

import game.estetica.Color;
import static game.estetica.prettier.prettier;

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
    public void mostrarEstado(){
        super.mostrarEstado();
        System.out.println(prettier("Daño fisico: ", Color.PURPLE) + this.getDañoDeClase());
    }
    public int calcularDaño(){
        return this.ataque + this.getDañoDeClase();
    }

    public int getDañoDeClase(){
        return this.fuerza + this.arma.getPoderDeAtaque();
    }
}