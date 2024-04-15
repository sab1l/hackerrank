package myjava.negative.subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/java-negative-subarray/problem
//contiguous subarrays
//calculate sum of a collection
public class Solution
{
    static int numberOfNegative = 0;


    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine(); //1st line not needed, we'll add to a list
        var arrayAsString = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        bufferedReader.close();
        int[] targetArray = arrayAsString.stream().mapToInt(Integer::intValue).toArray();
        subArray(targetArray);
        System.out.printf("%s%n", numberOfNegative);
    }


    private static void subArray(int[] arrayAsString)
    {

        List<Integer> tempArray = new ArrayList<>();
        //pick starting point
        //e.g. start at element 0
        for (var i = 0; i < arrayAsString.length; i++)
        {
            tempArray = new ArrayList<>(); //reset tempArray for every new subarray
            //pick ending point
            //e.g. finish at last element
            for (var j = i; j < arrayAsString.length; j++)
            {
                //operate subarray
                //e.g. add first element until last
                for (var k = j; k <= j; k++)
                {
                    tempArray.add(arrayAsString[k]);
                }
                calculateNegativeArrays(tempArray);
            }
        }

    }


    private static void calculateNegativeArrays(List<Integer> tempArray)
    {
        //sum all values
        var sum = tempArray.stream().reduce(0, Integer::sum);
        if (sum < 0)
        {
            numberOfNegative++;
        }
    }
}
