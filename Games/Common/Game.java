package Games.Common;

public abstract class Game<B, M> {
    
    protected String name;
    protected Player currentPlayer;
    protected boolean isGameOver;
    protected Result results;
    protected B board;

    protected Game(String name) {
        this.name = name;
        setUp();
        while (!isGameOver) {
            move();
            checkIfGameEnded();
            switchTurns();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlayerTurn() {
        return (currentPlayer == Player.HUMAN);
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public B getBoard() {
        return board;
    }

    public void setBoard(B board) {
        this.board = board;
    }

    protected abstract void setUp();
    
    protected abstract boolean checkIfGameEnded();

    protected void switchTurns() {
        if (currentPlayer == Player.HUMAN) {
            currentPlayer = Player.AI;
        }
        else {
            currentPlayer = Player.HUMAN;
        }
    }
    
    protected abstract boolean move();

    protected abstract boolean computerMove();

    protected abstract boolean humanMove();

    protected void reset() {
        setUp();
    }

    protected abstract boolean validateMove(M move);

}
