package Pieces;

public class Knight extends Piece {
    public Knight(String icon,String color) {
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

    public static boolean isKnight(Piece piece) {
        return piece.equals("♘") || piece.equals("♞");
    }

}
