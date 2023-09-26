package Pieces;

public class Knight extends Piece {
    public Knight(String icon, String color) {
        super(icon, color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece[][] chessBoard) {



        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            System.out.println("Valid move");
            return true;
        }

        System.out.println("Invalid move");
        return false;
    }

}
