import java.util.Comparator;

public class Checker<T> implements Comparator<T>
{
    @Override
    public int compare(T o1, T o2)
    {

        int score1 = ((Player)o1).score;
        int score2 = ((Player)o2).score;

        if(score1 > score2)
        {
            return -1;
        }
        else if(score1 < score2)
        {
            return 1;
        }
        else
        {
            String name1 = ((Player)o1).name;
            String name2 = ((Player)o2).name;

            return (name1.compareTo(name2));
        }
    }
}
