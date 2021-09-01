import java.lang.invoke.StringConcatFactory;

public class Humen {
    private int id;
    private String name;

    public Humen (int id, String name){
        this.id = id;
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public static void main(String[] args) {

        Humen h1 = new Humen(1, "Alime");
        Humen h2 = new Humen(2, "Dmitriy");
        h1.setName("Dmitriy");
        h2.setName("kolya");
        System.out.println(h1.getName());
        System.out.println(h2.getName());

    }

}
