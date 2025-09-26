package BaiTapTrenLop.QuanLyNhanVien_1;
import java.util.*;

// Bài 1 - kế thừa + đa hình + trừu tượng + đóng gói
/*
📌 Diagram (Class Diagram UML):
            +----------------+
            |   NhanVien     |  <<abstract>>
            +----------------+
            | - ten: String  |
            | - tuoi: int    |
            +----------------+
            | + tinhLuong()  | (abstract)
            | + hienThiThongTin() |
            +----------------+
               /\
              /  \
             /    \
+-----------------------+      +-----------------------+
| NhanVienVanPhong      |      | NhanVienKyThuat       |
+-----------------------+      +-----------------------+
| - soNgayLamViec: int  |      | - soGioLamViec: int   |
|                       |      | - tienCongMoiGio:double|
+-----------------------+      +-----------------------+
| + tinhLuong()         |      | + tinhLuong()         |
+-----------------------+      +-----------------------+
*/

abstract class NhanVien {
    private String ten;
    private int tuoi;

    public NhanVien(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public abstract double tinhLuong();

    public void hienThiThongTin() {
        System.out.println("Tên: " + ten + ", Tuổi: " + tuoi + ", Lương: " + tinhLuong());
    }

    // Getter & Setter cho ten, tuoi
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}

class NhanVienVanPhong extends NhanVien {
    private int soNgayLamViec;
    private static final double LUONG_MOI_NGAY = 100;

    public NhanVienVanPhong(String ten, int tuoi, int soNgayLamViec) {
        super(ten, tuoi);
        this.soNgayLamViec = soNgayLamViec;
    }

    @Override
    public double tinhLuong() {
        return soNgayLamViec * LUONG_MOI_NGAY;
    }

    // Getter & Setter cho soNgayLamViec
    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }
}

class NhanVienKyThuat extends NhanVien {
    private int soGioLamViec;
    private double tienCongMoiGio;

    public NhanVienKyThuat(String ten, int tuoi, int soGioLamViec, double tienCongMoiGio) {
        super(ten, tuoi);
        this.soGioLamViec = soGioLamViec;
        this.tienCongMoiGio = tienCongMoiGio;
    }

    @Override
    public double tinhLuong() {
        return soGioLamViec * tienCongMoiGio;
    }

    // Getter & Setter cho soGioLamViec, tienCongMoiGio
    public int getSoGioLamViec() {
        return soGioLamViec;
    }

    public void setSoGioLamViec(int soGioLamViec) {
        this.soGioLamViec = soGioLamViec;
    }

    public double getTienCongMoiGio() {
        return tienCongMoiGio;
    }

    public void setTienCongMoiGio(double tienCongMoiGio) {
        this.tienCongMoiGio = tienCongMoiGio;
    }
}

public class QuanLyNhanVien {
    public static void main(String[] args) {
        Map<String, NhanVien> nhanVienMap = new HashMap<>();
        nhanVienMap.put("nv_a", new NhanVienVanPhong("Nguyễn Văn A", 30, 22));
        nhanVienMap.put("nv_b", new NhanVienKyThuat("Trần Văn B", 28, 160, 15));

        // Người dùng chỉ nhập username
        String username = "nv_b";
        NhanVien nv = nhanVienMap.get(username);
        if (nv != null) {
            nv.hienThiThongTin();
        } else {
            System.out.println("Không tìm thấy nhân viên!");
        }
    }
}