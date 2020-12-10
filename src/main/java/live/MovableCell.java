package live;

import processing.core.PApplet;


class Cell {
    public float x, y;   // x,y location
    public float w, h;   // width and height

    public boolean isMovableCell = false;

    // Cell Constructor
    public Cell(float _x, float _y, float _w, float _h) {
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }
}

public class MovableCell extends PApplet {
    // A Cell object

    // Number of columns and rows in the grid
    public int cols = 21;
    public int rows = 21;

    public Cell[][] cells = new Cell[cols][rows];

    public int movableX = 10;
    public int movableY = 10;

    public int[] movableCellColor = {255, 0, 0}; // Initially set to Red

    // Width and height of each cell in the grid
    public int widthCell = 40;
    public int heightCell = 40;

    public void changeMovableCellColor() {
        movableCellColor = new int[]{ (int) random(255), (int)random(255), (int)random(255)};
    }

    public void moveUp(){
        if(movableX >= 0 && movableY >= 0 && movableX <= 20 && movableY <= 20)
            cells[movableX][movableY].isMovableCell = false;
        this.movableY -= 1;
        if(movableX >= 0 && movableY >= 0 && movableX <= 20 && movableY <= 20)
            cells[movableX][movableY].isMovableCell = true;
    }

    public void moveDown(){
        if(movableX >= 0 && movableY >= 0 && movableX <= 20 && movableY <= 20)
            cells[movableX][movableY].isMovableCell = false;
        this.movableY += 1;
        if(movableX >= 0 && movableY >= 0 && movableX <= 20 && movableY <= 20)
            cells[movableX][movableY].isMovableCell = true;
    }

    public void moveLeft(){
        if(movableX >= 0 && movableY >= 0 && movableX <= 20 && movableY <= 20)
            cells[movableX][movableY].isMovableCell = false;
        this.movableX -= 1;
        if(movableX >= 0 && movableY >= 0 && movableX <= 20 && movableY <= 20)
            cells[movableX][movableY].isMovableCell = true;
    }

    public void moveRight(){
        if(movableX >= 0 && movableY >= 0 && movableX <= 20 && movableY <= 20)
            cells[movableX][movableY].isMovableCell = false;
        this.movableX += 1;
        if(movableX >= 0 && movableY >= 0 && movableX <= 20 && movableY <= 20)
            cells[movableX][movableY].isMovableCell = true;
    }

    public void keyPressed() {
        switch (String.valueOf(key).toLowerCase()){
            case "c":
                changeMovableCellColor();
                break;
            case "w":
                moveUp();
                break;
            case "s":
                moveDown();
                break;
            case "a":
                moveLeft();
                break;
            case "d":
                moveRight();
                break;
            default:
                break;
        }
    }

    public void settings() {
        size(widthCell * cols, heightCell * rows);
        createCells();
        clear();
        cells[movableX][movableY].isMovableCell = true;
    }

    public void createCells(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                // Initialize each Cell object
                cells[i][j] = new Cell(i * widthCell,j * heightCell,
                        widthCell, heightCell);
            }
        }
    }

    public void clear(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j].isMovableCell = false;
            }
        }
    }

    public void draw() {
        background(0);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                display(cells[i][j]);
            }
        }
    }

    public void display(Cell cell){
        stroke(255);
        if(cell.isMovableCell)
            fill(movableCellColor[0], movableCellColor[1], movableCellColor[2]); // Cell in RED
        else
            fill(200, 200, 200); // Cell in GREY
        rect(cell.x, cell.y, cell.w, cell.h);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MovableCell"};
        MovableCell movableCell = new MovableCell();
        PApplet.runSketch(processingArgs, movableCell);
    }

}
