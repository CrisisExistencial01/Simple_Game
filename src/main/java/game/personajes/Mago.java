package game.personajes;

import game.estetica.Color;
import game.personajes.Personaje;
import game.accesorios.Pocion;
import game.accesorios.Arma;
import static game.estetica.prettier.prettier;
public class Mago extends Personaje {
    private int mana;
    private int poderMagico;

    public Mago(String nombre, int hp, int ataque, int defensa, Pocion pocion, Arma arma, int mana, int poderMagico){
        super(nombre, hp, ataque, defensa, pocion, arma);
        this.mana = mana;
        this.poderMagico = poderMagico;
    }

    public void atacar(Personaje enemigo){
        int daño = this.calcularDaño() - enemigo.defensa;

        if (this.mana >= 10){
            enemigo.recibirDaño(daño);
            this.mana -= 10;
        }
    }
    public void mostrarEstado(){
        super.mostrarEstado();
        System.out.println(prettier("Daño magico: ", Color.PURPLE) + this.getDañoDeClase() + prettier("\t\tMana: ", Color.PURPLE) + this.mana);
    }

    public void usarPocion(){
        this.hp += this.pocion.getCuracion();
        this.mana += 10;
    }
    public int calcularDaño(){
        return this.ataque + getDañoDeClase();
    }
    public int getDañoDeClase(){
        return (int) (this.arma.getPoderDeAtaque() * 0.3 * this.poderMagico);
    }
}