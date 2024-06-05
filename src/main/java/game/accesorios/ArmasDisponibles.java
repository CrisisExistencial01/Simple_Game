package game.accesorios;

import game.accesorios.Arma;
import game.accesorios.DamageType;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;

public class ArmasDisponibles {
    private static ArrayList<Arma> armas = new ArrayList<>();
    static {
        armas.add(new Arma("Espada de hierro", 10, DamageType.FISICO));
        armas.add(new Arma("Hacha de batalla", 12, DamageType.FISICO));
        armas.add(new Arma("Varita mágica", 8, DamageType.MAGICO));
        armas.add(new Arma("Bastón de poder", 10, DamageType.MAGICO));

    }

    public static Arma getArmaRandom(DamageType t){
        ArrayList<Arma> armasDisponibles = new ArrayList<>();
        for (Arma arma : armas) {
            if (arma.getDmgType() == t) {
                armasDisponibles.add(arma);
            }
        }
        return armasDisponibles.get(new Random().nextInt(armasDisponibles.size()));
    }

}
