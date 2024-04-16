package myjava.generics;

import java.util.ArrayList;

//https://www.hackerrank.com/challenges/java-generics/problem
//generics custom array list
//polymorphism
public class Solution
{
    public static void main(String[] args) {
        CustomArrayList<Integer> listOfIntegers = new CustomArrayList<>();
        for (int i = 1; i < 4; i++) {
            listOfIntegers.add(i);
        }
        CustomArrayList<String> listOfStrings = new CustomArrayList<>();
        listOfStrings.add("Hello");
        listOfStrings.add("World");
        printArray(listOfIntegers);
        printArray(listOfStrings);
    }


    private static void printArray(CustomArrayList arrayList)
    {
        System.out.print(arrayList.toString());
    }


    public static class CustomArrayList<T> {
        ArrayList<T> customArrayList = new ArrayList<>();
        public CustomArrayList()
        {
        }

        public void remove(T element) {
            customArrayList.remove(element);
        }

        public void add(T element)
        {
            customArrayList.add(element);
        }


        @Override
        public String toString()
        {
            StringBuilder stringBuilder = new StringBuilder();
            for (var entry : customArrayList ) {
                stringBuilder.append(String.format("%s%n",entry.toString()));
            }
            return stringBuilder.toString();
        }
    }
}
