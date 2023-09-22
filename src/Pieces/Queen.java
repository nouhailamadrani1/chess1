package Pieces;

public class Queen extends Piece {

    public Queen() {

        this.icon="♔";
    }
    public Queen(String icon) {

        this.icon=icon;
    }
    public static boolean isQueen(String piece) {
        return piece.equals("♔") || piece.equals("♚");
    }

}
