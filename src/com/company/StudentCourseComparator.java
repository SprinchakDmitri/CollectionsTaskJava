package com.company;

import java.util.Comparator;

public class StudentCourseComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.course < s2.course) return -1;
        else if(s1.course > s2.course) return 1;
        else return 0;
    }
}
