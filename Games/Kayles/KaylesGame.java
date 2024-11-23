package Games.Kayles;
import Games.Common.Game;
import Games.Common.Player;

public class KaylesGame extends Game<boolean[], Integer> {

    private int numberOfPins;
    private boolean isComputerFirst;
    private boolean isBoardEven;
    private int lastPlayerFirstIndex;
    private int lastPlayerSecondIndex;
    private boolean isLastPlayerDouble;
    
    public KaylesGame() {
        super("Kayles");
    }
    
    protected void setUp() {
        if (numberOfPins % 2 == 0) {
            isBoardEven = true;
        }
        else {
            isBoardEven = false;
        }
        board = new boolean[numberOfPins];
        for (int i = 0; i < numberOfPins; i++) {
            board[i] = true;
        }
    }
    
    protected boolean checkIfGameEnded() {
        if (numberOfPins == 0) {
            return true;
        }
        return false;
    }

    protected boolean validateMove(Integer index) {
        if (board[index]) {
            return true;
        }
        return false;
    }

    protected boolean move() {
        try {
            if (currentPlayer == Player.HUMAN) {
                humanMove();
            }
            else {
                computerMove();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected boolean humanMove() {
        //TODO: get input
        Integer move = 0;
        while (!validateMove(move)) {
            //TODO: say the move's bad and get it again
            move = 0;
        }
        return true;
    }

    protected boolean computerMove() {
        if (isComputerFirst) {
            int middle = board.length / 2;
            if (board[middle] == true) {
                if (isBoardEven) {
                    board[middle] = false;
                    board[middle + 1] = false;
                } else {
                    board[middle] = false;
                }
            } else {
                if (isLastPlayerDouble) {
                    board[board.length - lastPlayerFirstIndex] = false;
                    board[board.length - lastPlayerSecondIndex] = false;
                } else {
                    board[board.length - lastPlayerFirstIndex] = false;
                }
            }
        } else {
            if (groupsOfTwoPossible()) {

            }
            else if (groupsOfThreePossible()) {

            }
            else {
                
            }
        }
        return true;
    }

    private boolean groupsOfTwoPossible() {
        return true;
    }

    private boolean groupsOfThreePossible() {
        return true;
    }

}
