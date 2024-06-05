package game;

import game.personajes.*;
public class Juego {
    public void iniciarCombate(Personaje p1, Personaje p2){

    }
    public void turnoDeAtaque(Personaje atacante, Personaje defensor){
        atacante.atacar(defensor);
        declararGanador(atacante, defensor);
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