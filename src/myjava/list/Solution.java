package myjava.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.hackerrank.com/challenges/java-list/problem
//collection add & remove
//switch case
//boolean as a status switch in a for loop
public class Solution
{
    static ArrayList<Integer> arrayOfIntegers;
    static ArrayList<ArrayList<String>> arraysOfQueries;


    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        arrayOfIntegers = new ArrayList<Integer>();
        arraysOfQueries = new ArrayList<ArrayList<String>>();
        //load input into array
        arrayOfIntegers = loadInputToArray(bufferedReader);
        //load input into queries
        arraysOfQueries = loadInputToQueries(bufferedReader);

        bufferedReader.close();
        //process queries
        processQueries();
        printOutput();
    }

    private static void printOutput()
    {
        for (var value : arrayOfIntegers)
        {
            System.out.print(value + " ");
        }
    }

    private static void processQueries()
    {
        for (var query : arraysOfQueries)
        {
            String operation = query.get(0);
            switch (operation)
            {
                case "Insert":
                    arrayOfIntegers.add(Integer.valueOf(query.get(1)), Integer.valueOf(query.get(2)));
                    break;
                case "Delete":
                    arrayOfIntegers.remove(Integer.parseInt(query.get(1))); //note Integer.valueOf would pass
                    // object instead of index
                    break;
                default:
                    System.out.println("no match");
            }
        }
    }


    private static ArrayList<ArrayList<String>> loadInputToQueries(
        BufferedReader bufferedReader) throws IOException
    {
        arraysOfQueries = new ArrayList<ArrayList<String>>();
        int n = Integer.parseInt(bufferedReader.readLine()) * 2;
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            lines.add(bufferedReader.readLine());
        }

        var stringOperation = true;
        ArrayList<String> arrayOfStrings = new ArrayList<>();
        for (var currentLine : lines)
        {
            if (stringOperation)
            {
                arrayOfStrings = new ArrayList<>(); //reset array for every new operation
                arrayOfStrings.add(currentLine);
                stringOperation = false; //so next line can be added to same array
            }
            else
            {
                Collections.addAll(arrayOfStrings, currentLine.split(" ")); //split String by
                // space character and add to array
                stringOperation = true;
                //add line of array to destination array
                arraysOfQueries.add(arrayOfStrings);
            }
        }
        return arraysOfQueries;
    }

    private static ArrayList<Integer> loadInputToArray(
        BufferedReader bufferedReader) throws IOException
    {
        //read from stdin each line
        bufferedReader.readLine(); //line 1 not needed, ignore
        return Stream.of(bufferedReader.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toCollection(ArrayList::new));
    }

}
