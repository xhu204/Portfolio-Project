import components.map.Map;

/**
 * Abstract class providing implementations for secondary methods of
 * {@code ScoreTracker}.
 *
 * <p>
 * The {@code ScoreTrackerSecondary} class implements the {@code ScoreTracker}
 * interface and provides concrete implementations for all secondary methods
 * declared in {@code ScoreTracker}. These implementations rely solely on the
 * kernel methods specified in {@code ScoreTrackerKernel}, adhering to the
 * principles of layered design in component-based software engineering. This
 * approach promotes modularity and maintainability by separating the core
 * functionality (kernel methods) from the extended features (secondary
 * methods).
 * </p>
 *
 * <p>
 * This class is abstract and cannot be instantiated directly. It is intended to
 * be extended by a concrete class that implements the kernel methods, such as
 * {@code ScoreTracker1}. Clients should use the concrete subclasses to create
 * instances of {@code ScoreTracker}.
 * </p>
 *
 * @author Xin Hu
 * @version 1.0
 */
public abstract class ScoreTrackerSecondary implements ScoreTracker {

    @Override
    public int getHighestScore() {
        assert this.getTotalPlayers() > 0;

        int highestScore = Integer.MIN_VALUE;
        int originalSize = this.size();

        // Temporary storage to restore the tracker
        ScoreTracker tempTracker = this.newInstance();

        for (int i = 0; i < originalSize; i++) {
            // Remove
            Map.Pair<String, Integer> entry = this.removeAny();
            int score = entry.value();

            // Update
            if (score > highestScore) {
                highestScore = score;
            }

            tempTracker.addScore(entry.key(), score);
        }

        // Restore
        this.transferFrom(tempTracker);

        return highestScore;
    }

    @Override
    public String getTopPlayer() {
        assert (this.getTotalPlayers() > 0);

        String topPlayer = null;
        int highestScore = Integer.MIN_VALUE;
        int originalSize = this.size();

        ScoreTracker tempTracker = this.newInstance();
        tempTracker.transferFrom(this);

        for (int i = 0; i < originalSize; i++) {
            // Remove any player from tempTracker
            Map.Pair<String, Integer> entry = tempTracker.removeAny();
            String playerID = entry.key();
            int score = entry.value();

            // Update highest score and top player
            if (score > highestScore) {
                highestScore = score;
                topPlayer = playerID;
            }

            // restore
            this.addScore(playerID, score);
        }

        return topPlayer;
    }

    @Override
    public int getTotalPlayers() {
        return this.size();
    }

    @Override
    public void removePlayer(String playerID) {
        assert this.isPlayer(playerID);

        int originalSize = this.size();
        ScoreTracker tempTracker = this.newInstance();

        for (int i = 0; i < originalSize; i++) {
            Map.Pair<String, Integer> entry = this.removeAny();
            String currentPlayerID = entry.key();
            int score = entry.value();

            if (!currentPlayerID.equals(playerID)) {
                tempTracker.addScore(currentPlayerID, score);
            }
        }

        // Restore the tracker without the removed player
        this.transferFrom(tempTracker);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ScoreTracker)) {
            return false;
        }

        ScoreTracker other = (ScoreTracker) obj;

        if (this.size() != other.size()) {
            return false;
        }

        boolean isEqual = true;
        ScoreTracker tempTracker1 = this.newInstance();
        ScoreTracker tempTracker2 = other.newInstance();

        int originalSize = this.size();

        for (int i = 0; i < originalSize; i++) {
            Map.Pair<String, Integer> entry = this.removeAny();
            String playerID = entry.key();
            int score = entry.value();

            if (!other.isPlayer(playerID)
                    || other.getScore(playerID) != score) {
                isEqual = false;
            }

            tempTracker1.addScore(playerID, score);
            tempTracker2.addScore(playerID, score);
        }

        // Restore both trackers
        this.transferFrom(tempTracker1);
        other.transferFrom(tempTracker2);

        return isEqual;
    }

    @Override
    public String toString() {
        ScoreTracker tempTracker = this.newInstance();
        int originalSize = this.size();
        int count = 0;
        Map.Pair<String, Integer> entry = null;
        String playerID = null;
        int score = 0;
        String out = "ScoreTracker:\n";
        for (int i = 0; i < originalSize; i++) {
            entry = this.removeAny();
            playerID = entry.key();
            score = entry.value();
            out = out + "PlayerID: " + playerID + ", Score: " + score + "\n";
            count++;
            if (count < originalSize) {
                out += ", ";
            }
            tempTracker.addScore(playerID, score);
        }
        //restore
        this.transferFrom(tempTracker);
        return out;
    }

}
