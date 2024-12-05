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

    /**
     * Returns a string representation of the score tracker.
     *
     * @return a string representation of this score tracker
     * @ensures [returns a string that represents the current state of this
     *          score tracker]
     */
    @Override
    String toString();

    /**
     * Compares the specified object with this score tracker for equality.
     *
     * @param obj
     *            the object to be compared for equality with this score tracker
     * @return true if the specified object is equal to this score tracker
     * @ensures [returns true if obj is a ScoreTracker and has the same players
     *          and scores as this]
     */
    @Override
    boolean equals(Object obj);

}
