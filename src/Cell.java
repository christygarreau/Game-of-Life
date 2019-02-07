public class Cell {
    private int x;
    private int y;
    private int size;
    private CellState cellState;
    private int row;
    private int column;

    Cell(int x, int y, int size, int row, int column, CellState cellState){
        //initialize instance variables
        this.x = x;
        this.y = y;
        this.size = size;
        this.row = row;
        this.column = column;
        this.cellState = cellState;

    }

    public void evolve() {
        //complete transition to alive or dead (if will revive then make it alive)
    }

    public void applyRules(Cell[][] cells){
        //calculate live neighbors
        int liveNeighbors = calculateLiveNeighbors(cells);
        //determine the next state -- test 4 conditions on Wiki to determine state in next generation
    }

    private int calculateLiveNeighbors(Cell[][] cells){
        //check each 8 neighboring cells and calculate how many are alive
        //conditional statements
        int liveNeighbors = 0;
        return liveNeighbors;
    }

    public void display(){
        GameOfLifeApp app = GameOfLifeApp.getApp();
        app.noStroke();
        if (cellState == CellState.ALIVE){
            app.fill(255, 53, 98);
        } else {
            app.fill(84, 58, 89);
        }
        app.rect(x,y,size,size);
    }
}
