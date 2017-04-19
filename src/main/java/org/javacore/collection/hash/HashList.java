package org.javacore.collection.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guosi Chen on 2017/4/19.
 */
public class HashList {
    public static void main(String[] args) {
        List<Person> reqPersonList = new ArrayList<>();
        List<Person> existPersonList = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            Person person = new Person();
            person.setId(i);
            person.setName("name" + i);
            person.setAge(666 + i);
            person.setDesc("desc" + i);
            reqPersonList.add(person);
        }

        for (int i = 0; i < 5000; i++) {
            Person person = new Person();
            person.setId(i);
            person.setName("nameExist" + i);
            person.setAge(888 + i);
            person.setDesc("descExist" + i);
            existPersonList.add(person);
        }

    }

}
