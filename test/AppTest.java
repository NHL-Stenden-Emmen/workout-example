import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest
{

    private App app;
    private Workout workoutOne;
    private Workout workoutTwo;
    private Workout workoutThree;

    @BeforeEach
    void setup()
    {
        app = new App();
        workoutOne = new Workout("Core", 1);
        workoutTwo = new Workout("Abs", 2);
        workoutThree = new Workout("Leg", 1);
    }

    @Test
    void addWorkoutNullShouldThrowIllegalArgument()
    {
        workoutOne = null;
        assertThrows(IllegalArgumentException.class, ()-> app.addWorkout(workoutOne));
    }

    @Test
    void addWorkoutShouldAddWorkout()
    {
        assertDoesNotThrow(()->app.addWorkout(workoutOne));
        assertDoesNotThrow(()->app.addWorkout(workoutTwo));
        assertDoesNotThrow(()->app.addWorkout(workoutThree));

        assertEquals(3, app.getWorkouts().size());
    }
}