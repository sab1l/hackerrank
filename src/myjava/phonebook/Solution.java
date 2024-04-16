package myjava.phonebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/phone-book/problem
//map filling & querying
//input processing until EOF
public class Solution
{
    static Map<String, Integer> phoneBook;
    static ArrayList<String> queries;

    public static void main(String[] args) throws IOException
    {
        phoneBook = new HashMap<>();
        queries = new ArrayList<>();
        loadInputToMap(phoneBook, queries);
        executeQueries();
    }


    private static void executeQueries()
    {
        for (var query : queries)
        {
            Integer phoneNumber = phoneBook.get(query);
            if (phoneNumber != null)
            {
                System.out.printf("%s=%s%n", query, phoneNumber);
            }
            else
            {
                System.out.println("Not found");
            }
        }
    }


    private static void loadInputToMap(Map<String, Integer> phoneBook, ArrayList<String> queries) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        //parse phonebook entries
        for (int i = 0; i < n; i++)
        {
            var name = bufferedReader.readLine();
            var phoneNumber = bufferedReader.readLine();
            phoneBook.put(name, Integer.valueOf(phoneNumber));
        }
        //parse queries
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0)
        {
            queries.add(line);
        }
    }
}
