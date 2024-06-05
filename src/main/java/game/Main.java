package game;
import game.personajes.*;
import game.accesorios.Pocion;
import game.accesorios.Arma;
public class Main{
    public static void main(String [] args){
        /*
        Juego juego = new Juego();
        juego.iniciarJuego();
        */
        Personaje P1 = new Personaje("P1", 100, 10, 5, new Pocion("Pocion de vida", 10), new Arma("Espada", 10, 1));
        P1.probabilidadSantuario();
    }
}