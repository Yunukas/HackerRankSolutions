import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b)
    {
        /*
         * Write your code here.
         */
        int aPos = 0;
        int bPos = 0;

        int score = 0;

        int removed = 0;

        while(aPos < a.length)
            if ((score + a[aPos]) <= x) {
                score += a[aPos++];
                //removed++;
            } else break;

            removed = aPos;


         while(bPos < b.length && aPos >= 0)
         {
            score += b[bPos++];

            while(score > x && aPos > 0)
            {
                --aPos;
                score -= a[aPos];
            }

            if(score <= x && (aPos + bPos) > removed)
                removed = aPos + bPos;

         }

        return removed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

//            System.out.println((result));


            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
