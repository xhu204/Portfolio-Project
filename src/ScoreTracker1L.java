import components.map.Map;
import components.map.Map1L;;

/**
 * Concrete implementation of the {@code ScoreTracker} component using
 * {@code Map1L}.
 *
 * <p>
 * The {@code ScoreTracker1L} class extends {@code ScoreTrackerSecondary} and
 * provides concrete implementations for all kernel methods declared in
 * {@code ScoreTrackerKernel}. It uses a {@code Map<String, Integer>} to store
 * player IDs and their associated scores. This class serves as the concrete
 * kernel implementation in the layered design of the {@code ScoreTracker}
 * component.
 * </p>
 *
 * <p>
 * Clients can instantiate this class to create a new {@code ScoreTracker} and
 * use its methods to manage player scores in a game or application.
 * </p>
 *
 * @author Xin Hu
 * @version 1.0
 */
public class ScoreTracker1L extends ScoreTrackerSecondary {
    /**
     * The map storing player IDs and their scores.
     */
    private final Map<String, Integer> playerScores;

    /**
     * Constructs a new {@code ScoreTracker1L} with an empty player scores map.
     *
     * @ensures <pre>
     * this.playerScores = {}
     * </pre>
     */
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

    @Override
    public int size() {
        return this.playerScores.size();
    }

    @Override
    public ScoreTracker newInstance() {
        return new ScoreTracker1L();
    }

    @Override
    public void transferFrom(ScoreTracker source) {
        assert source != null;

        ScoreTracker1L localSource = (ScoreTracker1L) source;

        this.playerScores.transferFrom(localSource.playerScores);
    }

    @Override
    public Map.Pair<String, Integer> removeAny() {
        assert this.playerScores.size() > 0 : "Violation of: this /= {}";
        return this.playerScores.removeAny();
    }

}
