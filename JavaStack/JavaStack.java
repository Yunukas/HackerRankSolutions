import java.util.Scanner;
import java.util.Stack;

public class JavaStack
{
    static Stack<String> st = new Stack();

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code

            for(int i = 0; i < input.length(); i++)
            {
                char c = input.charAt(i);
                String s = getString(c);
                processString(s);
            }

            if(st.empty())
                System.out.println("true");
            else
                System.out.println("false");

            st.removeAllElements();
        }

    }

    public static void processString(String c)
    {
        switch(c)
        {
            case "{":
            case "[":
            case "(":
                st.push(c);
                break;
            case "}":
                if(st.isEmpty())
                    st.push(c);
                else if (st.peek().equals("{"))
                    st.pop();
                break;
            case "]":
                if(st.isEmpty())
                    st.push(c);
                else if (st.peek().equals("["))
                    st.pop();
                break;
            case ")":
                if(st.isEmpty())
                    st.push(c);
                else if (st.peek().equals("("))
                    st.pop();
                break;
            default:
                break;
        }
    }

    public static String getString(char c)
    {
        return String.valueOf(c);
    }
}
