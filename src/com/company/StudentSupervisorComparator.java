package com.company;

import java.util.Comparator;

public class StudentSupervisorComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.nameOfDiplomaSupervisor
                 .compareTo(o2.nameOfDiplomaSupervisor);
    }
}
