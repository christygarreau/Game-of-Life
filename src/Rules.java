public class Rules {
    private int[] birthRules;
    private int[] survivalRules;

    public Rules(int[] birthRules, int[] survivalRules){
        this.birthRules = birthRules;
        this.survivalRules = survivalRules;
    }

    public CellState applyRules(CellState cellState, int liveNeighbors){
        CellState newCellState = cellState;

        if(cellState == cellState.DEAD){
            for(int i = 0; i < birthRules.length; i++) {
                if (liveNeighbors == birthRules[i]){ //iterate through every array
                    newCellState = cellState.WILL_REVIVE;
                }
            }

        } else if(cellState == cellState.ALIVE){
            boolean willDie = true;
            for(int i = 0; i < survivalRules.length; i++){
                if(liveNeighbors == survivalRules[i]){
                    willDie = false;
                }
            }
            if(willDie == true){
                newCellState = cellState.WILL_DIE;
            }
        }

        return newCellState;
    }
}
