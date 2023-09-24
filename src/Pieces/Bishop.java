package Pieces;

public class Bishop  extends Piece {
    public Bishop(String icon,String color) {
        super(icon,color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece chessBoard) {



        if (Math.abs(toRow - fromRow) == Math.abs(toCol - fromCol)) {
            System.out.println("Valid move!");
            return true;
        }

        System.out.println("Invalid move! ");
        return false;
    }


}
