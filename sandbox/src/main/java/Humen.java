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
        h1.setName("Dmitriy");
        System.out.println(h1.getName());
    }

}
