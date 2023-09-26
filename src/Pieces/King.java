package Pieces;

public class King extends Piece {


    public King(String icon,String color) {
        super(icon, color);

    }


    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece[][] chessBoard) {


        if ((toCol == (fromCol + 1) && toRow == fromRow) ||
                (toCol == (fromCol - 1) && toRow == fromRow) ||
                (toRow == (fromRow + 1) && toCol == fromCol) ||
                (toRow == (fromRow - 1) && toCol == fromCol) ||
                (toCol == (fromCol + 1) && toRow == (fromRow + 1)) ||
                (toCol == (fromCol - 1) && toRow == (fromRow + 1)) ||
                (toCol == (fromCol + 1) && toRow == (fromRow - 1)) ||
                (toCol == (fromCol - 1) && toRow == (fromRow - 1))) {
            System.out.println("Valid move!");
            return true;
        } else {
            System.out.println("Invalid move!");
            return false;
        }
    }


}



