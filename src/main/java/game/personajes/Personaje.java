package game.personajes;
import java.util.Random;
public class Personaje {
    protected String nombre;
    protected int hp;
    protected int ataque;
    protected int defensa;
    protected Pocion pocion;
    protected Arma arma;

    public Personaje(String nombre, int hp, int ataque, int defensa, Pocion pocion, Arma arma){
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.pocion = pocion;
        this.arma = arma;
    }
    public boolean calcularVidaParaPocion(){
        boolean estado = true;
        if (this.hp <= )
        return estado;
    }
    public void recibirDaño(int daño){
        this.hp -= daño;
    }
    public boolean estaVivo(){
        boolean estado = true;
        if (this.hp <= 0){
            estado = false;
        }
        return estado;
    }
    public void atacar(Personaje enemigo){
        int daño = this.calcularDaño() - enemigo.defensa;

        enemigo.hp -= daño;
    }
    public void usarPocion(){
        this.hp += this.pocion.getCuracion();
    }
    public int calcularDaño(){
        return this.ataque + this.arma.getPoderDeAtaque();
    }
    public boolean probabilidadSantuario(){
        return new Random().nextBoolean();
    }
    public void visitarSantuario(){
        if (probabilidadSantuario()){
            this.hp = 100;
        }
    }

}
