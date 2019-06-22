import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class Dequeue
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        HashSet<Integer> hs = new HashSet<>();
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            hs.add(num);

            if((i + 1) >= m )
            {
                if(hs.size() > maxSize)
                    maxSize = hs.size();

                int first = deque.remove();

                if(!deque.contains(first))
                {
                    hs.remove(first);
                }
            }
        }
        System.out.println(maxSize);
    }
}
