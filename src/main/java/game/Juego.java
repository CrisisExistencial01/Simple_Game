package game;
import game.accesorios.*;
import game.personajes.*;

import java.util.Random;

import static game.estetica.prettier.prettier;
import game.estetica.Color;
public class Juego {
    private Personaje jugador1;
    private Personaje jugador2;
    private int turnoActual;
    private int turnoMostrable;


    public void iniciarCombate(){
        jugador1 = new Guerrero("Guerrero", 100, 9, 5, new Pocion("Pocion de vida", 20), null, 15);
        jugador2 = new Mago("Mago", 100, 8, 4, new Pocion("Pocion de vida", 20), null, 100, 14);

        asignarArma(jugador1);
        asignarArma(jugador2);

        jugador1.mostrarEstado();
        jugador2.mostrarEstado();

        turnoActual = 1;
        turnoMostrable = 1;

        while (this.jugador1.estaVivo() && this.jugador2.estaVivo()) {
            this.siguienteTurno();
        }
    }
    public void asignarArma(Personaje personaje){
        if(personaje instanceof Mago) {
            personaje.setArma(ArmasDisponibles.getArmaRandom(DamageType.MAGICO));
        }else if (personaje instanceof Guerrero){
            personaje.setArma(ArmasDisponibles.getArmaRandom(DamageType.FISICO));
        }else{
            //bueno, nada, por escalabilidad, si hay más tipos esto se rellena.
        }
    }

    public void turnoDeAtaque(Personaje atacante, Personaje defensor){

        if (atacante.calcularVidaParaPocion() && atacante.tienePocion()){
            atacante.usarPocion();
        }else{
            atacante.atacar(defensor);
            System.out.println(atacante.getNombre()+ prettier(" ha usado una pocion!", Color.RED));
        }
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
        System.out.println("");
    }
    public void declararGanador(Personaje p1, Personaje p2){
        System.out.println("");
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