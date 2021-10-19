package kolokwium1.gr1;

import java.io.Serializable;

public class Publisher implements Serializable {

    private String name;
    private String city;

    public Publisher(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
