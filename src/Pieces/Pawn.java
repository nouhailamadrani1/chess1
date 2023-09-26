package Pieces;

public class Pawn extends Piece {

    public Pawn(String icon,String color) {
        super(icon,color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece[][] chessPieces) {
        Piece targetPiece = chessPieces[toRow][toCol];

        if (this.getColor().equals("white")) {
            if (toRow == fromRow + 1 && fromCol == toCol) {
                System.out.println("Valid move!");
                return true;
            } else if (fromRow == 1) {
                if ((toRow == fromRow + 1 || toRow == fromRow + 2) && fromCol == toCol) {
                    System.out.println("Valid move!");
                    return true;
                }
            } else if (targetPiece != null && ((toRow == fromRow + 1 && toCol == fromCol + 1) || (toRow == fromRow + 1 && toCol == fromCol - 1))) {
                System.out.println("Valid move!");
                return true;
            } else {
                return false;
            }
        } else if (this.getColor().equals("black")) {
            if (toRow == fromRow - 1 && fromCol == toCol) {
                System.out.println("Valid move!");
                return true;
            } else if (fromRow == 6) {
                if ((toRow == fromRow - 1 || toRow == fromRow - 2) && fromCol == toCol) {
                    System.out.println("Valid move!");
                    return true;
                }
            } else if (targetPiece != null && ((toRow == fromRow - 1 && toCol == fromCol + 1) || (toRow == fromRow - 1 && toCol == fromCol - 1))) {
                System.out.println("Valid move!");
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

//    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece chessBoard) {
//
//        Piece[][] chessPieces1 = new Piece[0][];
//        Piece targetPiece = chessPieces1[toRow][toCol];
//        if (this.getColor().equals("white")) {
//            if (toRow ==fromRow + 1 && fromCol == toCol) {
//                System.out.println("Valid move!");
//                return true;
//            } else if (fromRow== 1 ) {
//                if (toRow ==fromRow + 1 && fromCol == toCol  || toRow ==fromRow + 2 && fromCol == toCol){
//                    System.out.println("Valid move!");
//                    return true;
//                }
//
//            } else if (targetPiece != null && toRow == fromRow + 1 && toCol == fromCol+1 || toRow == fromRow + 1 && toCol == fromCol - 1 ) {
//
//                    System.out.println("Valid move!");
//                    return true;
//                }else {
//                return false;
//            }
//
//        } else if (this.getColor().equals("black")) {
//            if (toRow ==fromRow - 1 && fromCol == toCol)  {
//                System.out.println("Valid move!");
//                return true;
//
//            } else if (fromRow== 6 ) {
//                if (toRow ==fromRow - 1 && fromCol == toCol || toRow ==fromRow - 2 && fromCol == toCol){
//                    System.out.println("Valid move!");
//                    return true;
//                }
//            }
//
//            else if (targetPiece != null && toRow == fromRow - 1 && toCol == fromCol+1 || toRow == fromRow - 1 && toCol == fromCol - 1 ) {
//
//                System.out.println("Valid move!");
//                return true;
//            }
// else {
//                return false;
//            }
//
//
//        }
//    return true;
//
//      }
}