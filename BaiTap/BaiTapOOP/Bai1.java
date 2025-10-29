package BaiTapOOP;
import java.util.*;

abstract class PhuongTien {
    protected String ma;
    protected String ten;
    protected double donGiaTheoGio;

    public PhuongTien(String ma, String ten, double donGiaTheoGio) {
        this.ma = ma;
        this.ten = ten;
        this.donGiaTheoGio = donGiaTheoGio;
    }

    abstract public double tinhTien(int soGio);

    public String getTen() {
        return ten;
    }
}

class XeMay extends PhuongTien {
    private static final int PHU_THU = 5000;
    public XeMay(String ma, String ten, double donGiaTheoGio) {
        super(ma, ten, donGiaTheoGio);
    }

    @Override
    public double tinhTien(int soGio) {
        return soGio * donGiaTheoGio + PHU_THU;
    }
}

class OTo extends PhuongTien {
    private static final int PHU_THU = 20000;
    public OTo(String ma, String ten, double donGiaTheoGio) {
        super(ma, ten, donGiaTheoGio);
    }

    @Override
    public double tinhTien(int soGio) {
        double tien = soGio * donGiaTheoGio;
        if (soGio > 3)
            tien += PHU_THU;
        return tien;
    }
}

interface KhuyenMai {
    double apDung(double tienGoc);
}

class KhuyenMaiDefault implements KhuyenMai {
    @Override
    public double apDung(double tienGoc) {
        return tienGoc;
    }
}

class KhuyenMai10 implements KhuyenMai {
    @Override
    public double apDung(double tienGoc) {
        return tienGoc * 0.9;
    }
}

class ThuePhuongTien {
    PhuongTien phuongTien;
    int soGio;
    KhuyenMai khuyenMai;

    public ThuePhuongTien(PhuongTien phuongTien, int soGio, KhuyenMai khuyenMai) {
        this.phuongTien = phuongTien;
        this.soGio = soGio;
        this.khuyenMai = khuyenMai;
    }

    public double tienGoc() {
        return phuongTien.tinhTien(soGio);
    }

    public double tienSauKM() {
        return khuyenMai.apDung(tienGoc());
    }
}

public class Bai1 {
    public static void main(String[] args) {
        List<ThuePhuongTien> ds = new ArrayList<>();
        ds.add(new ThuePhuongTien(new XeMay("XM01", "Xe máy Sirius", 10000), 4, new KhuyenMaiDefault()));
        ds.add(new ThuePhuongTien(new OTo("OT02", "Ô tô Vios", 50000), 5, new KhuyenMai10()));
        ds.add(new ThuePhuongTien(new XeMay("XM03", "Xe máy Vision", 12000), 2, new KhuyenMai10()));

        for (ThuePhuongTien tp : ds) {
            double tienGoc = tp.tienGoc();
            double tienSauKM = tp.tienSauKM();

            System.out.println(
                    "Tên: " + tp.phuongTien.getTen()
                            + " | Số giờ: " + tp.soGio
                            + " | Tiền gốc: " + tienGoc
                            + " | Tiền sau KM: " + tienSauKM
                            + " | Khuyến mãi: " + tp.khuyenMai.getClass().getSimpleName()
            );
        }
    }
}
