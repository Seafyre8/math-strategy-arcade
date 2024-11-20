package Games.Common;

public abstract class Game {
    
    protected String name;
    protected boolean isPlayerTurn;
    protected boolean isGameOver;
    protected Result results;

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }

    protected Game(String name) {
        this.name = name;
        setUp();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean isPlayerTurn) {
        this.isPlayerTurn = isPlayerTurn;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    abstract void setUp();
    
    abstract boolean checkIfGameEnded();

    protected void switchTurns() {
        isPlayerTurn = !isPlayerTurn;
    }
    
    abstract boolean move(Move move);

    abstract Move getAIMove();

    abstract Result checkResult();

    protected void reset() {
        setUp();
    }

}
