import java.util.ArrayList;
import java.util.List;

public class Priorities
{

    private static List<Student> PriortyQ = new ArrayList<>();


    public static List<Student> getStudents(List<String> events)
    {
        for(String s : events)
        {
            processEvent(s);
        }

        return PriortyQ;
    }

    private static void processEvent(String text)
    {
        String[] result = text.split(" ");

        switch(result[0].charAt(0))
        {
            case 'E':
                insert
                (
                        new Student
                        (
                            Integer.parseInt(result[3]),
                            result[1],
                            Double.parseDouble(result[2])
                        )
                );
                break;
            case 'S':
                remove();
                break;


        }

    }

    private static void insert(Student student)
    {

        // if there are no elements, just add the first item and return
        if(PriortyQ.size() == 0)
        {
            PriortyQ.add(student);
            return;
        }

        // if there are items, insert in order.
        // Start from the end of the queue to shift items
        int i = 0;
        for(i = PriortyQ.size() - 1; i >=0; i--)
        {
            if (!PriortyQ.get(i).isPrioritized(student))
            {
                break;
            }
        }

        PriortyQ.add(i + 1, student);


    }

    private static void remove()
    {
        // remove the most prioritized item
        // and the remaining items will be shifted left
        if(!PriortyQ.isEmpty())
            PriortyQ.remove(0);
    }
}
