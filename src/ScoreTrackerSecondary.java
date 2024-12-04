import components.map.Map;

public abstract class ScoreTrackerSecondary implements ScoreTracker {
    /**
     * Returns the highest score among all players.
     *
     * @return the highest score
     * @requires getTotalPlayers() > 0
     * @ensures [returns the maximum score among all players in this]
     */
    @Override
    public int getHighestScore() {
        assert (this.getTotalPlayers() > 0);

        int highestScore = Integer.MIN_VALUE;
        for (Map.Pair<String, Integer> pair : this) {
            int score = pair.value();
            if (score > highestScore) {
                highestScore = score;
            }
        }
        return highestScore;
    }

    /**
     * Retrieves the playerID of the player with the highest score.
     *
     * @return the playerID of the top player
     * @requires getTotalPlayers() > 0
     * @ensures [returns the playerID associated with the highest score in this]
     */
    @Override
    public String getTopPlayer() {
        assert (this.getTotalPlayers() > 0);

        String topPlayer = null;
        int highestScore = Integer.MIN_VALUE;
        for (Map.Pair<String, Integer> pair : this) {
            int score = pair.value();
            if (score > highestScore) {
                highestScore = score;
                topPlayer = pair.key();
            }
        }
        return topPlayer;
    }

    /**
     * Returns the total number of players being tracked.
     *
     * @return the total number of players
     * @ensures [returns the number of playerIDs in this]
     */
    @Override
    public int getTotalPlayers() {
        return this.size();
    }

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
    public void removePlayer(String playerID) {
        assert this.hasKey(playerID);

        this.remove(playerID);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this.equals(obj)) {
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        String out = "ScoreTracker:\n";
        for (Map.Pair<String, Integer> pair : this) {
            out = out + "PlayerID: " + pair.key() + ", Score: " + pair.value()
                    + "\n";
        }
        return out;
    }

}
