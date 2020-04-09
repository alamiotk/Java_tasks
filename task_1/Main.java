import com.sun.jdi.connect.Connector;

import java.util.Scanner; //zaimportowanie

public class Main {
    static Scanner scanner = new Scanner(System.in); //pobieranie danych z klawiatury

    public static void main(String[] args) {
        double a, b, c, h;
        int choice;

        do {
            System.out.println("Prosty kalkulator \nCo policzyć?\n");
            System.out.println("1.Trojkat");
            System.out.println("2.Kwadrat");
            System.out.println("3.Kolo");
            System.out.println("\nPodaj inną dowolną liczbę, żeby wyjść");

            System.out.println("\nPodaj numer operacji:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("Podaj podstawe trojkata:");
                    a = scanner.nextDouble();
                    if(a<=0)
                        throw new IllegalArgumentException("Dane nie moga być mniejsze od zera!");


                    System.out.print("Podaj bok1 trojkata:");
                    b = scanner.nextDouble();
                    if(b<=0)
                        throw new IllegalArgumentException("Dane nie moga być mniejsze od zera!");


                    System.out.print("Podaj bok2 trojkata:");
                    c = scanner.nextDouble();
                    if(c<=0)
                        throw new IllegalArgumentException("Dane nie moga być mniejsze od zera!");


                    System.out.print("Podaj wysokosc:");
                    h = scanner.nextDouble();
                    if(h<=0)
                        throw new IllegalArgumentException("Dane nie moga być mniejsze od zera!");

                    Triangle Tr = new Triangle(a, b, c, h);
                    Tr.print();
                    System.out.println();

                    break;

                case 2:
                    System.out.println("Podaj bok kwadratu:");
                    a = scanner.nextDouble();

                    if(a<=0)
                        throw new IllegalArgumentException("Dane nie moga być mniejsze od zera!");


                    Square Sq = new Square(a);
                    Sq.print();
                    System.out.println();

                    break;

                case 3:
                    System.out.println("Podaj promien:");
                    a = scanner.nextDouble();

                    if(a<=0)
                        throw new IllegalArgumentException("Dane nie moga być mniejsze od zera!");

                    Circle Ci = new Circle(a);
                    Ci.print();
                    System.out.println();

                    break;

                default:
                    break;
            }

        } while (choice==1 || choice==2 || choice==3);

    }
}