import components.map.Map;
import components.map.Map1L;

public class ScoreTracker1L extends ScoreTrackerSecondary {

    private final Map<String, Integer> playerScores;

    public ScoreTracker1L() {
        this.playerScores = new Map1L<>();
    }

    @Override
    public void addScore(String playerID, int score) {
        assert playerID != null;

        if (this.playerScores.hasKey(playerID)) {
            int oldScore = this.playerScores.value(playerID);
            this.playerScores.remove(playerID);
            this.playerScores.add(playerID, oldScore + score);
        } else {
            this.playerScores.add(playerID, score);
        }
    }

    @Override
    public int getScore(String playerID) {
        assert this.playerScores.hasKey(playerID);

        return this.playerScores.value(playerID);
    }

    @Override
    public void removePlayer(String playerID) {
        assert this.playerScores.hasKey(playerID);

        this.playerScores.remove(playerID);
    }

    @Override
    public void updateScore(String playerID, int newScore) {
        assert this.playerScores.hasKey(playerID);

        this.playerScores.replaceValue(playerID, newScore);
    }

    @Override
    public boolean isPlayer(String playerID) {
        return this.playerScores.hasKey(playerID);
    }

    @Override
    public void clear() {
        this.playerScores.clear();
    }

}
