import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest
{
    private Workout workout;
    private Activity activityOne;
    private Activity activityTwo;
    private Activity activityThree;

    @BeforeEach
    void setUp()
    {
        workout = new Workout("Abs", 3);
        activityOne = new Activity("activity 1", 30, 0);
        activityTwo = new Activity("activity 2", 20, 40);
        activityThree = new Activity("activity 3", 20, 65);
    }
    @Test
    void getTotalSecondsOfRestWithNoActivitiesShouldReturnZero()
    {
        assertEquals(0, workout.getTotalSecondsOfRest());
    }

    @Test
    void getTotalSecondsOfRestWithOneActivityShouldReturnZero()
    {
        workout.addActivity(activityOne);
        assertEquals(0, workout.getTotalSecondsOfRest());
    }

    @Test
    void getTotalSecondsOfRestWithTwoActivitiesShouldReturnTen()
    {
        workout.addActivity(activityOne);
        workout.addActivity(activityTwo);

        assertEquals(10, workout.getTotalSecondsOfRest());
    }

    @Test
    void getTotalSecondsOfRestWithThreeActivitiesShouldReturnFifteen()
    {
        workout.addActivity(activityOne);
        workout.addActivity(activityTwo);
        workout.addActivity(activityThree);

        assertEquals(15, workout.getTotalSecondsOfRest());
    }
}