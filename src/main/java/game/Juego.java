package game;
import game.accesorios.*;
import game.personajes.*;
public class Juego {
    private Personaje jugador1;
    private Personaje jugador2;
    private int turnoActual;
    private int turnoMostrable;


    public void iniciarCombate(){
        jugador1 = new Guerrero("Guerrero", 100, 10, 5, new Pocion("Pocion de vida", 10), new Arma("Espada", 10, 1), 15);
        jugador2 = new Mago("Mago", 100, 8, 3, new Pocion("Pocion de vida", 10), new Arma("Baculo", 8, 1), 20, 10);
        jugador1.mostrarEstado();
        jugador2.mostrarEstado();
        turnoActual = 1;
        turnoMostrable = 1;
        while (this.jugador1.estaVivo() && this.jugador2.estaVivo()) {
            this.siguienteTurno();
        }
    }
    public void turnoDeAtaque(Personaje atacante, Personaje defensor){
        atacante.atacar(defensor);
        atacante.mostrarEstado();
        defensor.mostrarEstado();
        declararGanador(atacante, defensor);
    }
    public void siguienteTurno(){
        if (turnoActual == 1) {
            turnoDeAtaque(jugador1, jugador2);
            turnoActual = 2;
        } else {
            turnoDeAtaque(jugador2, jugador1);
            turnoActual = 1;
        }
        turnoMostrable++;
    }
    public void declararGanador(Personaje p1, Personaje p2){
        if (!p1.estaVivo()){
            System.out.println(p2.getNombre() + " ha ganado!");
        } else if(!p2.estaVivo()) {
            System.out.println(p1.getNombre() + " ha ganado!");
        }
        else{
            System.out.println("El combate continua!");
        }
    }
}