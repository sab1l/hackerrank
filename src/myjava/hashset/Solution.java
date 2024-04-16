package myjava.hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//https://www.hackerrank.com/challenges/java-hashset/problem
public class Solution
{
    static HashSet<String> set;
    public static void main(String[] args) throws IOException
    {
        set = new HashSet<>();
        loadInput();
    }

    private static void loadInput() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++)
        {
            set.add(bufferedReader.readLine());
            System.out.println(set.size());
        }
    }
}