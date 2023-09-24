package Pieces;

public class Queen extends Piece {

    public Queen(String icon,String color) {
        super(icon,color);
    }
    public static boolean isQueen(Piece piece) {
        return piece.equals("♔") || piece.equals("♚");
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

}
