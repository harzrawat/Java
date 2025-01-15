package com.AdvanceJava.Serialization;

import java.io.*;

public class Persistence {

    public static void main(String[] args) {
        String filename = "Person.ser";
        Person person = new Person("Harsh", 9);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(person);
            System.out.println("Serialisation complete: "+ person);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            Person deserialiseperson = (Person) in.readObject();
            System.out.println(STR."Deserialised person: \{deserialiseperson}");
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return "Person{name: "+ name + "Age: " + age + "}";
    }
}
