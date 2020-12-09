package live;

import processing.core.PApplet;

public class TriangleCells extends PApplet {
    // A Cell object
    class Cell {
        float x, y;   // x,y location
        float w, h;   // width and height

        boolean isMovableCell = false;

        // Cell Constructor
        Cell(float _x, float _y, float _w, float _h) {
            x = _x;
            y = _y;
            w = _w;
            h = _h;
        }

        void display() {
            stroke(255);
            if(isMovableCell)
                fill(movableCellColor[0], movableCellColor[1], movableCellColor[2]); // Cell in RED
            else
                fill(200, 200, 200); // Cell in GREY
            rect(x, y, w, h);
        }
    }

    int movableX = 10;
    int movableY = 10;

    Cell[][] cells;
    int[] movableCellColor = {255, 0, 0}; // Initially set to Red

    // Number of columns and rows in the grid
    int cols = 21;
    int rows = 21;

    // Width and height of each cell in the grid
    int widthCell = 40;
    int heightCell = 40;

    public void changeMovableCellColor() {
        movableCellColor = new int[]{ (int) random(255), (int)random(255), (int)random(255)};
    }

    public void buildTriangle(int size){
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size - i; j ++) {
                cells[i][j].isMovableCell = true;
            }
        }
    }

    public void keyPressed() {
        switch (String.valueOf(key).toLowerCase()){
            case "t":
                buildTriangle(12);
                break;
            default:
                break;
        }
    }

    public void settings() {
        size(widthCell * cols, heightCell * rows);
        cells = new Cell[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                // Initialize each Cell object
                cells[i][j] = new Cell(i * widthCell,j * heightCell,
                        widthCell, heightCell);
            }
        }
    }

    public void draw() {
        background(0);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j].display();
            }
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"TriangleCells"};
        TriangleCells triangleCells = new TriangleCells();
        PApplet.runSketch(processingArgs, triangleCells);
    }

}
