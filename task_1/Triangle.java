public class Triangle extends Figure implements Print{
    private double a;
    private double b;
    private double c;
    private double h;

    public Triangle(double a, double b, double c, double h){
        this.a=a;
        this.b=b;
        this.c=c;
        this.h=h;
    }

    public double calculateArea() {
        return (a*h)/2;
    }

    public double calculatePerimeter(){
        return a+b+c;
    }

    public void print(){
        System.out.println();
        System.out.println("Wyniki dla trojkata:");
        System.out.println("Podstawa="+a);
        System.out.println("Boki:");
        System.out.println("bok 1="+b);
        System.out.println("bok 2="+c);
        System.out.println("Wysokosc="+h);
        System.out.println("Pole wynosi="+calculateArea());
        System.out.println("Obwod wynosi="+calculatePerimeter());
    }
}
