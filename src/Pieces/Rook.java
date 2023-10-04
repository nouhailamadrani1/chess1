package Pieces;

public class Rook extends Piece {


    public Rook(String icon,String color) {
        super(icon,color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece[][] chessBoard) {

        if (fromRow == toRow && fromCol == toCol) {
            System.out.println("Invalid move! ");
            return false;
        }


        if (toRow == fromRow || toCol == fromCol) {
            System.out.println("Valid move!");
            return true;
        }

        System.out.println("Invalid move!");
        return false;
    }




}
