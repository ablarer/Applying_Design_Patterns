package com.agiledeveloper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Person {
  private String firstName;
  private String lastName;
  private List<Person> friends = new ArrayList<>();

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Person> getFriends() {
    return friends;
  }

  public void addFriend(Person friend) {
    friends.add(friend);
  }

  public List<String> getFirstNamesOfFriends() {
//    return friends.stream()
//      //.map(friend -> friend.getFirstName())
//      .map(Person::getFirstName)
//      .collect(Collectors.toList());
    return getFirstNamesOfFriends(friend -> true);
  }

  public List<String> getFirstNamesOfFriends(Predicate<Person> selector) {
    return friends.stream()
      .filter(selector)
      .map(Person::getFirstName)
      .collect(Collectors.toList());
  }
}
