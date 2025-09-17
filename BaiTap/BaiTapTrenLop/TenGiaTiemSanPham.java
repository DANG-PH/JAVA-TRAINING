package BaiTapTrenLop;
import java.util.HashMap;
import java.util.Map;

public class TenGiaTiemSanPham {
    public static final Map<String, Double> mapTenGiaSp = new HashMap<>();

    static {
        mapTenGiaSp.put("Trà sữa", 30000.0);
        mapTenGiaSp.put("Hồng trà", 25000.0);
        mapTenGiaSp.put("Trà đào", 28000.0);
        mapTenGiaSp.put("Bánh mì", 15000.0);
        mapTenGiaSp.put("Cà phê sữa", 35000.0);
    }

    // Hàm get giá theo tên sp
    public static Double getGia(String tenSp) {
        return mapTenGiaSp.getOrDefault(tenSp, -1.0);
    }

    public static boolean isTonTai(String tenSp) {
        return mapTenGiaSp.containsKey(tenSp);
    }
}