package Pieces;

public class King extends Piece {


    public King(String icon,String color) {
        super(icon, color);

    }

    public static boolean isKing(Piece piece) {
        return piece.equals("♕") || piece.equals("♛");
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



