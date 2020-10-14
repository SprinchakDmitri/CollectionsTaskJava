package com.company;

import java.util.Objects;

public class Student implements Comparable<Student>{

    String name;
    double mark;
    int course;
    String nameOfDiplomaSupervisor;

    Student(String name, double mark, int course, String dimplomaSupervisor){
        this.name = name;
        this.mark = mark;
        this.course= course;
        this.nameOfDiplomaSupervisor = dimplomaSupervisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return mark == student.mark &&
                course == student.course &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mark, course);
    }

    @Override
    public int compareTo(Student person) {
        return name.compareTo(person.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + name + '\'' +
                ", Mark=" + mark +
                ", Course=" + course +
                ", Diploma Supervisor='" + nameOfDiplomaSupervisor + '\'' +
                '}'+"\n";
    }
}
