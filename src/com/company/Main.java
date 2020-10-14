package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Student> students;
        Comparator<Student> comparator = null;

        students1.add(new Student("Ivan Petrov",9.0,4,"Grigorii Ilin"));
        students1.add(new Student("Pert Sidorov",5.53,2,"Grigorii Ilin"));
        students1.add(new Student("Anastasia Voloshina",9.51,3,"Ivanov"));
        students1.add(new Student("Petr Svidler",10,4,"Ivanov"));

        students2.add(new Student("Ivan Petrov",9.0,4,"Grigorii Ilin"));
        students2.add(new Student("Anatoli Karpov",6.58,3,"Grigorii Ilin"));
        students2.add(new Student("Anastasia Voloshina",9.51,3,"Ivanov"));
        students2.add(new Student("Petr Svidler",7.54,4,"Crestianov Ivan"));

        students = distinctValuesOfLists(students1,students2);

        System.out.println(students.toString());

        System.out.println("Please enter number." +"\n" +
                "Enter 0 to sort students by name"+"\n" +
                "Enter 1 to sort students by course"+"\n" +
                "Enter 2 to sort students by diploma supervisor"+"\n" +
                "By default student sorts by marks");

        int input = in.nextInt();

        switch(input) {
            case 0: comparator = new StudentNameComparator()
                    .thenComparing(new StudentMarkComparator()); break;

            case 1: comparator = new StudentCourseComparator()
                    .thenComparing(new StudentNameComparator())
                    .thenComparing(new StudentMarkComparator()); break;
                    
            case 2: comparator = new StudentSupervisorComparator()
                    .thenComparing(new StudentNameComparator())
                    .thenComparing(new StudentMarkComparator()); break;    
                    
            default: comparator = new StudentMarkComparator()
                    .thenComparing(new StudentNameComparator());
        }
        students.sort(comparator);
        System.out.println(students.toString());
    }


    static <T extends Comparable> List<T> distinctValuesOfLists(
                                  List<T> firstList,
                                  List<T> secondList){

        List<T> thirdList = new ArrayList<>();

        uniqueElements((List<T>) firstList, (List<T>) thirdList);
        uniqueElements((List<T>) secondList, (List<T>) thirdList);

        return thirdList;
    }




    private static <T extends Comparable> void uniqueElements(List<T> firstList,
                                                              List<T> secondList) {
        boolean findedUnique;

        for(int i = 0; i < firstList.size(); i++) {
            findedUnique = true;
            for (int j = 0; secondList.size() > j; j++) {
                if (secondList.get(j).equals(firstList.get(i))) {
                    findedUnique = false;
                    break;
                }
            }
            if (findedUnique) secondList.add(firstList.get(i));
        }
    }

}
