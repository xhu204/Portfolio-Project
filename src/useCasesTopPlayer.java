import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class useCasesTopPlayer {
    public static void main(String[] args) {
        ScoreTracker tracker = new ScoreTracker1L();
        SimpleWriter out = new SimpleWriter1L();

        // Add initial scores for players
        tracker.addScore("Player1", 10);
        tracker.addScore("Player2", 15);
        tracker.addScore("Player3", 12);

        out.println("Top player is:");
        out.println(tracker.getTopPlayer());

        out.close();

    }
}
