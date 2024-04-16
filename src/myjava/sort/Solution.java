package myjava.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution
{
    static List<Student> students;


    public static void main(String[] args) throws IOException
    {
        //process input
        students = loadInputToArray();
        printStudentsByOrder(students);
    }


    private static List<Student> loadInputToArray() throws IOException
    {
        students = new ArrayList<Student>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            lines.add(bufferedReader.readLine());
        }
        for (var currentLine : lines)
        {
            //split current line into 3 values - id, name, cgpa
            var contents = currentLine.split(" ");
            Student newStudent = new Student(
                Integer.valueOf(contents[0]),
                contents[1],
                Double.valueOf(contents[2]));
            students.add(newStudent);
        }
        return students;
    }


    private static void printStudentsByOrder(List<Student> students)
    {
        for (var student : students.stream().sorted(createStudentLambdaComparator()).collect(Collectors.toList()))
        {
            System.out.println(student);
        }
    }


    public static Comparator<Student> createStudentLambdaComparator()
    {
        return Comparator.comparing(Student::getCgpa)
            .reversed() //higher to lower CGPA value
            .thenComparing(Student::getName)
            .thenComparing(Student::getId);
    }


    public static class Student
    {
        int id;
        String name;
        Double cgpa;

        @Override
        public String toString()
        {
            return getName();
        }


        public int getId()
        {
            return id;
        }


        public void setId(int id)
        {
            this.id = id;
        }


        public String getName()
        {
            return name;
        }


        public void setName(String name)
        {
            this.name = name;
        }


        public Double getCgpa()
        {
            return cgpa;
        }


        public void setCgpa(Double cgpa)
        {
            this.cgpa = cgpa;
        }




        public Student(int id, String name, Double cgpa)
        {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }


    }
}
