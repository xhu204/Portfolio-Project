import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A simple game using the ScoreTracker component
 */
public class useCasesGameSimulation {
    public static void main(String[] args) {
        // Create a new ScoreTracker instance
        ScoreTracker tracker = new ScoreTracker1L();
        SimpleWriter out = new SimpleWriter1L();

        // Add initial scores for players
        tracker.addScore("Player1", 10);
        tracker.addScore("Player2", 15);
        tracker.addScore("Player3", 12);

        out.println("Initial Scores:");
        out.println(tracker.toString());

        out.close();
    }
}
