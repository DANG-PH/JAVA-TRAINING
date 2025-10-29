package BaiTapOOP;

import java.util.*;

abstract class NhanVien {
    protected String maNV;
    protected String hoTen;
    protected double luongCoBan;

    public NhanVien(String maNV, String hoTen, double luongCoBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }

    public abstract double tinhLuong();

    public String getHoTen() {
        return hoTen;
    }

    public String getLoaiNV() {
        return this.getClass().getName();
    }
}


class NhanVienVanPhong extends NhanVien {
    private static final double PHU_CAP = 1_000_000;

    public NhanVienVanPhong(String maNV, String hoTen, double luongCoBan) {
        super(maNV, hoTen, luongCoBan);
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + PHU_CAP;
    }
}

class NhanVienSanXuat extends NhanVien {
    private int soSanPhamVuotDinhMuc;
    private static final double THUONG_MOI_SP = 200_000;

    public NhanVienSanXuat(String maNV, String hoTen, double luongCoBan, int soSanPhamVuotDinhMuc) {
        super(maNV, hoTen, luongCoBan);
        this.soSanPhamVuotDinhMuc = soSanPhamVuotDinhMuc;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + soSanPhamVuotDinhMuc * THUONG_MOI_SP;
    }
}

interface ThuongThem {
    double apDungThuong(double luongGoc);
}

class KhongThuong implements ThuongThem {
    @Override
    public double apDungThuong(double luongGoc) {
        return luongGoc;
    }
}

class Thuong5PhanTram implements ThuongThem {
    @Override
    public double apDungThuong(double luongGoc) {
        return luongGoc * 1.05;
    }
}

class BangLuong {
    private NhanVien nhanVien;
    private ThuongThem thuong;

    public BangLuong(NhanVien nv, ThuongThem thuong) {
        this.nhanVien = nv;
        this.thuong = thuong;
    }

    public double luongGoc() {
        return nhanVien.tinhLuong();
    }

    public double luongSauThuong() {
        return thuong.apDungThuong(luongGoc());
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public ThuongThem getThuong() {
        return thuong;
    }
}

public class Bai2 {
    public static void main(String[] args) {
        List<BangLuong> ds = new ArrayList<>();

        ds.add(new BangLuong(new NhanVienVanPhong("NV01", "Nguyễn Văn A", 5_000_000), new KhongThuong()));
        ds.add(new BangLuong(new NhanVienVanPhong("NV02", "Lê Thị B", 6_000_000), new Thuong5PhanTram()));
        ds.add(new BangLuong(new NhanVienSanXuat("NV03", "Trần Văn C", 4_000_000, 3), new KhongThuong()));
        ds.add(new BangLuong(new NhanVienSanXuat("NV04", "Phạm Thị D", 5_000_000, 5), new Thuong5PhanTram()));

        double tongLuong = 0;
        for (BangLuong bl : ds) {
            double luongGoc = bl.luongGoc();
            double luongSau = bl.luongSauThuong();
            tongLuong += luongSau;

            System.out.println(
                    "Tên: " + bl.getNhanVien().getHoTen()
                            + " | Loại: " + bl.getNhanVien().getLoaiNV()
                            + " | Lương gốc: " + luongGoc
                            + " | Lương sau thưởng: " + luongSau
                            + " | Thưởng: " + bl.getThuong().getClass().getName()
            );
        }

        System.out.print("TỔNG QUỸ LƯƠNG: " + tongLuong);
    }
}
