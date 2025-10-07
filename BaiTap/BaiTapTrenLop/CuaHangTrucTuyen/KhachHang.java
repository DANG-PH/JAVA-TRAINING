package BaiTapTrenLop.CuaHangTrucTuyen;

public class KhachHang {
    private String ten;
    private double soTien;
    public KhachHang(String ten, double soTien) {
        this.ten = ten;
        this.soTien = soTien;
    }

    public String getTen() {
        return ten;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
}
