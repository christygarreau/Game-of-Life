import processing.core.PApplet;

public class GameOfLifeApp extends PApplet{
    private static GameOfLifeApp app; //reference to itself
    Cell[][] cells;
    private static final int CELL_SIZE = 10;

    public GameOfLifeApp(){
        app = this;
    }

    public static void main(String[] args){ //main class to run is game of life app
        PApplet.main("GameOfLifeApp");
    }

    public void settings(){
        size(1000,500);
    }

    public void setup(){
        cells = new Cell[height/CELL_SIZE][width/CELL_SIZE];
        //create each Cell object and assign into cells
        for(int r = 0; r < cells.length; r++){
            for(int c = 0; c < cells[0].length; c++){
                cells[r][c] = new Cell(c*10,r*10,CELL_SIZE);
            }
        }
    }

    public void draw(){
        for(int row = 0; row < cells.length; row++){
            for(int col = 0; col < cells[0].length; col++){
                cells[row][col].display();
            }
        }
        //display each cell
    }

    public static GameOfLifeApp getApp(){
        return app;
    }
}
