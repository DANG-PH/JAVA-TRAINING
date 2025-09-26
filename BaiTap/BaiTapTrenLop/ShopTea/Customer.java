package BaiTapTrenLop.ShopTea;

public class Customer {
    private String name;
    private String email;
    private String password;
    private double balance;

    public Customer(String name, String email,String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    // Getter
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getBalance() { return balance; }

    // Kiểm tra mật khẩu
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Nạp tiền
    public void napTien(double soTien) {
        if (soTien > 0) {
            balance += soTien;
            System.out.println(name + " đã nạp " + soTien + " VNĐ. Số dư hiện tại: " + balance);
        }
    }

    // Trừ tiền khi thanh toán
    public boolean truTien(double soTien) {
        if (balance >= soTien) {
            balance -= soTien;
            return true;
        } else {
            System.out.println("Không đủ tiền để thanh toán!");
            return false;
        }
    }

    // Cập nhật thông tin
    public void capNhatThongTin(String newName, String newEmail) {
        if (newName != null && !newName.isEmpty()) this.name = newName;
        if (newEmail != null && !newEmail.isEmpty()) this.email = newEmail;
    }
}