public class Item implements Comparable<Item>{                                      // klasa implementuje interfejs Comparable
    String name;
    ItemCondition state;
    double mass;
    int quantity;


    Item(String name){                                                              // kontruktor potrzebny do utworzenia obiektu do search
        this.name = name;
        this.state = ItemCondition.NEW;
        this.mass = 1;
        this.quantity = 1;
    }

    Item(String name, ItemCondition state, double mass, int quantity){              // konstruktor wieloargumentowy
        this.name = name;
        this.state = state;
        this.mass = mass;
        this.quantity = quantity;
    }

    public void print(){
        System.out.println("Name: "+name+"\nState: "+state+"\nMass: "+mass+"\nQuantity: "+quantity);    // wypisuje pelne info o towarze Item
    }

    public int compareTo(Item object){
        return name.compareTo(object.name);                                          // metoda interfejsu Comparable - porownuje obiekty ze wzgledu na nazwe
    }
}
