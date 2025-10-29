package BaiTapTrenLop.CuaHangTrucTuyen;
import java.util.*;

public interface PhuongThucThanhToan {
    void thanhToan(double tongTien);
}

class ThanhToanTienMat implements PhuongThucThanhToan {
    public void thanhToan(double tongTien) {
        System.out.println("Thanh Toán Tiền Mặt");
    }
}

class ThanhToanTheTinDung implements PhuongThucThanhToan {
    public void thanhToan(double tongTien) {
        System.out.println("Thanh Toán Thẻ tín dụng");
    }
}

class ThanhToanViDienTu implements PhuongThucThanhToan {
    public void thanhToan(double tongTien) {
        System.out.println("Thanh Toán Ví điện tử");
    }
}

class XetThanhToan {
    public static void PhuongThuc(KhachHang khachHang,PhuongThucThanhToan phuongThucThanhToan,List<SanPham> listSanPham) {
        double tongTien = tinhTongTien(listSanPham);
        if (khachHang.getSoTien() >= tongTien) {
            phuongThucThanhToan.thanhToan(tongTien);
            khachHang.setSoTien(khachHang.getSoTien()-tongTien);
        }
    }
    private static double tinhTongTien(List<SanPham> sanPhams) {
        double kq = 0;
        for (SanPham sanPham : sanPhams) {
            kq += sanPham.getGia();
        }
        return kq;
    }
}


