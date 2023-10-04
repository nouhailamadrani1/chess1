package Pieces;

public class King extends Piece {

    public King(String icon, String color) {
        super(icon, color);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece[][] chessBoard) {
        // Check if the move is a valid regular move
        if ((toCol == fromCol + 1 && toRow == fromRow) ||
                (toCol == fromCol - 1 && toRow == fromRow) ||
                (toRow == fromRow + 1 && toCol == fromCol) ||
                (toRow == fromRow - 1 && toCol == fromCol) ||
                (toCol == fromCol + 1 && toRow == fromRow + 1) ||
                (toCol == fromCol - 1 && toRow == fromRow + 1) ||
                (toCol == fromCol + 1 && toRow == fromRow - 1) ||
                (toCol == fromCol - 1 && toRow == fromRow - 1)) {
            // Check if the move puts the king in check
            if (isKingInCheck(fromRow, fromCol, toRow, toCol, chessBoard)) {
                System.out.println("Invalid move! King is in check.");
                return false;
            } else {
                System.out.println("Valid move!");
                return true;
            }
        } else {
            System.out.println("Invalid move!");
            return false;
        }
    }

    private boolean isKingInCheck(int fromRow, int fromCol, int toRow, int toCol, Piece[][] chessBoard) {
        // Simulate the move on a temporary board
        Piece[][] tempBoard = new Piece[chessBoard.length][chessBoard[0].length];
        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard[row].length; col++) {
                tempBoard[row][col] = chessBoard[row][col];
            }
        }
        tempBoard[toRow][toCol] = tempBoard[fromRow][fromCol];
        tempBoard[fromRow][fromCol] = null;

        // Check if the king is under attack
        int kingRow = -1;
        int kingCol = -1;
        String kingColor = chessBoard[fromRow][fromCol].getColor();

        // Find the king's position
        for (int row = 0; row < tempBoard.length; row++) {
            for (int col = 0; col < tempBoard[row].length; col++) {
                Piece piece = tempBoard[row][col];
                if (piece != null && piece instanceof King && piece.getColor().equals(kingColor)) {
                    kingRow = row;
                    kingCol = col;
                    break;
                }
            }
        }

        // Check if any opponent pieces can attack the king
        for (int row = 0; row < tempBoard.length; row++) {
            for (int col = 0; col < tempBoard[row].length; col++) {
                Piece piece = tempBoard[row][col];
                if (piece != null && !piece.getColor().equals(kingColor)) {
                    if (piece.isValidMove(row, col, kingRow, kingCol, tempBoard)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}