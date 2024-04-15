package myjava.twod.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/java-2d-array/problem
//input transformed from Stream of strings to nested array of integers
//e.g. "1 1 1 0 0 0" > [1, 1, 1, 0, 0, 0]
//usage of array subList
public class Solution
{

    public static final int TOTAL_OF_HOUR_GLASSES_IN_A_ROW = 4;


    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> array2dOfIntegers = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try
            {
                array2dOfIntegers.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        var max= Integer.MIN_VALUE; //initialization important for negative sums, not 0
        var lineEnd= 3;
        //iterate over 3 lines
        for (int lineStart = 0; lineStart < TOTAL_OF_HOUR_GLASSES_IN_A_ROW; lineStart++) {
            //iterate over columns to be added
            for (int hourGlassColumnIndex = 0; hourGlassColumnIndex < TOTAL_OF_HOUR_GLASSES_IN_A_ROW; hourGlassColumnIndex++) {
                var hourGlass = buildHourGlass(createHourGlassLines(array2dOfIntegers,lineStart,lineEnd,hourGlassColumnIndex));
                var hourGlassSum = calculateSumOfHourGlass(hourGlass);
                if (hourGlassSum > max) {
                    max = hourGlassSum;
                }
            }
            lineEnd++;
        }
        System.out.println(String.format("%d", max));
    }


    private static Integer calculateSumOfHourGlass(List<Integer> hourGlass)
    {
        return hourGlass.stream()
            .reduce(0, Integer::sum);
    }

    private static List<Integer> buildHourGlass(List<List<Integer>> hourGlassLines)
    {
        List<Integer> accumulator = new ArrayList<>();
        var lineNumber = 0;
        //for middle line, store only index 1
        for (List<Integer> hourGlass : hourGlassLines) {
            if (lineNumber == 1) {
                accumulator.add(hourGlass.get(1));
            } else {
                accumulator.addAll(hourGlass);
            }

            lineNumber++;
        }
        return accumulator;
    }


    public static List<List<Integer>> createHourGlassLines(List<List<Integer>> arr, int lineStart, int lineEnd, int hourGlassIndex) {
        List<List<Integer>> hourGlass = new ArrayList<>();
        for (var lines : arr.subList(lineStart,lineEnd)) {
            var lastColumnOfHourGlass = 3; // exclusive of 3, 2 will be taken on first pass
            for (var hourGlassMovingIndex = 0; hourGlassMovingIndex < TOTAL_OF_HOUR_GLASSES_IN_A_ROW; hourGlassMovingIndex++) {
                if (hourGlassMovingIndex == hourGlassIndex) { //to only consider targeted hourglass, not all
                    hourGlass.add(lines.subList(hourGlassMovingIndex, lastColumnOfHourGlass));
                }
                lastColumnOfHourGlass++;
            }
        }
        return hourGlass;
    }
}
