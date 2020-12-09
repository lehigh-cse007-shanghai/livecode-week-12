package live;

import processing.core.PApplet;

import java.util.ArrayList;

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

    public void buildTwoTriangles(int size){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= size; i ++)
            arr.add(i);
        for(int i = size - 1; i >= 1; i --)
            arr.add(i);

        for(int i = 1; i <= size; i ++){
            for(int j = 0; j < arr.size(); j ++){
                if(arr.get(j) >= i + 1)
                    cells[j][i - 1].isMovableCell = true;
                else
                    cells[j][i - 1].isMovableCell = false;

            }
        }
    }

    public void keyPressed() {
        switch (String.valueOf(key).toLowerCase()){
            case "t":
                clear();
                buildTriangle(12);
                break;
            case "2":
                clear();
                buildTwoTriangles(11);
                break;
            default:
                clear();
                break;
        }
    }

    public void clear(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                // Initialize each Cell object
                cells[i][j] = new Cell(i * widthCell,j * heightCell,
                        widthCell, heightCell);
            }
        }
    }

    public void settings() {
        size(widthCell * cols, heightCell * rows);
        cells = new Cell[cols][rows];
        clear();
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
