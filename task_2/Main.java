import java.util.Scanner;
import java.util.ArrayList;



public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Adding products to list of objects FulfillmentCenter");
        FulfillmentCenter fc = new FulfillmentCenter("magazyn1", new ArrayList<Item>(), 300);

        fc.printed();

        fc.addProduct(new Item("p1", ItemCondition.NEW, 3, 3));
        fc.addProduct(new Item("p3",ItemCondition.USED,10,2));
        fc.addProduct(new Item("p2", ItemCondition.REFURBISHED, 8, 4));
        fc.addProduct(new Item("p5",ItemCondition.USED,5,4));
        fc.addProduct(new Item("p3",ItemCondition.USED,10,5));
        fc.addProduct(new Item("p4",ItemCondition.NEW,8,3));


        fc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking warehouse overflow.\n");
        fc.addProduct(new Item("p6",ItemCondition.NEW,100,2));
        fc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking 'getProduct' function.\n");
        fc.getProduct(new Item("p1",ItemCondition.NEW,3,3));
        fc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking 'removeProduct' function.\n");
        fc.removeProduct(new Item("p1",ItemCondition.NEW,1,3));
        fc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking 'search' function.\n");
        fc.search("p5").print();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking 'countByCondition' function.\n");
        fc.countByCondition(ItemCondition.USED);

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking 'sortByName' function.\n");
        fc.sortByName();
        fc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking 'sortByAmount' function.\n");
        fc.sortByAmount();
        fc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking 'max' function.\n");
        fc.max().print();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        FulfillmentCenterContainer fcc=new FulfillmentCenterContainer();
        fcc.addCenter("k1",5);
        fcc.addCenter("k2",10);
        fcc.addCenter("k3",20);
        fcc.addCenter("k4",100);
        fcc.addCenter("k5",150);
        fcc.addCenter("k6",10);
        fcc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        fcc.removeCenter("k1");
        fcc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        fcc.map.get("k3").addProduct(new Item("p1",ItemCondition.NEW,1,2));
        fcc.map.get("k4").addProduct(new Item("p2",ItemCondition.NEW,10,3));
        fcc.map.get("k4").addProduct(new Item("p2",ItemCondition.NEW,10,3));
        fcc.map.get("k2").addProduct(new Item("p3",ItemCondition.NEW,5,2));
        fcc.map.get("k3").addProduct(new Item("p2",ItemCondition.NEW,10,1));
        fcc.summary();

        System.out.println("Enter some number to go: ");
        scanner.nextLine();
        System.out.println("Checking 'findEmpty' function.\n");
        System.out.println(fcc.findEmpty());

    }
}
