public class Calcul {

    public static void main(String[] args) {

        double len = 6;
        double a = 5;
        double b = 9;



        Square s1 = new Square(4);
        System.out.println("Площадь квадрата со стороной " + s1.getL() + " равна " + s1.area());

        Rectangle r1 = new Rectangle(4, 6);
        System.out.println("Площадь пряямоугольника со сторонами " + r1.getA() + " и " + r1.getB() + " равен " + r1.area());
    }
}
