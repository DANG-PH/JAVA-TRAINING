package BaiTapTrenLop.CuaHangTrucTuyen;
import java.util.*;
public class Order {
    private KhachHang khachHang;
    private List<SanPham> listSanPham;
    private LoaiHinhThanhToan loaiHinhThanhToan;
    public Order(KhachHang khachHang,List<SanPham> listSanPham, LoaiHinhThanhToan loaiHinhThanhToan) {
        this.listSanPham = listSanPham;
        this.loaiHinhThanhToan = loaiHinhThanhToan;
        this.khachHang = khachHang;
        this.thanhToan();
    }

    private void thanhToan() {
        XetThanhToan.PhuongThuc(khachHang,this.loaiHinhThanhToan,listSanPham);
    }
}
