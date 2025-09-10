class SinhVien {
    private String masv;
    private String hoTen;
    private int tuoi;
    private static int soLuongSinhVien = 0;

    public SinhVien() {
        soLuongSinhVien+=1;
    }

    public void setThongTin(String masv, String hoTen, int tuoi){
        this.masv = masv;
        this.tuoi = tuoi;
        this.hoTen = hoTen;
    }

    public void hienThiThongTin() {
        System.out.println(masv+", "+hoTen+", "+tuoi);
    }

    public static void hienThiSoLuong() {
        System.out.println(soLuongSinhVien);
    }
}

public class QuanLySinhVien {
    public static void main(String[] args) {
        SinhVien a = new SinhVien();
        a.setThongTin("01","a",18);
        SinhVien b = new SinhVien();
        b.setThongTin("02","b",19);
        a.hienThiThongTin();
        b.hienThiThongTin();
        SinhVien.hienThiSoLuong();
    }
}
