package Pieces;

public class King extends Piece {
    public King() {

        this.icon="♕";
    }
    public King(String icon) {

        this.icon=icon;
    }
    public static boolean isKing(String piece) {
        return piece.equals("♕") || piece.equals("♛");
    }



}
