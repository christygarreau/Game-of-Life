import processing.core.PApplet;

public class GameOfLifeApp extends PApplet{
    private static GameOfLifeApp app; //reference to itself
    Cell[][] cells;
    private static final int CELL_SIZE = 10;
    private boolean startGame = false;

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
        //Rules rules = new Rules(new int[]{3}, new int[]{2,3}); // B3/S23 is game of life
        Rules rules = new Rules(new int[]{2}, new int[]{}); // B2/S0 (for testing when ready)

        app.frameRate(9);
        cells = new Cell[height/CELL_SIZE][width/CELL_SIZE];
        for(int r = 0; r < cells.length; r++){
            for(int c = 0; c < cells[0].length; c++){
                if(c == 0 || c == cells[0].length - 1 || r == 0 || r == cells.length - 1){
                    cells[r][c] = new Cell(c*CELL_SIZE,r*CELL_SIZE,CELL_SIZE,r,c, CellState.DEAD, rules);
                }else{
                    cells[r][c] = new Cell(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, r, c, CellState.DEAD, rules);
                }
            }
        }
    }

    public void draw(){
        if(startGame == true) {
            applyRules(cells);
            evolve();
        }
        display();
    }


    private void applyRules(Cell[][] cells){
        //ask each cell within the border to calculate its next state(call applyrules on each cell)

        for(int row = 1; row < cells.length-1; row++){
            for(int col = 1; col < cells[0].length-1; col++){
                cells[row][col].applyRules(cells);
            }
        }

    }

    private void evolve(){
        //evolve cells within the border (call evolve on each cell
        for(int row = 1; row < cells.length-1; row++){
            for(int col = 1; col < cells[0].length-1; col++){
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

    public void mouseClicked(){
        for(int row = 1; row < cells.length-1; row++){
            for(int col = 1; col < cells[0].length-1; col++){
                cells[row][col].handleClick(mouseX, mouseY);
            }
        }
    }

    public void keyPressed(){
        startGame = !startGame;
    }

    public static GameOfLifeApp getApp(){
        return app;
    }
}
