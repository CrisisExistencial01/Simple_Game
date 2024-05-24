package game.personajes;

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
            enemigo.hp -= daño;
            this.mana -= 10;
        }
    }

    public void usarPocion(){
        this.hp += this.pocion.getCuracion();
        this.mana += 10;
    }

    public int calcularDaño(){
        return this.ataque + this.arma.getPoderDeAtaque() + this.poderMagico;
    }
}