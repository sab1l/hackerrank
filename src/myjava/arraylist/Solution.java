package myjava.arraylist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//https://www.hackerrank.com/challenges/java-arraylist/problem
//build dynamic ArrayList
public class Solution
{
    static StringBuilder stringArraysOfD;
    static StringBuilder stringQueries;
    static ArrayList<ArrayList<Integer>> arraysOfD = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> arraysOfQueries = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> tmpArrayOfIntegers = new ArrayList<Integer>();


    public static void main(String[] args) throws IOException
    {
        stringArraysOfD = new StringBuilder();
        stringQueries = new StringBuilder();

        loadInputInto(stringArraysOfD, stringQueries);
        buildArrayOfD(stringArraysOfD.toString());
        buildArrayOfQueries(stringQueries.toString());
        for (ArrayList<Integer> query : arraysOfQueries)
        {
            queryArray(query.get(0), query.get(1));
        }
    }


    private static void queryArray(int queryX, int queryY)
    {
        try
        {
            System.out.println(String.format("%s", arraysOfD.get(queryX - 1).get(queryY - 1)));
        }
        catch (Exception e)
        {
            System.out.println("ERROR!");
        }
    }


    private static void buildArrayOfQueries(String queries)
    {
        String[] lines = queries.split("\\n");
        for (String line : lines)
        {
            tmpArrayOfIntegers = new ArrayList<Integer>();
            String[] currentline = line.split("\\s+");
            for (var currentLineItem : currentline)
            {
                tmpArrayOfIntegers.add(Integer.valueOf(currentLineItem));
            }
            arraysOfQueries.add(tmpArrayOfIntegers);
        }
    }


    private static void buildArrayOfD(String arrays)
    {
        //split by newline char
        String[] lines = arrays.split("\\n");

        //e.g. '1 12|2 13 14' > [12] [13,14]
        for (String line : lines)
        {
            //reset temporary array for each new line
            tmpArrayOfIntegers = new ArrayList<Integer>();
            String[] currentline = line.split("\\s+");//split by space
            for (int index = 0; index < currentline.length; index++)
            {
                //ignore first value (size)
                //add others
                if (index > 0)
                {
                    tmpArrayOfIntegers.add(Integer.valueOf(currentline[index]));
                }
            }
            //flush line array to target general array
            arraysOfD.add(tmpArrayOfIntegers);
        }
    }


    private static void loadInputInto(StringBuilder stringArraysOfD, StringBuilder stringQueries) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        buildStringFrom(bufferedReader, stringArraysOfD);
        buildStringFrom(bufferedReader, stringQueries);
        bufferedReader.close();
    }


    private static void buildStringFrom(BufferedReader bufferedReader, StringBuilder stringBuilder) throws IOException
    {
        int n = Integer.parseInt(bufferedReader.readLine());
        int lineCount = 1;
        while (lineCount <= n)
        {
            stringBuilder.append(bufferedReader.readLine()).append("\n");
            lineCount++;
        }
    }
}
