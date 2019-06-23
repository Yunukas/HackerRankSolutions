import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{

    public static void main(String[] args)
    {
        List<String> inputs = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);

        int q = Integer.parseInt(sc.nextLine());

        while( q-- > 0)
        {
            inputs.add(sc.nextLine());
        }

        List<Student> students =  Priorities.getStudents(inputs);

        if (students.isEmpty())
            System.out.println("EMPTY");
        else
            for(Student s : students)
            {
                System.out.println(s.getName());
            }
    }
}
