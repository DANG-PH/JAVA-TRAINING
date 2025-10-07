package BaiTapTrenLop.CuaHangTrucTuyen;

import java.util.*;

public class DanhSachSanPham {
    public static final List<SanPham> danhSachSanPham = new ArrayList<>();

    static {
        danhSachSanPham.add(new SanPhamDienTu("001","a",1000,LoaiSanPham.DIENTU,"001",1.5f));
    }

    public static void themSanPham(SanPham sanPham) {
        danhSachSanPham.add(sanPham);
    }
}