import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App
{
    private List<Workout> workouts;
    
    public App()
    {
        this.workouts = new ArrayList<>();
    }
    
    public List<Workout> getWorkouts()
    {
        return this.workouts;
    }
    
    public void addWorkout(Workout workout)
    {
        if(workout == null)
        {
            throw new IllegalArgumentException("Workout cannot be null");
        }
        this.workouts.add(workout);
    }
    
    public int getTotalSecondsOfWorkouts()
    {
        int total = 0;
        
        for (Workout workout : this.workouts)
        {
            total += workout.getTotalDuration();
        }
        
        return total;
    }
    
    public List<Workout> removeWorkoutsThatAreTooLong()
    {
        Iterator<Workout> it = this.workouts.iterator();
        ArrayList<Workout> deleted = new ArrayList<>();
        
        while (it.hasNext())
        {
            Workout workout = it.next();
            if (workout.getTotalDuration() > 600)
            {
                deleted.add(workout);
                it.remove();
            }
        }
        
        return deleted;
    }
}
