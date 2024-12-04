import components.standard.Standard;

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

}
