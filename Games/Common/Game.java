package Games.Common;

public abstract class Game {
    
    protected String name;
    protected Player currentPlayer;
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
        return (currentPlayer == Player.HUMAN);
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
        if (currentPlayer == Player.HUMAN) {
            currentPlayer = Player.AI;
        }
        else {
            currentPlayer = Player.HUMAN;
        }
    }
    
    abstract boolean move();

    abstract boolean move(Object obj);

    abstract Result checkResult();

    protected void reset() {
        setUp();
    }

    abstract boolean validateMove();

}
