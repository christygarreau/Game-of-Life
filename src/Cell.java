public class Cell {
    private int x;
    private int y;
    private int size;
    private CellState cellState;
    private int row;
    private int col;

    Cell(int x, int y, int size, int row, int col, CellState cellState){
        //initialize instance variables
        this.x = x;
        this.y = y;
        this.size = size;
        this.row = row;
        this.col = col;
        this.cellState = cellState;

    }

    public void evolve() {
        if(this.cellState == CellState.WILL_REVIVE){
            this.cellState = CellState.ALIVE;
        }

        else if(this.cellState == CellState.WILL_DIE){
            this.cellState = CellState.DEAD;
        }
    }

    public void applyRules(Cell[][] cells){
        int liveNeighbors =  calculateLiveNeighbors(cells);
        if (this.cellState == cellState.ALIVE){
            if(liveNeighbors > 3 || liveNeighbors < 2){
                this.cellState = cellState.WILL_DIE;
            }
        }
        else if (this.cellState == cellState.DEAD){
            if(liveNeighbors == 3){
                this.cellState = cellState.WILL_REVIVE;
            }
        }
    }

    private int calculateLiveNeighbors(Cell[][] cells){
        int liveNeighbors = 0;
        // look at state of eight surrounding cells
        if (cells[row][col-1].cellState == CellState.ALIVE || cells[row][col-1].cellState == CellState.WILL_DIE){
            liveNeighbors++;
        }
        if (cells[row][col+1].cellState == CellState.ALIVE || cells[row][col+1].cellState == CellState.WILL_DIE){
            liveNeighbors++;
        }
        if (cells[row-1][col].cellState == CellState.ALIVE || cells[row-1][col].cellState == CellState.WILL_DIE){
            liveNeighbors++;
        }
        if (cells[row+1][col].cellState == CellState.ALIVE || cells[row+1][col].cellState == CellState.WILL_DIE){
            liveNeighbors++;
        }
        if (cells[row-1][col-1].cellState == CellState.ALIVE || cells[row-1][col-1].cellState == CellState.WILL_DIE){
            liveNeighbors++;
        }
        if (cells[row+1][col-1].cellState == CellState.ALIVE || cells[row+1][col-1].cellState == CellState.WILL_DIE){
            liveNeighbors++;
        }
        if (cells[row-1][col+1].cellState == CellState.ALIVE || cells[row-1][col+1].cellState == CellState.WILL_DIE){
            liveNeighbors++;
        }
        if (cells[row+1][col+1].cellState == CellState.ALIVE || cells[row+1][col+1].cellState == CellState.WILL_DIE){
            liveNeighbors++;
        }
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

    public void handleClick(int mouseX, int mouseY){
        if(mouseX > x && mouseX < x+size && mouseY > y && mouseY < y+size){
            if(cellState == CellState.ALIVE){
                cellState = CellState.DEAD;
            } else if (cellState == CellState.DEAD){
                cellState = CellState.ALIVE;
            }
        }
    }
}
