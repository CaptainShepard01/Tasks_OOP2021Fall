package Task10.classes;

import java.time.Year;

public class Bird implements Animal {
    private int age;
    private String name;

    public void eat() {
        System.out.println("What a tasty worm!");
    }

    public void breeze() {
        System.out.println("Sweat air!");
    }

    public int countAge(){
        return Year.now().getValue() - age;
    }
}
