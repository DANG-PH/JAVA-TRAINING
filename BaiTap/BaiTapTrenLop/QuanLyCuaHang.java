package BaiTapTrenLop;
import java.util.*;

public class QuanLyCuaHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Đăng ký tài khoản (name email password): ");
        String name = sc.nextLine();
        String email = sc.nextLine();
        String password = sc.nextLine();

        // Đăng ký khách hàng
        QuanLyCustomer.dangKy(name, email, password);

        // Đăng nhập
        System.out.print("Đăng nhập: ");
        String emailDnhap = sc.next();
        String passwordDnhap = sc.next();
        Customer c1 = QuanLyCustomer.dangNhap(emailDnhap, passwordDnhap);

        if (c1 != null) {
            // Nạp tiền
            System.out.print("Nạp tiền: ");
            double soTienNap = sc.nextDouble();
            c1.napTien(soTienNap);
            sc.nextLine();

            // Tạo sản phẩm
            System.out.print("Sản phẩm muốn mua: ");
                String nameSp = sc.nextLine();
                if (TenGiaTiemSanPham.isTonTai(nameSp)) {
                    Product p1 = new Product(nameSp, TenGiaTiemSanPham.getGia(nameSp));
                    List<Product> productList = new ArrayList<>();
                productList.add(p1);
                Order order1 = new Order(c1, productList);
            } else {
                System.out.println("Sản phẩm không tồn tại trong cửa hàng!");
            }
        }

        // Hiển thị tất cả khách hàng
        System.out.println("\nDanh sách khách hàng:");
        QuanLyCustomer.hienThiKhachHang();
    }
}