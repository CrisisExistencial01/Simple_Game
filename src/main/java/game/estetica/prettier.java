package game.estetica;

public class prettier {
    public static String prettier(String message, Color color) {
        return color.getCode() + message + Color.RESET.getCode();
    }
}
