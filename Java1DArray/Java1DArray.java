import java.util.*;
import java.util.LinkedList;

public class Java1DArray
{

    static class Node
    {
        public int index;
        public int value;

        public Node (int id, int value)
        {
            this.index = id;
            this.value = value;
        }
    }

    static boolean isMovable(int index, ArrayList<Node> list)
    {
        if(!list.isEmpty())
        {
            if((list.get(index)).value == 0)
                return true;
        }

        return false;
    }

    static boolean isVisited(Node n, HashSet<Node> hs)
    {
        if(hs.contains(n))
            return true;

        return false;
    }

    static boolean canWin(int leap, int[] game)
    {
        // Return true if you can win the game; otherwise, return false.

        int[] possibleMoves = {-1, +1, leap};

        List<Node> possibleLinks = new ArrayList<>();

        HashSet<Node> visitedLinks = new HashSet<>();

        ArrayList<Node> gameList = new ArrayList<>();

        // construct the linked list
        for(int i = 0; i < game.length; i++)
        {
            gameList.add(new Node(i, game[i]));
        }

        possibleLinks.add(gameList.get(0));

        while(!possibleLinks.isEmpty())
        {
            Node first = possibleLinks.get(0);
            possibleLinks.remove(0);

            for(int i : possibleMoves)
            {
                int index = first.index + i;

                if(index < 0) continue;

                if(index >= gameList.size())
                    return true;

                if(isMovable(index, gameList) && !isVisited(gameList.get(index), visitedLinks))
                {
                    possibleLinks.add(gameList.get(first.index + i));
                    visitedLinks.add(gameList.get(first.index + i));
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
