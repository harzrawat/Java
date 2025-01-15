package com.AdvanceJava.Serialization;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        Employee emp = new Employee(1,"Sandy");

        try {
            FileOutputStream fileout = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            try {
                out.writeObject(emp);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                out.close();
                fileout.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            FileInputStream filein = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(filein);
            try {
                Employee empz = (Employee) in.readObject();
                System.out.println(empz.name);
            }catch (IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                filein.close();
                in.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

class Employee implements Serializable{
    private static final long serialversionUID = 1L;
    int id;
    String name;
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
}

class Employee1 implements Serializable{
    private static final long serialversionUID = 1L;
    int id;
    String name;
    public Employee1(int id, String name){
        this.id = id;
        this.name = name;
    }
}
