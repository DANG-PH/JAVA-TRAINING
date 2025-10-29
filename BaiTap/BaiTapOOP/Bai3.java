package BaiTapOOP;

import java.util.*;

abstract class MonAn {
    protected String maMon;
    protected String tenMon;
    protected double donGia;

    public MonAn(String maMon, String tenMon, double donGia) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.donGia = donGia;
    }

    public String getTenMon() {
        return tenMon;
    }

    public abstract double tinhTien(int soLuong);
}

class MonChinh extends MonAn {
    public MonChinh(String maMon, String tenMon, double donGia) {
        super(maMon, tenMon, donGia);
    }

    @Override
    public double tinhTien(int soLuong) {
        double tong = donGia * soLuong;
        if (soLuong > 3) {
            tong *= 0.95;
        }
        return tong;
    }
}

class MonTrangMieng extends MonAn {
    public MonTrangMieng(String maMon, String tenMon, double donGia) {
        super(maMon, tenMon, donGia);
    }

    @Override
    public double tinhTien(int soLuong) {
        double tong = donGia * soLuong;
        if (tong > 100_000) {
            tong -= donGia;
        }
        return tong;
    }
}

interface UuDai {
    double apDung(double tienGoc);
}

class KhongGiam implements UuDai {
    @Override
    public double apDung(double tienGoc) {
        return tienGoc;
    }
}

class Giam10PhanTram implements UuDai {
    @Override
    public double apDung(double tienGoc) {
        return tienGoc * 0.9;
    }
}

class DonHang {
    private MonAn mon;
    private int soLuong;
    private UuDai uuDai;

    public DonHang(MonAn mon, int soLuong, UuDai uuDai) {
        this.mon = mon;
        this.soLuong = soLuong;
        this.uuDai = uuDai;
    }

    public double tienGoc() {
        return mon.tinhTien(soLuong);
    }

    public double tienSauUuDai() {
        return uuDai.apDung(tienGoc());
    }

    public MonAn getMon() {
        return mon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public UuDai getUuDai() {
        return uuDai;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        List<DonHang> ds = new ArrayList<>();

        ds.add(new DonHang(new MonChinh("MC01", "Cơm gà", 35_000), 4, new KhongGiam()));
        ds.add(new DonHang(new MonChinh("MC02", "Bún bò", 40_000), 2, new Giam10PhanTram()));
        ds.add(new DonHang(new MonTrangMieng("TM01", "Chè khúc bạch", 25_000), 5, new KhongGiam()));
        ds.add(new DonHang(new MonTrangMieng("TM02", "Kem dừa", 30_000), 4, new Giam10PhanTram()));

        double tongTien = 0;
        System.out.printf("%-20s | %-10s | %-12s | %-12s | %-15s%n",
                "Tên món", "Số lượng", "Tiền gốc", "Tiền sau ưu đãi", "Loại ưu đãi");
        System.out.println("--------------------------------------------------------------------------");

        for (DonHang dh : ds) {
            double tienGoc = dh.tienGoc();
            double tienSau = dh.tienSauUuDai();
            tongTien += tienSau;

            System.out.printf("%-20s | %-10d | %-12.0f | %-12.0f | %-15s%n",
                    dh.getMon().getTenMon(),
                    dh.getSoLuong(),
                    tienGoc,
                    tienSau,
                    dh.getUuDai().getClass().getSimpleName());
        }

        System.out.printf("TỔNG TIỀN PHẢI TRẢ: %.0fđ%n", tongTien);
    }
}
