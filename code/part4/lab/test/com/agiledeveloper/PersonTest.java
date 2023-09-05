package com.agiledeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
  Person host;

  @BeforeEach
  void init() {
//    host = new Person("Sam", "Walker");
  }

  @Test
  void canary() {
//    assertTrue(true);
  }

  @Test
  void createHost() {
//    assertEquals("Sam", host.getFirstName());
//    assertEquals("Walker", host.getLastName());
  }

  @Test
  void hostHasNoFriends(){
//    List<Person> friends = host.getFriends();
//
//    assertEquals(0, friends.size());
  }

  @Test
  void hostHasOneFriend() {
//    host.addFriend(new Person("Sara", "Parker"));
//
//    assertEquals(1, host.getFriends().size());
//    assertEquals("Sara", host.getFriends().get(0).getFirstName());
  }

  @Test
  void hostHasTwoFriends() {
//    host.addFriend(new Person("Sara", "Parker"));
//    host.addFriend(new Person("Dev", "Patel"));
//
//    assertEquals(2, host.getFriends().size());
//    assertEquals("Dev", host.getFriends().get(1).getFirstName());
  }

  @Test
  void getAllFriendsFirstNamesWhenThereAreNoFriends() {
//    List<String> firstNames = host.getFirstNamesOfFriends...
//
//    assertEquals(Arrays.asList(), firstNames);
  }

  @Test
  void getAllFriendsFirstNamesWhenThereAreFriends() {
//    host.addFriend(new Person("Sara", "Parker"));
//    host.addFriend(new Person("Dev", "Patel"));
//    host.addFriend(new Person("Paul", "Ming"));

//    List<String> firstNames = host.getFirstNamesOfFriends...

//    assertEquals(Arrays.asList("Sara", "Dev", "Paul"), firstNames);
  }

  @Test
  void getNamesForLastNameStartingWithPWhenThereAreNone() {
//    host.addFriend(new Person("Paul", "Ming"));
//    List<String> firstNames = host.getFirstNamesOfFriends...

//    assertEquals(Arrays.asList(), firstNames);
  }

  @Test
  void getNamesForLastNameStartingWithPWhenThereAreSome() {
//    host.addFriend(new Person("Sara", "Parker"));
//    host.addFriend(new Person("Dev", "Patel"));
//    host.addFriend(new Person("Paul", "Ming"));

//    List<String> firstNames = host.getFirstNamesOfFriends...

//    assertEquals(Arrays.asList("Sara", "Dev"), firstNames);
  }

  @Test
  void getNamesForFirstNameStartingWithPWhenThereAreNone() {
//    host.addFriend(new Person("Sara", "Parker"));
//    List<String> firstNames = host.getFirstNamesOfFriends...

//    assertEquals(Arrays.asList(), firstNames);
  }

  @Test
  void getNamesForFirstNameStartingWithPWhenThereAreSome() {
//    host.addFriend(new Person("Sara", "Parker"));
//    host.addFriend(new Person("Dev", "Patel"));
//    host.addFriend(new Person("Paul", "Ming"));

//    List<String> firstNames = host.getFirstNamesOfFriends...

//    assertEquals(Arrays.asList("Paul"), firstNames);
  }
}
