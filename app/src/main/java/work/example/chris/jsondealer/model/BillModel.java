package work.example.chris.jsondealer.model;

import java.io.Serializable;

public class BillModel implements Serializable {

    private String cdate;

    private String name;

    private int price;

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
