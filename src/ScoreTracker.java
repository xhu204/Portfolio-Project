import components.map.Map;

public interface ScoreTracker extends ScoreTrackerKernel {
    /**
     * Returns the highest score among all players.
     *
     * @return the highest score
     * @requires getTotalPlayers() > 0
     * @ensures [returns the maximum score among all players in this]
     */
    int getHighestScore();

    /**
     * Retrieves the playerID of the player with the highest score.
     *
     * @return the playerID of the top player
     * @requires getTotalPlayers() > 0
     * @ensures [returns the playerID associated with the highest score in this]
     */
    String getTopPlayer();

    /**
     * Provides a ranking of players sorted by their scores in descending order.
     *
     * @return a map of playerIDs and their scores, sorted from highest to
     *         lowest score
     * @ensures [returns a map where entries are sorted by score in descending
     *          order]
     */
    Map<String, Integer> getRankings();

    /**
     * Returns the total number of players being tracked.
     *
     * @return the total number of players
     * @ensures [returns the number of playerIDs in this]
     */
    int getTotalPlayers();

    /**
     * Removes a player from the score tracker.
     *
     * @param playerID
     *            the unique identifier of the player to remove
     * @requires isPlayer(playerID)
     * @updates this
     * @ensures [playerID is no longer in this]
     */
    @Override
    void removePlayer(String playerID);

}
