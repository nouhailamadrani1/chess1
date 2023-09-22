import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class Board extends JPanel {
    public static int numBoard = 8;
    public static int boardSize = 60;

    public static String[][] chessPieces = new String[numBoard][numBoard];


    public static void main(String[] args) {
        JFrame frame = new JFrame("Chessboard"
        );
        Board main = new Board();

        frame.add(main);
//        frame.setUndecorated(true);
        frame.setSize(numBoard * boardSize, numBoard * boardSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chess Piece Movement:");
            System.out.println("Enter (fromRow, fromCol):");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();

            // Check if there is a chess piece at the specified position
            if (chessPieces[fromRow][fromCol] != null) {
                System.out.println("There is a piece at (" + fromRow + ", " + fromCol + ")");
            System.out.println("Enter (toRow, toCol):");
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            main.movePiece(fromRow, fromCol, toRow, toCol);

            } else {
                System.out.println("There is no piece at (" + fromRow + ", " + fromCol + ")");
            }
        }


    }






    public Board() {

        initializeBoard();


    }



    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {

        String pieceToMove = chessPieces[fromRow][fromCol];


        chessPieces[fromRow][fromCol] = null;


        chessPieces[toRow][toCol] = pieceToMove;


        repaint();
    }


    private static void initializeBoard() {

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

        for (int i = 0; i < numBoard; i++) {
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

        for (int i = 0; i < numBoard; i++) {
            chessPieces[6][i] = blackPawn.getIcon();
        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < numBoard; row++) {
            for (int col = 0; col < numBoard; col++) {
                int x = col * boardSize;
                int y = row * boardSize;

                if ((row + col) % 2 == 0) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.PINK);
                }

                g.fillRect(x, y, boardSize, boardSize);

                String piece = chessPieces[row][col];
                if (piece != null) {
                    g.setColor(Color.black);
                    g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 36));
                    g.drawString(piece, x + 17, y + 40);
                }
            }
        }

    }}
