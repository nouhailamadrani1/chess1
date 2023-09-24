package Pieces;

public abstract class Piece {
    private String icon;
    private int row;
    private int col;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Piece(String icon,String color) {
        this.icon = icon;
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Piece chessBoard);


}

