package javasamples.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student(20, "Amit"), new Student(10, "Gaurav"), new Student(1, "AAA"));

        list.sort(new SortByRoll());
        System.out.printf("Sorted by rollno: %s", list);

        System.out.println();

        list.sort(new SortByName());
        System.out.printf("Sorted by name: %s", list);
    }

}

class SortByRoll implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getRollno() - o2.getRollno();
    }

}

class SortByName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

}

class Student {

    int rollno;
    String name;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                '}';
    }
}
