import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;

/**
 * Test class for the ScoreTracker component.
 *
 * <p>
 * This class uses JUnit to test all methods of the ScoreTracker component,
 * including the Standard methods (newInstance, clear, transferFrom), kernel
 * methods (addScore, getScore, updateScore, isPlayer, removeAny, add, size),
 * and secondary methods (getHighestScore, getTopPlayer, removePlayer,
 * getTotalPlayers).
 * </p>
 *
 * @author Xin Hu
 * @version 1.0
 */
public class ScoreTrackerTest {

    /**
     * Tests the newInstance method.
     */
    @Test
    public void testNewInstance() {
        ScoreTracker tracker = new ScoreTracker1L();
        ScoreTracker newTracker = tracker.newInstance();
        assertEquals(false, tracker == newTracker);
    }

    /**
     * Tests the clear method.
     */
    @Test
    public void testClear() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("A", 1);
        tracker.addScore("B", 2);
        tracker.clear();
        assertEquals(0, tracker.size());
    }

    /**
     * Tests the transferFrom method.
     */
    @Test
    public void testTransferFrom() {
        ScoreTracker source = new ScoreTracker1L();
        ScoreTracker tracker = new ScoreTracker1L();
        source.addScore("AA", 1);
        source.addScore("BB", 2);

        tracker.transferFrom(source);

        assertEquals(2, tracker.size());
        assertEquals(true, tracker.isPlayer("AA"));
        assertEquals(1, tracker.getScore("AA"));
        assertEquals(2, tracker.getScore("BB"));

        assertEquals(0, source.size());
    }

    /**
     * Tests the addScore method for new and existing players.
     */
    @Test
    public void testAddScore() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        assertEquals(1, tracker.getScore("AA"));

        // Add score to an existing player
        tracker.addScore("AA", 2);
        assertEquals(3, tracker.getScore("AA"));
    }

    /**
     * Tests the getScore method.
     */
    @Test
    public void testGetScore() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        assertEquals(1, tracker.getScore("AA"));
    }

    /**
     * Tests the updateScore method.
     */
    @Test
    public void testUpdateScore() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        tracker.updateScore("AA", 2);
        assertEquals(2, tracker.getScore("AA"));
    }

    /**
     * Tests the isPlayer method.
     */
    @Test
    public void testIsPlayer() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        assertEquals(true, tracker.isPlayer("AA"));
        assertEquals(false, tracker.isPlayer("BB"));
    }

    /**
     * Tests the removeAny method.
     */
    @Test
    public void testRemoveAny() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        tracker.addScore("BB", 2);

        Map.Pair<String, Integer> removedEntry = tracker.removeAny();
        assertEquals(false, removedEntry == null);
        assertEquals(1, tracker.size());

        // Ensure that the removed player is either "Jack" or "Kathy"
        String removedPlayer = removedEntry.key();
        boolean isValidPlayer = removedPlayer.equals("AA")
                || removedPlayer.equals("BB");
        assertEquals(true, isValidPlayer);
    }

    /**
     * Tests the add method.
     */
    @Test
    public void testAdd() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        assertEquals(1, tracker.getScore("AA"));
        assertEquals(true, tracker.isPlayer("AA"));
    }

    /**
     * Tests the size method.
     */
    @Test
    public void testSize() {
        ScoreTracker tracker = new ScoreTracker1L();
        assertEquals(0, tracker.size());
        tracker.addScore("AA", 1);
        assertEquals(1, tracker.size());
        tracker.addScore("BB", 2);
        assertEquals(2, tracker.size());
    }

    /**
     * Tests the getHighestScore method.
     */
    @Test
    public void testGetHighestScore() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        tracker.addScore("BB", 2);
        tracker.addScore("CC", 0);

        int highestScore = tracker.getHighestScore();
        assertEquals(2, highestScore);
    }

    /**
     * Tests the getTopPlayer method.
     */
    @Test
    public void testGetTopPlayer() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        tracker.addScore("BB", 2);
        tracker.addScore("CC", 0);

        String topPlayer = tracker.getTopPlayer();
        assertEquals("BB", topPlayer);
    }

    /**
     * Tests the removePlayer method.
     */
    @Test
    public void testRemovePlayer() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        tracker.addScore("BB", 2);

        tracker.removePlayer("AA");
        assertEquals(1, tracker.size());
        assertEquals(false, tracker.isPlayer("AA"));
    }

    /**
     * Tests the getTotalPlayers method.
     */
    @Test
    public void testGetTotalPlayers() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        tracker.addScore("BB", 2);

        int totalPlayers = tracker.getTotalPlayers();
        assertEquals(2, totalPlayers);
    }

    /**
     * Tests the equals method.
     */
    @Test
    public void testEquals() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        tracker.addScore("BB", 2);

        ScoreTracker tracker2 = new ScoreTracker1L();
        tracker2.addScore("AA", 1);
        tracker2.addScore("BB", 2);

        assertEquals(true, tracker.equals(tracker2));

        tracker2.updateScore("AA", 2);
        assertEquals(false, tracker.equals(tracker2));
    }

    /**
     * Tests the toString method.
     */
    @Test
    public void testToString() {
        ScoreTracker tracker = new ScoreTracker1L();
        tracker.addScore("AA", 1);
        tracker.addScore("BB", 2);

        String trackerString = tracker.toString();
        // The string should contain both players and their scores
        boolean containsBetty = trackerString.contains("AA");
        boolean containsCarlos = trackerString.contains("BB");
        boolean contains1 = trackerString.contains("1");
        boolean contains2 = trackerString.contains("2");

        assertEquals(true, containsBetty);
        assertEquals(true, containsCarlos);
        assertEquals(true, contains1);
        assertEquals(true, contains2);
    }

}
