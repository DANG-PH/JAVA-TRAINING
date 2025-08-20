import java.util.*;

abstract class phuong_tien {
    private String hang_xe;
    private String mau_xe;
    private String nam_sx;

    public phuong_tien(String hang_xe, String mau_xe, String nam_sx) {
        this.hang_xe = hang_xe;
        this.mau_xe = mau_xe;
        this.nam_sx = nam_sx;
    }

    public String getHang_xe() {
        return hang_xe;
    }

    public void setHang_xe(String hang_xe) {
        this.hang_xe = hang_xe;
    }

    public String getMau_xe() {
        return mau_xe;
    }

    public void setMau_xe(String mau_xe) {
        this.mau_xe = mau_xe;
    }

    public String getNam_sx() {
        return nam_sx;
    }

    public void setNam_sx(String nam_sx) {
        this.nam_sx = nam_sx;
    }

    public abstract void hanhDongXe();

    public void hienThiThongTin() {
        System.out.println("Hãng: " + hang_xe + ", Màu: " + mau_xe + ", Năm SX: " + nam_sx);
    }
}

class car extends phuong_tien {
    public car(String hang_xe, String mau_xe, String nam_sx) {
        super(hang_xe, mau_xe, nam_sx);
    }

    @Override
    public void hanhDongXe() {
        System.out.println("Xe hơi đang chạy bằng động cơ xăng.");
    }
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Đây là xe hơi, phù hợp gia đình.");
    }
}

class bus extends phuong_tien {
    public bus(String hang_xe, String mau_xe, String nam_sx) {
        super(hang_xe, mau_xe, nam_sx);
    }

    @Override
    public void hanhDongXe() {
        System.out.println("Xe bus đang chở nhiều hành khách.");
    }
}

public class test {
    public static void main(String[] args) {
        phuong_tien xe1 = new car("Toyota", "Đỏ", "2022");
        phuong_tien xe2 = new bus("Hyundai", "Trắng", "2020");

        xe1.hienThiThongTin();
        xe1.hanhDongXe();
        System.out.println();

        xe2.hienThiThongTin();
        xe2.hanhDongXe();
    }
}