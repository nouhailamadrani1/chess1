package Pieces;

public class Pawn extends Piece {
    public Pawn() {

        this.icon="♙";
    }
    public Pawn(String icon) {

        this.icon=icon;
    }
    public static boolean isPawn(String piece) {
        return piece.equals("♙") || piece.equals("♟");
    }

}
