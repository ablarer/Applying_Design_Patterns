package com.agiledeveloper;

public class Person {
  private String name;
  private int age;
  private int yearsOfExperience;
  private boolean degreeHolder;

  public Person(String name, int age, int yearsOfExperience, boolean degreeHolder) {
    this.name = name;
    this.age = age;
    this.yearsOfExperience = yearsOfExperience;
    this.degreeHolder = degreeHolder;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getYearsOfExperience() {
    return yearsOfExperience;
  }

  public boolean isDegreeHolder() {
    return degreeHolder;
  }
}
