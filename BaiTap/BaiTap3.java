import java.util.*;
class TaiKhoan {
    private String tenTaiKhoan;
    private String soTaiKhoan;
    private long soDuTaiKhoan;
    private static float laiSuat = 1f;
    public TaiKhoan(String tenTaiKhoan,String soTaiKhoan,long soDuTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.soDuTaiKhoan = soDuTaiKhoan;
        this.soTaiKhoan = soTaiKhoan;
    }
    public boolean napTien(long soLuongTien) {
        long soTienTruoc = soDuTaiKhoan;
        this.soDuTaiKhoan += soLuongTien;
        if (soDuTaiKhoan > soTienTruoc) return true;
        return false;
    }
    public boolean rutTien(long soLuongTien) {
        long soTienTruoc = soDuTaiKhoan;
        this.soDuTaiKhoan -= soLuongTien;
        if (soDuTaiKhoan > soTienTruoc) return true;
        return false;
    }
    public void tinhLai1Thang() {
        float tienLai = soDuTaiKhoan * (laiSuat / 100) / 12;
        soDuTaiKhoan += tienLai;
    }
    public void hienThiThongTin() {
        System.out.println(soDuTaiKhoan);
    }
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }
    public static void thayDoiLaiSuat(float laiSuatMoi) {
        laiSuat = laiSuatMoi;
    }
    public static void hienThiLaiSuat() {
        System.out.println(laiSuat);
    }
}

public class BaiTap3 {
    public static boolean timKiemTK(String id,List<TaiKhoan> listTaiKhoan) {
        for (TaiKhoan tk : listTaiKhoan) {
            if (tk.getSoTaiKhoan().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
        listTaiKhoan.add(new TaiKhoan("1","001",1000));
        listTaiKhoan.add(new TaiKhoan("2","002",2000));
        listTaiKhoan.add(new TaiKhoan("3","003",3000));
        listTaiKhoan.get(0).napTien(3000);
        for (TaiKhoan tk : listTaiKhoan) {
            tk.hienThiThongTin();
        }
        String soTKcanTim = "001";
        BaiTap3.timKiemTK(soTKcanTim,listTaiKhoan);
    }
}
