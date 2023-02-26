import java.util.*;

public class PhoneBook {

    Map<String, String> mapName = new TreeMap<>();
    Map<String, String> mapNumber = new HashMap<>();

    int add(String name, String number) {
        if(!mapName.containsKey(name) && !mapNumber.containsKey(number)) {
            mapName.put(name, number);
            mapNumber.put(number, name);
        }
        return mapName.size();
    }

    String findByNumber(String number) {
        return mapNumber.get(number);
    }

    String findByName(String name) {
        return mapName.get(name);
    }

    void printAllNames() {
    }
}
