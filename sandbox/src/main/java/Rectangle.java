public class Rectangle {

    public double a;
    public double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double area(){
        return this.a * this.b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getB() {
        return b;
    }
}
