package com.foxbill.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.foxbill.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class Container {
    public static ObservableList<Person> personObservableList = null;
    public static List<Person> personList = new ArrayList<Person>();

    public static ObservableList<Person> getPersonData(){
/*        Person p1 = new Person("Jacob", "Smith", "jacob.smith@example.com");
        Person p2 = new Person("Isabella", "Johnson", "isabella.johnson@example.com");
        Person p3 = new Person("Ethan", "Williams", "ethan.williams@example.com");
        Person p4 = new Person("Emma", "Jones", "emma.jones@example.com");
        Person p5 = new Person("Michael", "Brown", "michael.brown@example.com");
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);*/
        personObservableList = FXCollections.observableArrayList(personList);
        return personObservableList;
    }
}
