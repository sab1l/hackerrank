package myjava.oned.array.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.hackerrank.com/challenges/java-1d-array-introduction/problem
//single line input as string converted to integer, piled in an array
//usage of arrays stream for each
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        printArray(storeFromInputToArray(n, bufferedReader));
        bufferedReader.close();

    }

    public static void printArray(int[] toPrint) {
        Arrays.stream(toPrint).forEach(System.out::println);
    }

    public static int[] storeFromInputToArray(int length, BufferedReader bufferedReader) throws IOException
    {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.parseInt(bufferedReader.readLine());
        }
        return result;
    }

}
