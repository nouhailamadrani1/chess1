package Pieces;

public class Bishop  extends Piece {
    public Bishop(String icon,String color) {
        super(icon,color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece chessBoard) {


        if (toRow ==fromRow + 1 && fromCol == toCol) {
            System.out.println("Valid move!");
            return true;
        } else {
            System.out.println("Invalid move!");
            return false;
        }
    }

    public static boolean isBishop(Piece piece) {
        return piece.equals("♗") || piece.equals("♝");
    }


}
