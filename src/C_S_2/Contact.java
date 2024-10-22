package C_S_2;

import java.io.Serializable;

public class Contact implements Serializable {
    String name;
    String address;
    String phone;

    Contact(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
