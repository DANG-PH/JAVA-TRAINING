package BaiTapTrenLop.ShopTea;

import java.util.*;

public class QuanLyCustomer {
    private static List<Customer> listCustomer = new ArrayList<>();

    public static void themKhachHang(Customer customer) {
        listCustomer.add(customer);
    }

    // Đăng ký
    public static Customer dangKy(String name, String email, String password) {
        // Kiểm tra email đã tồn tại chưa
        if (timKhachHangTheoEmail(email) != null) {
            System.out.println("Email đã được sử dụng!");
            return null;
        }
        Customer newCus = new Customer(name, email, password, 0);
        listCustomer.add(newCus);
        System.out.println("Đăng ký thành công cho " + name);
        return newCus;
    }

    // Đăng nhập
    public static Customer dangNhap(String email, String password) {
        Customer c = timKhachHangTheoEmail(email);
        if (c != null && c.checkPassword(password)) {
            System.out.println("Đăng nhập thành công! Xin chào " + c.getName());
            return c;
        }
        System.out.println("Sai email hoặc mật khẩu!");
        return null;
    }

    public static void hienThiKhachHang() {
        for (Customer c : listCustomer) {
            System.out.println("- " + c.getName() + " | " + c.getEmail() + " | Số dư: " + c.getBalance());
        }
    }

    public static Customer timKhachHangTheoEmail(String email) {
        for (Customer c : listCustomer) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public static void xoaKhachHang(String email) {
        for (Customer c : listCustomer) {
            if (c.getEmail().equals(email)) {
                listCustomer.remove(c);
            }
        }
    }

    public static void capNhatKhachHang(String email, String newName, String newEmail) {
        Customer c = timKhachHangTheoEmail(email);
        if (c != null) {
            c.capNhatThongTin(newName, newEmail);
        }
    }

    public static List<Customer> getAllCustomers() {
        return listCustomer;
    }
}