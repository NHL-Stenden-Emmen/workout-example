import java.util.ArrayList;
import java.util.List;

public class Workout
{
    private String name;
    private double difficulty;
    private List<Activity> activities;
    
    public Workout(String name, double difficulty)
    {
        this.name = name;
        setDifficulty(difficulty);
        this.activities = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getDifficulty()
    {
        return this.difficulty;
    }

    public void setDifficulty(double difficulty)
    {
    if (difficulty % 0.5 == 0 && difficulty >= 1 && difficulty <= 5)
        {
            this.difficulty = difficulty;
        }
        throw new IllegalArgumentException("Difficulty should be between 1 and 5");
    }

    public List<Activity> getActivities()
    {
        return this.activities;
    }


    public void setActivities(List<Activity> activities)
    {
        this.activities = activities;
    }

    public int getTotalDuration()
    {
        if (this.activities.isEmpty())
        {
            return 0;
        }
        
        Activity activity = this.activities.get(this.activities.size() - 1);
        
        return activity.getEndTime();
    }
    
    public int getTotalSecondsOfRest()
    {
        int totalRest = 0;

        if (this.activities.size() <= 1)
        {
            // When there are 0 or 1 activities, there is no rest
            return 0;
        }


        for (int i = 1; i < this.activities.size(); i++)
        {
            Activity second = this.activities.get(i);
            Activity first = this.activities.get(i - 1);
            
            int difference = second.getStartTime() - first.getEndTime();
            totalRest += difference;
        }
        
        return totalRest;
    }
    
    public void addActivity(Activity activity)
    {
        if (activity.getStartTime() >= this.getTotalDuration())
        {
            this.activities.add(activity);
        }
        else throw new IllegalArgumentException("Activity cannot start before the previous one ends");
    }
    
    public String getWorkoutDescription()
    {
        int number = 1;
        String result = this.name + "\n";
        
        for (Activity activity : this.activities)
        {
            result += number + " " + activity.getDescription() + "\n";
            number++;
        }
        
        return result;
    }
}
