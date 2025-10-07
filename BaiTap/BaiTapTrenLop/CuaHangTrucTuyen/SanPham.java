package BaiTapTrenLop.CuaHangTrucTuyen;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private long gia;
    private LoaiSanPham loaiSanPham;
    public SanPham(String maSanPham, String tenSanPham, long gia, LoaiSanPham loaiSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.loaiSanPham = loaiSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public long getGia() {
        return gia;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }
}

class SanPhamDienTu extends SanPham {
    private String IMEI;
    private float thoiGianBaoHanh;
    public SanPhamDienTu(String maSanPham, String tenSanPham, long gia, LoaiSanPham loaiSanPham, String IMEI, float thoiGianBaoHanh) {
        super(maSanPham,tenSanPham,gia,loaiSanPham);
        this.IMEI = IMEI;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    public String getIMEI() {
        return IMEI;
    }
    public float getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }
}

class SanPhamThucPham extends SanPham {
    private float hanSuDung;
    public SanPhamThucPham(String maSanPham, String tenSanPham, long gia, LoaiSanPham loaiSanPham, float hanSuDung) {
        super(maSanPham,tenSanPham,gia,loaiSanPham);
        this.hanSuDung = hanSuDung;
    }
    public float getHanSuDung() {
        return hanSuDung;
    }
}
