public class Square extends Figure implements Print{
    private double a;

    Square(double a) {
        this.a = a;
    }

    public double calculateArea() {
        return a * a;
    }

    public double calculatePerimeter() {
        return 4 * a;
    }

    public void print() {
        System.out.println("Wyniki dla kwadratu");
        System.out.println("Bok="+a);
        System.out.println("Pole="+calculateArea());
        System.out.println("Obwod="+calculatePerimeter());
    }
}
