package Pieces;

public class Knight extends Piece {
    public Knight() {
        this.icon="♘";
    }
    public Knight(String icon) {

        this.icon=icon;
    }
    public static boolean isKnight(String piece) {
        return piece.equals("♘") || piece.equals("♞");
    }

}
