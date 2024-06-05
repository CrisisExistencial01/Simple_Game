package game.personajes;
import java.util.Random;
import game.accesorios.Pocion;
import game.accesorios.Arma;
import game.estetica.Color;
import static game.estetica.prettier.prettier;

public class Personaje {
    protected String nombre;
    protected int hp;
    protected int ataque;
    protected int defensa;
    protected Pocion pocion;
    protected Arma arma;

    public Personaje(String nombre, int hp, int ataque, int defensa, Pocion pocion, Arma arma){
        visitarSantuario();
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.pocion = pocion;
        this.arma = arma;
    }
    public void mostrarEstado(){
        System.out.println("Nombre: " + nombre + prettier("\nvida: ", Color.GREEN)+ hp + prettier("\t\tAtaque: ", Color.CYAN) + ataque + prettier("\t\tDefensa: ", Color.YELLOW) + defensa);

    }
    public boolean calcularVidaParaPocion(){
        boolean estado = false;
        if (this.hp <= 10){
            estado = true;
        }
        return estado;
    }
    public void recibirDaño(int daño){
        System.out.printf("HP: ", hp);
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
        if (!this.estaVivo()){
            System.out.println("Me morí >:c");
        }else{
            System.out.println(this.nombre + " ataca a " + enemigo.nombre);

            int daño = this.calcularDaño() - enemigo.defensa;

        enemigo.recibirDaño(daño);
        }
    }
    public void usarPocion(){
        this.hp += this.pocion.getCuracion();
    }
    public int calcularDaño(){
        return this.ataque + this.arma.getPoderDeAtaque();
    }

    public boolean probabilidadSantuario(){
        boolean santuario = new Random().nextBoolean();
        return santuario;
    }
    public void visitarSantuario(){
        if (probabilidadSantuario()){
            this.defensa += 2;
        }
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getHp(){
        return this.hp;
    }
}
