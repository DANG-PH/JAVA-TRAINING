package BaiTapTrenLop.CuaHangTrucTuyen;
import java.util.*;
public class Order {
    private KhachHang khachHang;
    private List<SanPham> listSanPham;
    private PhuongThucThanhToan phuongThucThanhToan;
    public Order(KhachHang khachHang,List<SanPham> listSanPham, PhuongThucThanhToan phuongThucThanhToan) {
        this.listSanPham = listSanPham;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.khachHang = khachHang;
        this.thanhToan();
    }

    private void thanhToan() {
        XetThanhToan.PhuongThuc(khachHang,phuongThucThanhToan,listSanPham);
    }

    // sau truyền hẳn phương thức thanh toàn cụ thể ( class ) vào bằng hashmap<Loại hình thanh toán ( enum ), class thực thi>
    // chỗ gọi thì chỉ gọi interface thanh toán dựa trên cái class vừa truyền vào instace of là đc, SOLID 5/5, OOP 4/4
}
