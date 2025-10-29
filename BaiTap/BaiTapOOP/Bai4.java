package BaiTapOOP;

import java.util.*;

abstract class KhoaHoc {
    protected String maKhoa;
    protected String tenKhoa;
    protected double hocPhiCoBan;

    public KhoaHoc(String maKhoa, String tenKhoa, double hocPhiCoBan) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.hocPhiCoBan = hocPhiCoBan;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public abstract double tinhHocPhi(int soGio);
}

class KhoaLyThuyet extends KhoaHoc {
    private boolean dangKySom;
    public KhoaLyThuyet(String maKhoa, String tenKhoa, double hocPhiCoBan, boolean dangKySom) {
        super(maKhoa, tenKhoa, hocPhiCoBan);
        this.dangKySom = dangKySom;
    }

    @Override
    public double tinhHocPhi(int soGio) {
        double tong = hocPhiCoBan * soGio;
        if (dangKySom) {
            tong *= 0.9;
        }
        return tong;
    }
}

class KhoaThucHanh extends KhoaHoc {
    public KhoaThucHanh(String maKhoa, String tenKhoa, double hocPhiCoBan) {
        super(maKhoa, tenKhoa, hocPhiCoBan);
    }

    @Override
    public double tinhHocPhi(int soGio) {
        double tong = hocPhiCoBan * soGio;
        tong += 200_000;
        return tong;
    }
}

interface ChinhSachGiamHocPhi {
    double apDung(double hocPhiGoc);
}

class KhongGiamm implements ChinhSachGiamHocPhi {
    @Override
    public double apDung(double hocPhiGoc) {
        return hocPhiGoc;
    }
}

class Giam15PhanTram implements ChinhSachGiamHocPhi {
    @Override
    public double apDung(double hocPhiGoc) {
        return hocPhiGoc * 0.85;
    }
}

class DangKyHoc {
    private KhoaHoc khoaHoc;
    private int soGio;
    private ChinhSachGiamHocPhi chinhSach;

    public DangKyHoc(KhoaHoc khoaHoc, int soGio, ChinhSachGiamHocPhi chinhSach) {
        this.khoaHoc = khoaHoc;
        this.soGio = soGio;
        this.chinhSach = chinhSach;
    }

    public double hocPhiGoc() {
        return khoaHoc.tinhHocPhi(soGio);
    }

    public double hocPhiSauGiam() {
        return chinhSach.apDung(hocPhiGoc());
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public int getSoGio() {
        return soGio;
    }

    public ChinhSachGiamHocPhi getChinhSach() {
        return chinhSach;
    }
}

public class Bai4 {
    public static void main(String[] args) {
        List<DangKyHoc> ds = new ArrayList<>();

        ds.add(new DangKyHoc(new KhoaLyThuyet("LT01", "Java Cơ Bản", 100_000, true), 10, new KhongGiamm()));
        ds.add(new DangKyHoc(new KhoaLyThuyet("LT02", "C++ Nâng Cao", 120_000, false), 8, new Giam15PhanTram()));
        ds.add(new DangKyHoc(new KhoaThucHanh("TH01", "Lập Trình Game", 150_000), 12, new KhongGiamm()));
        ds.add(new DangKyHoc(new KhoaThucHanh("TH02", "Thiết Kế Web", 130_000), 15, new Giam15PhanTram()));

        double tongTien = 0;
        System.out.printf("%-20s | %-8s | %-15s | %-15s | %-15s%n",
                "Tên khóa học", "Số giờ", "Học phí gốc", "Học phí sau giảm", "Chính sách");
        System.out.println("----------------------------------------------------------------------------");

        for (DangKyHoc dk : ds) {
            double hocPhiGoc = dk.hocPhiGoc();
            double hocPhiSau = dk.hocPhiSauGiam();
            tongTien += hocPhiSau;

            System.out.printf("%-20s | %-8d | %-15.0f | %-15.0f | %-15s%n",
                    dk.getKhoaHoc().getTenKhoa(),
                    dk.getSoGio(),
                    hocPhiGoc,
                    hocPhiSau,
                    dk.getChinhSach().getClass().getSimpleName());
        }

        System.out.printf("TỔNG HỌC PHÍ PHẢI TRẢ: %.0fđ%n", tongTien);
    }
}
