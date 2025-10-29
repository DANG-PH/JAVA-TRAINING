package BaiTapTrenLop.CuaHangTrucTuyen;

import java.util.HashMap;
import java.util.Map;

public class QuanLyPhuongThucThanhToan {
    public static final Map<LoaiHinhThanhToan, PhuongThucThanhToan> phuongThuc = new HashMap<>();

    static {
        phuongThuc.put(LoaiHinhThanhToan.TIENMAT, new ThanhToanTienMat());
        phuongThuc.put(LoaiHinhThanhToan.VIDIENTU, new ThanhToanViDienTu());
        phuongThuc.put(LoaiHinhThanhToan.THETINDUNG, new ThanhToanTheTinDung());
    }

    public static PhuongThucThanhToan getPhuongThuc(LoaiHinhThanhToan loaiHinhThanhToan) {
        return phuongThuc.getOrDefault(loaiHinhThanhToan, null);
    }

    public static void themPhuongThuc(LoaiHinhThanhToan loaiHinhThanhToan, PhuongThucThanhToan phuongThucThanhToan) {
        phuongThuc.put(loaiHinhThanhToan,phuongThucThanhToan);
    }
}