package BaiTapTrenLop;
import java.util.*;

public class Order {
    private Customer customer;
    private List<Product> products;
    private static int orderCount = 0;

    public Order(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
        double tongTien = calculateTotal();
        if (customer.truTien(tongTien)) {
            orderCount++;
            System.out.println("Đơn hàng tạo thành công cho " + customer.getName() + ". Tổng: " + tongTien);
        } else {
            System.out.println("Đơn hàng thất bại vì số dư không đủ.");
            this.products.clear();
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }
}