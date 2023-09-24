package Pieces;

public class Rook extends Piece {


    public Rook(String icon,String color) {
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

    public static boolean isRook(Piece piece) {
        return piece.equals("♖") || piece.equals("♜");
    }


}
