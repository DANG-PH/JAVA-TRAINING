package BaiTapTrenLop;
import java.util.*;

public class QuanLyProduct {
    private static List<Product> listProduct = new ArrayList<>();

    public static void themSanPham(Product sanPham) {
        listProduct.add(sanPham);
    }

    public static void hienThiSanPham() {
        for (Product p : listProduct) {
            System.out.println("- " + p.getName() + " : " + p.getPrice());
        }
    }

    public static List<Product> getAllProducts() {
        return listProduct;
    }

    public static Product timSanPhamTheoTen(String name) {
        for (Product p : listProduct) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public static void xoaSanPham(String name) {
        for (Product p : listProduct) {
            if (p.getName().equals(name)) {
                listProduct.remove(p);
            }
        }
    }

}