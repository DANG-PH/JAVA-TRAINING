import java.util.*;

/*
Bài: J01003 - Giải phương trình bậc nhất
Input:
- Hai số thực a, b (phương trình dạng ax + b = 0)

Output:
- "VSN" nếu phương trình có vô số nghiệm
- "VN" nếu phương trình vô nghiệm
- Nghiệm x (2 chữ số thập phân) nếu có nghiệm duy nhất

Luồng xử lý:
1. Main -> Gọi XuLyBaiToanJ01003
2. XuLyBaiToan -> Đọc input
3. PhuongTrinhBacNhat -> Giải phương trình
4. XuLyBaiToan -> In kết quả
*/

class PhuongTrinhBacNhat {
    private float a, b;

    public PhuongTrinhBacNhat(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public String giai() {
        if (a == 0 && b == 0) return "VSN";
        if (a == 0) return "VN";
        return String.format("%.2f", -b / a);
    }
}

class XuLyBaiToanJ01003 {
    public void thucThi() {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();

        PhuongTrinhBacNhat pt = new PhuongTrinhBacNhat(a, b);
        System.out.println(pt.giai());

        sc.close();
    }
}

public class J01003 {
    public static void main(String[] args) {
        new XuLyBaiToanJ01003().thucThi();
    }
}