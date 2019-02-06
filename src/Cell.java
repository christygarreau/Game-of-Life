public class Cell {
    private int x;
    private int y;
    private int size;
    private CellState cellState;

    Cell(int _x, int _y, int _size){
        //initialize instance variables
        x = _x;
        y = _y;
        size = _size;

    }

    public void display(){
        GameOfLifeApp app = GameOfLifeApp.getApp();
        app.rect(x,y,size,size);
    }
}
