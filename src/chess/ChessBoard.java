package chess;

import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

import static Pieces.Bishop.isBishop;
import static Pieces.King.isKing;
import static Pieces.Knight.isKnight;
import static Pieces.Pawn.isPawn;
import static Pieces.Queen.isQueen;
import static Pieces.Rook.isRook;

public class ChessBoard extends JPanel {
    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 60;
    private String[][] chessPieces = new String[BOARD_SIZE][BOARD_SIZE];

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
                System.out.println("There is a piece at (" + fromRow + ", " + fromCol + ")");
                String pieceToMove = chessBoard.getPieceAt(fromRow, fromCol);
                if (isPawn(pieceToMove)) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a pawn.");

                } else if (isKing(pieceToMove)) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a King.");

                }
                else if (isKnight(pieceToMove)) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a Knight.");

                }
                else if (isQueen(pieceToMove)) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a Queen.");

                }
                else if (isRook(pieceToMove)) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a Rook.");

                }
                else if (isBishop(pieceToMove)) {
                    System.out.println("The piece at (" + fromRow + ", " + fromCol + ") is a King.");

                }

                System.out.println("Enter (toRow, toCol):");
                int toRow = scanner.nextInt();
                int toCol = scanner.nextInt();

                chessBoard.movePiece(fromRow, fromCol, toRow, toCol);
                System.out.println("Good Game GG");
            } else {
                System.out.println("There is no piece at (" + fromRow + ", " + fromCol + ")");
            }
        }
    }

    public ChessBoard() {
        initializeBoard();
    }

    public String getPieceAt(int row, int col) {
        return chessPieces[row][col];
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        String pieceToMove = chessPieces[fromRow][fromCol];
        chessPieces[fromRow][fromCol] = null;
        chessPieces[toRow][toCol] = pieceToMove;
        repaint();
    }

    private  void initializeBoard() {

        King whiteKing = new King();
        Knight whiteKnight1 = new Knight();
        Bishop whiteBishop1 = new Bishop();
        Queen whiteQueen = new Queen();
        Knight whiteKnight2 = new Knight();
        Bishop whiteBishop2 = new Bishop();
        Rook whiteRook1 = new Rook();
        Rook whiteRook2 = new Rook();
        Pawn whitePawn = new Pawn();


        chessPieces[0][0] = whiteRook1.getIcon();
        chessPieces[0][1] = whiteKnight1.getIcon();
        chessPieces[0][2] = whiteBishop1.getIcon();
        chessPieces[0][3] = whiteQueen.getIcon();
        chessPieces[0][4] = whiteKing.getIcon();
        chessPieces[0][5] = whiteBishop2.getIcon();
        chessPieces[0][6] = whiteKnight2.getIcon();
        chessPieces[0][7] = whiteRook2.getIcon();

        for (int i = 0; i < BOARD_SIZE; i++) {
            chessPieces[1][i] = whitePawn.getIcon();
        }

        King blackKing = new King("♚");
        Queen blackQueen = new Queen("♛");
        Bishop blackBishop1 = new Bishop("♝");
        Bishop blackBishop2 = new Bishop("♝");
        Knight blackKnight1 = new Knight("♞");
        Knight blackKnight2 = new Knight("♞");
        Rook blackRook1 = new Rook("♜");
        Rook blackRook2 = new Rook("♜");
        Pawn blackPawn = new Pawn("♟");


        chessPieces[7][4] = blackKing.getIcon();
        chessPieces[7][3] = blackQueen.getIcon();
        chessPieces[7][2] = blackBishop1.getIcon();
        chessPieces[7][5] = blackBishop2.getIcon();
        chessPieces[7][1] = blackKnight1.getIcon();
        chessPieces[7][6] = blackKnight2.getIcon();
        chessPieces[7][0] = blackRook1.getIcon();
        chessPieces[7][7] = blackRook2.getIcon();

        for (int i = 0; i < BOARD_SIZE; i++) {
            chessPieces[6][i] = blackPawn.getIcon();
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

                String piece = chessPieces[row][col];
                if (piece != null) {
                    g.setColor(Color.black);
                    g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 36));
                    g.drawString(piece, x + 17, y + 40);
                }
            }
        }
    }
}
