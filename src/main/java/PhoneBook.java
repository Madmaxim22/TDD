import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    Map<String, String> mapPhone = new HashMap<>();

    public Map<String, String> getPhoneBook() {
        return mapPhone;
    }

    int add(String name, String number) {
        if(!mapPhone.containsKey(name)) {
            mapPhone.put(name, number);
        }
        return mapPhone.size();
    }

    String findByNumber(String number) {
        for (Map.Entry entry : mapPhone.entrySet()) {
            if (number.equalsIgnoreCase((String)entry.getValue())){
                return (String) entry.getKey();
            }
        }
        return null;
    }

    String findByName(String name) {
        return mapPhone.get(name);
    }
}
