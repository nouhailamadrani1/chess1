package chess;

import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class ChessBoard extends JPanel {
    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 70;
    private boolean isWhiteTurn = true;
    private Piece[][] chessPieces = new Piece[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chessboard");
        ChessBoard chessBoard = new ChessBoard();

        frame.add(chessBoard);
        frame.setSize(BOARD_SIZE * SQUARE_SIZE, BOARD_SIZE * SQUARE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chess Piece Movement:");
            System.out.println("Enter (fromRow, fromCol):");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();


            if (chessBoard.getPieceAt(fromRow, fromCol) != null) {
                Piece pieceToMove = chessBoard.getPieceAt(fromRow, fromCol);
                System.out.println("There is a piece at (" + fromRow + ", " + fromCol + ")");

                if (pieceToMove instanceof Pawn) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a Pawn.");
                } else if (pieceToMove instanceof King) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a King.");
                } else if (pieceToMove instanceof Knight) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a Knight.");
                } else if (pieceToMove instanceof Queen) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a Queen.");
                } else if (pieceToMove instanceof Rook) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a Rook.");
                } else if (pieceToMove instanceof Bishop) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a Bishop.");
                }

                System.out.println("Enter (toRow, toCol):");
                int toRow = scanner.nextInt();
                int toCol = scanner.nextInt();

                chessBoard.movePiece(fromRow, fromCol, toRow, toCol);

            } else {
                System.out.println("There is no piece at (" + fromRow + ", " + fromCol + ")");
            }
        }
    }

    public ChessBoard() {
        initializeBoard();
    }

    public Piece getPieceAt(int row, int col) {

        return chessPieces[row][col];
    }

//    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
//        Piece pieceToMove = chessPieces[fromRow][fromCol];
//        Piece targetPiece = chessPieces[toRow][toCol];
//
//        if ((isWhiteTurn && pieceToMove != null && pieceToMove.getColor().equals("white")) ||
//                (!isWhiteTurn && pieceToMove != null && pieceToMove.getColor().equals("black"))) {
//
//            if (pieceToMove.isValidMove(fromRow, fromCol, toRow, toCol, chessPieces[fromRow][fromCol])) {
//                if (targetPiece != null && targetPiece.getColor() != pieceToMove.getColor()) {
//
//
//
//                    chessPieces[toRow][toCol] = null;
//                    System.out.println("Captured the opponent's piece: " + targetPiece.getIcon());
//                } else if (targetPiece != null && targetPiece.getColor() == pieceToMove.getColor()) {
//                    System.out.println("Invalid move! This is your piece: " + targetPiece.getIcon());
//                    return;
//
//                }
//
//                chessPieces[fromRow][fromCol] = null;
//                pieceToMove.setPosition(toRow, toCol);
//                chessPieces[toRow][toCol] = pieceToMove;
//                repaint();
//
//                isWhiteTurn = !isWhiteTurn;
//                System.out.println("Good move!");
//            } else {
//                System.out.println("Invalid move!");
//            }
//        } else {
//            System.out.println("It is not your turn!");
//        }
//    }


    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        Piece pieceToMove = chessPieces[fromRow][fromCol];
        Piece targetPiece = chessPieces[toRow][toCol];
            if (targetPiece != null && targetPiece.getIcon("♙").equals("♙") && pieceToMove.getIcon("♟").equals("♟") && toRow == fromRow - 1 && fromCol == toCol) {
            System.out.println("Invalid move! ");
            return;
        }
        else if (targetPiece != null && targetPiece.getIcon("♟").equals("♟") && pieceToMove.getIcon("♙").equals("♙") && toRow == fromRow + 1 && fromCol == toCol) {
            System.out.println("Invalid move! ");
            return;
        }
        if (!pieceToMove.getIcon("♘").equals("♘") && !pieceToMove.getIcon("♞").equals("♞")) {
            for (int i = fromRow; i <= toRow; i++) {
                for (int j = fromCol; j <= toCol; j++) {
                    if (chessPieces[i][j] != null) {
                        System.out.println("Invalid move! There is a piece in the line.");
                        return;
                    }
                }
            }
        }

        if ((isWhiteTurn && pieceToMove != null && pieceToMove.getColor().equals("white")) ||
                (!isWhiteTurn && pieceToMove != null && pieceToMove.getColor().equals("black"))) {

            if (pieceToMove.isValidMove(fromRow, fromCol, toRow, toCol,chessPieces)) {
                if (targetPiece != null && targetPiece.getColor() != pieceToMove.getColor()) {
                    chessPieces[toRow][toCol] = null;
                    System.out.println("Captured the opponent's piece: " + targetPiece.getIcon("♙"));
                } else if (targetPiece != null && targetPiece.getColor() == pieceToMove.getColor()) {
                    System.out.println("Invalid move! This is your piece: " + targetPiece.getIcon("♙"));
                    return;
                }


                chessPieces[fromRow][fromCol] = null;
                pieceToMove.setPosition(toRow, toCol);
                chessPieces[toRow][toCol] = pieceToMove;
                repaint();

                isWhiteTurn = !isWhiteTurn;
                System.out.println("Good move!");
            } else {
                System.out.println("Invalid move!");
            }
        } else {
            System.out.println("It is not your turn!");
        }
    }
//public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
//    Piece pieceToMove = chessPieces[fromRow][fromCol];
//    Piece targetPiece = chessPieces[toRow][toCol];
//
//    if ((isWhiteTurn && pieceToMove != null && pieceToMove.getColor().equals("white")) ||
//            (!isWhiteTurn && pieceToMove != null && pieceToMove.getColor().equals("black"))) {
//
//        if (pieceToMove.isValidMove(fromRow, fromCol, toRow, toCol, chessPieces[fromRow][fromCol])) {
//            if (pieceToMove.getIcon().equals("♙") && (
//                    (toRow == fromRow + 1 && toCol == fromCol + 1) ||
//                            (toRow == fromRow + 1 && toCol == fromCol - 1)
//            )) {
//                if (targetPiece != null && targetPiece.getColor() != pieceToMove.getColor()) {
//                    chessPieces[toRow][toCol] = null;
//                    System.out.println("Captured the opponent's piece: " + targetPiece.getIcon());
//                } else {
//                    System.out.println("Invalid move! No opponent's piece to capture.");
//                    return;
//                }
//                // Rest of your code for a valid move...
//            } else if (pieceToMove.getIcon().equals("♟") && (
//                    (toRow == fromRow - 1 && toCol == fromCol + 1) ||
//                            (toRow == fromRow - 1 && toCol == fromCol - 1)
//            )) {
//                if (targetPiece != null && targetPiece.getColor() != pieceToMove.getColor()) {
//                    chessPieces[toRow][toCol] = null;
//                    System.out.println("Captured the opponent's piece: " + targetPiece.getIcon());
//                } else {
//                    System.out.println("Invalid move! No opponent's piece to capture.");
//                    return;
//                }
//                // Rest of your code for a valid move...
//            } else {
//                if (targetPiece != null && targetPiece.getColor() == pieceToMove.getColor()) {
//                    System.out.println("Invalid move! This is your piece: " + targetPiece.getIcon());
//                    return;
//                }
//                chessPieces[fromRow][fromCol] = null;
//                pieceToMove.setPosition(toRow, toCol);
//                chessPieces[toRow][toCol] = pieceToMove;
//                repaint();
//
//                isWhiteTurn = !isWhiteTurn;
//                System.out.println("Good move!");
//            }
//        } else {
//            System.out.println("Invalid move!");
//        }
//    } else {
//        System.out.println("It is not your turn!");
//    }
//}
    private  void initializeBoard() {

        King whiteKing = new King("♔","white");
        Knight whiteKnight1 = new Knight("♘","white");
        Bishop whiteBishop1 = new Bishop("♗","white");
        Queen whiteQueen = new Queen("♕","white");
        Knight whiteKnight2 = new Knight("♘","white");
        Bishop whiteBishop2 = new Bishop("♗","white");
        Rook whiteRook1 = new Rook("♖","white");
        Rook whiteRook2 = new Rook("♖","white");
        Pawn whitePawn = new Pawn("♙","white");


        chessPieces[0][0] = whiteRook1;
        chessPieces[0][1] = whiteKnight1;
        chessPieces[0][2] = whiteBishop1;
        chessPieces[0][3] = whiteQueen;
        chessPieces[0][4] = whiteKing;
        chessPieces[0][5] = whiteBishop2;
        chessPieces[0][6] = whiteKnight2;
        chessPieces[0][7] = whiteRook2;

        for (int i = 0; i < BOARD_SIZE; i++) {
            chessPieces[1][i] = whitePawn;
        }

        King blackKing = new King("♚", "black");
        Queen blackQueen = new Queen("♛", "black");
        Bishop blackBishop1 = new Bishop("♝", "black");
        Bishop blackBishop2 = new Bishop("♝", "black");
        Knight blackKnight1 = new Knight("♞", "black");
        Knight blackKnight2 = new Knight("♞", "black");
        Rook blackRook1 = new Rook("♜", "black");
        Rook blackRook2 = new Rook("♜", "black");
        Pawn blackPawn = new Pawn("♟", "black");


        chessPieces[7][4] = blackKing;
        chessPieces[7][3] = blackQueen;
        chessPieces[7][2] = blackBishop1;
        chessPieces[7][5] = blackBishop2;
        chessPieces[7][1] = blackKnight1;
        chessPieces[7][6] = blackKnight2;
        chessPieces[7][0] = blackRook1;
        chessPieces[7][7] = blackRook2;

        for (int i = 0; i < BOARD_SIZE; i++) {
            chessPieces[6][i] = blackPawn;
        }

    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                int x = col * SQUARE_SIZE;
                int y = row * SQUARE_SIZE;

                if ((row + col) % 2 == 0) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.PINK);
                }

                g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);

                Piece piece = chessPieces[row][col];
                if (piece != null) {
                    g.setColor(Color.black);
                    g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 36));
                    String pieceIcon = piece.getIcon("♙").toString(); // Retrieve the icon of the piece
                    g.drawString(pieceIcon, x + 17, y + 40);
                }
            }
        }
    }
}