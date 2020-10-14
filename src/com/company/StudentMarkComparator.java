package com.company;

import java.util.Comparator;

public class StudentMarkComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.mark > s2.mark) return -1;
        else if(s1.mark < s2.mark) return 1;
        else return 0;
    }
}
