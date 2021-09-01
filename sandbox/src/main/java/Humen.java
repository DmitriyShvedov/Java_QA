import java.lang.invoke.StringConcatFactory;

public class Humen {
    private int id;
    private String name;
    private int age;

    public Humen (int id, String name){
        this.id = id;
        this.name = name;
    }

    public Humen (int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int happyBirdhday(){
          return this.age++;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }


    public static void main(String[] args) {

        Humen h1 = new Humen(1, "Alime");
        Humen h2 = new Humen(2, "Dmitriy");
        Humen h3 = new Humen(3, "Anton", 35);

        System.out.println("Возраст " + h3.getName() + " до его ДР: " + h3.getAge());
        System.out.println("Ура! ДР!");

        h1.setName("Dmitriy");
        h2.setName("kolya");
        h3.happyBirdhday();

        System.out.println(h1.getName());
        System.out.println(h2.getName());
        System.out.println("Сейчас возраст " + h3.getName() + " равен " + h3.getAge());

    }

}
