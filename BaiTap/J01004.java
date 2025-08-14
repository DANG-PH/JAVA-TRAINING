import java.util.*;

/*
Bài: J01004 - Số Nguyên Tố
Input:
- Số bộ test (int)
- Mỗi test: 1 số nguyên
Output:
- "YES" nếu số nguyên tố, "NO" nếu không

Luồng xử lý (OOP):
1. Main -> Gọi XuLyBaiToanJ01004
2. XuLyBaiToan -> Đọc inputf
3. XetSoNguyenTo -> Kiểm tra số nguyên tố
4. XuLyBaiToan -> In kết quả
*/

class XetSoNguyenTo {
    private int soCanTest;

    public XetSoNguyenTo(int soCanTest) {
        this.soCanTest = soCanTest;
    }

    public boolean isSoNguyenTo() {
        if (soCanTest <= 1) return false;
        int sqrt = (int) Math.sqrt(soCanTest);
        for (int i = 2; i <= sqrt; i++) {
            if (soCanTest % i == 0) return false;
        }
        return true;
    }

    public void inKetQua() {
        System.out.println(isSoNguyenTo() ? "YES" : "NO");
    }
}

class XuLyBaiToanJ01004 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int i = 0; i < boTest; i++) {
            int soCanTest = sc.nextInt();
            XetSoNguyenTo xsnt = new XetSoNguyenTo(soCanTest);
            xsnt.inKetQua();
        }
    }
}

public class J01004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01004().thucThi(sc);
        sc.close();
    }
}
