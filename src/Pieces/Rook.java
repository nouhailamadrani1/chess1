package Pieces;

public class Rook extends Piece {
    public Rook() {

        this.icon="♖";
    }
       public Rook(String icon) {

        this.icon=icon;
    }

    public static boolean isRook(String piece) {
        return piece.equals("♖") || piece.equals("♜");
    }


}
