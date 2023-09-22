package Pieces;

public class Bishop  extends Piece {
    public Bishop() {
     this.icon="♗";
    }
    public Bishop(String icon) {

        this.icon=icon;
    }

    public static boolean isBishop(String piece) {
        return piece.equals("♗") || piece.equals("♝");
    }


}
