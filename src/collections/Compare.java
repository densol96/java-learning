package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

enum Course {
  FIRST(1),
  SECOND(2),
  THIRD(3),
  FOURTH(4);

  private final int value;

  Course(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}

class Student implements Comparable<Student> {
  String name;
  Course year;

  Student(String name, Course year) {
    this.name = name;
    this.year = year;
  }

  @Override
  public int compareTo(Student that) {
    return this.year.getValue() > that.year.getValue() ? 1 : -1;
  }

  @Override
  public String toString() {
    return this.name + " -- " + this.year;
  }
}

public class Compare {

  private static ArrayList<Student> stList = new ArrayList<>();

  private static void fillList() {
    Student s1 = new Student("Deniss", Course.SECOND);
    Student s2 = new Student("David", Course.FOURTH);
    Student s3 = new Student("Edik", Course.FIRST);
    Student s4 = new Student("Misha", Course.THIRD);
    stList.add(s1);
    stList.add(s2);
    stList.add(s3);
    stList.add(s4);
  }

  public static void sortStudentsUp() {
    fillList();
    System.out.println(stList);
    Collections.sort(stList);
    System.out.println(stList);
  }

  public static void sortStudentsDown() {
    stList.clear();
    fillList();
    System.out.println(stList);
    Comparator<Student> compFunc = (o1, o2) -> o1.year.getValue() < o2.year.getValue() ? 1 : -1;

    Collections.sort(stList, compFunc);
    System.out.println(stList);
  }
}