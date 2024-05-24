package game.accesorios;

public class Pocion{
    private String nombre;
    private int curacion;
    
    public Pocion(String nombre, int curacion){
        this.nombre = nombre;
        this.curacion = curacion;
    }

    public int getCuracion(){
        return this.curacion;
    }
}