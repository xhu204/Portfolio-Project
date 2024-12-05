import components.map.Map;
import components.standard.Standard;;

/**
 * Kernel interface for the {@code ScoreTracker} component.
 *
 * <p>
 * The {@code ScoreTrackerKernel} interface extends
 * {@code Standard<ScoreTracker>} and defines the core methods (kernel methods)
 * for managing player scores in a game or application. These methods provide
 * the fundamental operations for adding, updating, retrieving, and removing
 * player scores. This interface serves as the foundation upon which the
 * secondary methods are implemented in the {@code ScoreTracker} component.
 * </p>
 *
 * <p>
 * Implementations of this interface should ensure that all method contracts are
 * strictly followed, including the specified preconditions and postconditions.
 * The kernel methods are designed to manipulate the internal state of the
 * {@code ScoreTracker} in a controlled and predictable manner.
 * </p>
 *
 * @author Xin Hu
 * @version 1.0
 */
public interface ScoreTrackerKernel extends Standard<ScoreTracker> {

    /**
     * Adds a new player in to the game with their score.
     *
     * @param playerID
     *            the unique identifier of the player
     * @param score
     *            the score to be added
     * @updates this
     * @requires playerID did not exist in this and score can't be < 0
     * @ensures [if playerID did not exist in this, then playerID is added with
     *          score]
     */
    void addScore(String playerID, int score);

    /**
     * Removes a player from the score tracker.
     *
     * @param playerID
     *            the unique identifier of the player to remove
     * @requires isPlayer(playerID)
     * @updates this
     * @ensures [playerID is no longer in this]
     */
    void removePlayer(String playerID);

    /**
     * return current score of the specified player.
     *
     * @param playerID
     *            the unique identifier of the player
     * @return the current score of the player
     * @requires isPlayer(playerID)
     * @ensures [returns the score associated with playerID]
     */
    int getScore(String playerID);

    /**
     * Updates the score of an existing player.
     *
     * @param playerID
     *            the unique identifier of the player
     * @param newScore
     *            the new score to set
     * @requires isPlayer(playerID)
     * @updates this
     * @ensures [playerID's score is replaced with newScore]
     */
    void updateScore(String playerID, int newScore);

    /**
     * Checks if a player exists in the score tracker.
     *
     * @param playerID
     *            the unique identifier of the player
     * @return true if the player exists in the tracker, false otherwise
     * @ensures [returns true if playerID is in this, false otherwise]
     */
    boolean isPlayer(String playerID);

    /**
     * Returns a new instance of ScoreTracker with the same dynamic type as
     * this.
     *
     * @return a new instance of ScoreTracker
     * @ensures newInstance is an initial instance of ScoreTracker
     */
    @Override
    ScoreTracker newInstance();

    /**
     * Sets this to the incoming value of source, and resets source to an
     * initial value.
     *
     * @param source
     *            the ScoreTracker to transfer from
     * @updates this
     * @clears source
     * @requires source is not null and source has the same dynamic type as this
     * @ensures this = #source and source = initial value
     */
    @Override
    void transferFrom(ScoreTracker source);

    @Override
    void clear();

    /**
     * Returns the number of players being tracked.
     *
     * @return the number of players
     * @ensures size = |DOMAIN(this)|
     */
    int size();

    /**
     * Removes and returns an arbitrary player-score pair from the tracker.
     *
     * @return a Map.Pair containing a playerID and their score
     * @requires this /= {}
     * @ensures this = #this \ {(playerID, score)}
     */
    Map.Pair<String, Integer> removeAny();

}
