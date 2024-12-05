import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;

public class ScoreTrackermain {

    // Constructor
    //xxxx
    public ScoreTrackermain() {
        Map<String, Integer> playerScores = new Map1L<>();
    }

    //Kernel Methods
    public void addScore(String playerID, int score) {
        assert playerID != null;
        assert score < 0;

        this.playerScores.add(playerID, score);

    }

    public int getScore(String playerID) {

    }

    public void updateScore(String playerID, int newScore) {

    }

    public boolean isPlayer(String playerID) {

    }

    public void clear() {
        this.playerScores.clear();
    }

    //Secondary Methods
    public int getHighestScore() {

    }

    public String getTopPlayer() {

    }

    public Queue<Map<String, Integer>> getRankings() {

    }

    // Standard Interface Methods
    //transferFrom

    /*
     *
     */

}
