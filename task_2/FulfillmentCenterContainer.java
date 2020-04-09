import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;


public class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> map = new TreeMap<>();                                           // przechowuje magazyny, TreeMap zapewnia sortowanie na podst. naturalnego porządku klucza


    void addCenter(String name, double max_mass) {
        map.put(name, new FulfillmentCenter(name, new ArrayList<Item>(), max_mass));                // kluczem jest nazwa magazynu
    }


    void removeCenter(String name){
        map.remove(name);
    }



    List<FulfillmentCenter> findEmpty(){                                                            // zwraca liste pustych magazynow
        List<FulfillmentCenter> list = new ArrayList<FulfillmentCenter>();

        for(Map.Entry key:map.entrySet()){
            if(map.get(key.getKey()).list_p.size() == 0){
                list.add(map.get(key.getKey()));
            }
        }
        return list;
    }

    void summary(){
        System.out.println("\nNames of a warehouses and their filling: ");

        for(Map.Entry key:map.entrySet()){
            if(map.get(key.getKey()).list_p.size() == 0){
                System.out.println(key.getKey()+"- 0%");
            }
            else{
                double m_mass = 0;
                for(Item item: map.get(key.getKey()).list_p){
                    m_mass += (item.mass*item.quantity);
                }
                double percent = (m_mass/map.get(key.getKey()).max_mass)*100;
                System.out.println(key.getKey()+"-"+percent+"%");
            }
        }
    }
}
