import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Person {
private String name;
private int age;
    private static ArrayList<Person> information=new ArrayList<>();
public Person(String name, int age){
    this.name=name;
    this.age=age;
    information.add(this);

}


public String info(){
    return "Person's name: "+name+"\nPerson's age: "+age;
}
public static void writeFile(){
    try {
        try (FileWriter fw = new FileWriter("plane_info.txt")) {
            for (Person person : information) {
                fw.write(person.info() + "\n\n");
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


    public static ArrayList<Person> getInformation() {
        return information;
    }

    public static void setInformation(ArrayList<Person> information) {
        Person.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
