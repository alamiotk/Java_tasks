import java.util.*;


public class FulfillmentCenter {
    public String nameWarehouse = "My warehouse";
    public List<Item> list_p = new ArrayList<>();
    public double max_mass = 1000;

    FulfillmentCenter(String nameWarehouse, List<Item> list_p, double max_mass){                    // kontruktor wieloargumentowy
        this.nameWarehouse = nameWarehouse;
        this.list_p = list_p;
        this.max_mass = max_mass;
    }
    void printed(){                                                                                 // metoda wypisujaca info o magazynie
        System.out.println("Name of the warehouse: "+ nameWarehouse+", list: "+list_p+", maximum mass: "+max_mass+"\n");
    }


    int checkID(Item product) {                                                                     // sprawdzajaca czy dany towar jest w magazynie
        System.out.println("Checking if a given product exists.");
        for (int i = 0; i < list_p.size(); i++) {
            if (list_p.get(i).name.equals(product.name)) {
                System.out.println("Exists.");
                return i;
            }
        }
        System.out.println("The product doesn't exist.");
        return -1;
    }


    double checkMass(Item product) {                                                                // sprawdza czy masa nie przekracza dozwolonej ilości
        double m_mass = 0;
        System.out.println("Checking the maximum mass.");
        for(Item product2 : list_p){
            m_mass += (product2.mass*product2.quantity);
        }
        m_mass += product.mass*product.quantity;
        System.out.println("Actual all mass: "+m_mass);
        if (max_mass < m_mass) {
            System.err.println("The warehouse is full.");
            return 0;
        }
        return 1;
    }

    int checkQuantity(Item product, int i) {                                                       // sprawdza ilosc danego towaru
        if (list_p.get(i).quantity > 1) {
            list_p.get(i).quantity -= 1;
            System.out.println("Product quantity has been reduced");
            return 1;
        } else {
            list_p.remove(i);
            System.out.println("The product has been removed");
            return 0;
        }
    }

    private class toCompare implements Comparator<Item> {
        @Override
        public int compare(Item p1, Item p2){
            return p2.quantity-p1.quantity;
        }
    };


    void addProduct(Item product){
        checkMass(product);
        int i = checkID(product);
        if(i == -1) {
            list_p.add(product);
            System.out.println("A new product has been added.\n");
        }
        else{
            list_p.get(i).quantity += product.quantity;
            System.out.println("Increase the number of product: "+product.name+"\n");
        }
    }

    int getProduct(Item product) {
        int i = checkID(product);

        if (i == -1) {
            System.out.println("There is no such a product in our Warehouse.");
            return 0;
        }
        else
            checkQuantity(product, i);
        return 1;
    }


    int removeProduct(Item product) {
        int i = checkID(product);

        if(i==-1){
            System.out.println("There is no such a product in our Warehouse.");
            return 0;
        }
        list_p.remove(i);
        System.out.println("The product has been removed");
        return 1;
    }


    Item search(String name){
        Comparator comparator = new Comparator<Item>() {                                // zastosowanie Comparatora
            @Override
            public int compare(Item i1, Item i2) {
                return i2.compareTo(i1);                                                // i metody compareTo z interfejsu Comparable
            }
        };
        int id = Collections.binarySearch(list_p, new Item(name), comparator);          // binarySearch - metoda z klasy Collections
        return list_p.get(id);
    }

    List<Item> searchPartial(String partname){
        List<Item> partList = new ArrayList<Item>();
        for(int i=0; i<list_p.size(); i++) {
            if (list_p.get(i).name.contains(partname)){                                 // contains - jeśli napis zawiera się w obiekcie, na rzecz ktorego została uruchomiona metoda
                partList.add(list_p.get(i));
            }
        }
        return partList;
    }

    int countByCondition(ItemCondition product) {
        int number = 0;
        for(int i=0; i<list_p.size(); i++){
            if(list_p.get(i).state.equals(product)){
                number += list_p.get(i).quantity;
            }
        }
        System.out.println(number);
        return number;

    }

    void summary(){
        System.out.println("Information about all products: ");
        for(int i=0; i<list_p.size(); i++){
            list_p.get(i).print();
            System.out.println("");
        }
    }


    List<Item> sortByName() {
        List<Item> list2 = new ArrayList<Item>();
        list2 = list_p;
        Collections.sort(list2);

        return list2;
    }

    List<Item> sortByAmount() {
        List<Item> list3 = new ArrayList<Item>();
        list3 = list_p;
        Collections.sort(list3, new toCompare());                       // wykorzystuje klase myComparator, która implementuje Comparator
        return list3;
    }

    Item max(){
        return Collections.max(list_p, new Comparator<Item>() {         // klasa anonimowa - może być zastąpiona wyrażeniem lambda:
            @Override                                                   // return Collections.max(list_p, (p1, p2) -> { return p1.quantity - p2.quantity });
            public int compare(Item p1, Item p2) {
                return p1.quantity-p2.quantity;
            }
        });
    }




    @Override
    public String toString() {
        return "Empty:" + "\n" +
                "name= " + nameWarehouse + "\n" +
                "productlist= " + list_p + "\n" +
                "max mass= " + max_mass +
                "\n\n";
    }


}
