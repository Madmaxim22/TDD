import java.util.HashMap;
import java.util.Map;

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

        return null;
    }
}
