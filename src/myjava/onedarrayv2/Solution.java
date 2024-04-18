package myjava.onedarrayv2;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-1d-array/problem
//KO for TC:
/*
1
10 6
0 0 1 1 0 0 1 1 0 0
Expected Output
NO

 */
public class Solution
{
    public static boolean canWin(int leap, int[] game)
    {
        // Maybe logic here should be changed to move/jump, not working for TC described above
        // Return true if you can win the game; otherwise, return false.
        int counter = 0;
        boolean empty = true;
        boolean consecutive = false;
        for (var cell : game)
        {
            if (cell == 1)
            {
                if (consecutive)
                {
                    counter++;
                }
                else
                {
                    counter = 1;
                }
                empty = false;
                consecutive = true;
            }
            if (cell == 0)
            {
                consecutive = false;
                //reset consecutive boolean to false
            }

        }
        if (empty)
        {
            return true;
        }
        else
        {

            return (leap > counter);
        }
    }


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0)
        {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++)
            {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}