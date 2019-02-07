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
        super.setup();
        cells = new Cell[height/CELL_SIZE][width/CELL_SIZE];
        for(int r = 0; r < cells.length; r++){
            for(int c = 0; c < cells[0].length; c++){
                if(c == 0 || c == cells[0].length - 1 || r == 0 || r == cells.length - 1){
                    cells[r][c] = new Cell(c*CELL_SIZE,r*CELL_SIZE,CELL_SIZE,1,1, CellState.DEAD);
                }else{
                    cells[r][c] = new Cell(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, 1, 1, CellState.randomState());
                }
            }
        }
    }

    public void draw(){
        applyRules(cells);
        evolve();
        display(); //move nested drawing code into this private method
    }


    private void applyRules(Cell[][] cells){
        //ask each cell within the border to calculate its next state(call applyrules on each cell)
        for(int row = 0; row < cells.length; row++){
            for(int col = 0; col < cells[0].length; col++){
                //cells[row][col].applyRules(Cell[row][col] cells);
            }
        }
    }

    private void evolve(){
        //evolve cells within the border (call evolve on each cell
        for(int row = 0; row < cells.length; row++){
            for(int col = 0; col < cells[0].length; col++){
                cells[row][col].evolve(); //calls evolve in cell
            }
        }
    }

    private void display(){
        //ask each cell to display
        for(int row = 0; row < cells.length; row++){
            for(int col = 0; col < cells[0].length; col++){
                cells[row][col].display();
            }
        }
    }

    public static GameOfLifeApp getApp(){
        return app;
    }
}
