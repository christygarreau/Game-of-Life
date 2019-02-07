import java.util.Random;

public enum CellState { //enum
    ALIVE,
    DEAD,
    WILL_DIE,
    WILL_REVIVE;

    private static final Random RANDOM = new Random();
    //creates new random number generating machine
    private static final CellState[] STATES = {ALIVE, DEAD};
    //constant array that only has alive and dead in it


    public static CellState randomState() {
        return STATES[RANDOM.nextInt(2)]; //returns alive or dead
    }
}
