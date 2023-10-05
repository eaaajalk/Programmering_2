package SAS;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter = 0;
    private int orderNr;
    private List<Product> productList = new ArrayList<>();
    private int tableNr;

    public Order(List<Product> productList, int tableNr) {
        orderCounter++;
        this.orderNr = orderCounter;
        this.productList = productList;
        this.tableNr = tableNr;
    }
}
