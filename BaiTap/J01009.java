import java.util.*;

/*
Bài: J01009 - TỔNG GIAI THỪA
Input:
- Một số nguyên n (1 ≤ n ≤ 20)

Output:
- Tổng các giai thừa từ 1! + 2! + ... + n!

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01009
2. XuLyBaiToanJ01009 -> Đọc input n từ Scanner
3. Tạo object GiaiThua(n)
4. GiaiThua -> Tính giai thừa của từng số (tinhGiaiThua) và tính tổng (tinhTongGiaiThua)
5. XuLyBaiToanJ01009 -> Nhận kết quả từ GiaiThua và in ra màn hình
*/

class GiaiThua {
    private int soCanXet;
    public GiaiThua(int soCanXet) {
        this.soCanXet = soCanXet;
    }
    public long tinhGiaiThua(int n) {
        long soTraVe = 1;
        for (int i = 1; i <= n; i++) {
            soTraVe *= i;
        }
        return soTraVe;
    }
    public long tinhTongGiaiThua() {
        long tong = 0;
        for (int i = 1; i <= soCanXet; i++) {
            tong += tinhGiaiThua(i);
        }
        return tong;
    }
}
class XuLyBaiToanJ01009 {
    public void thucThi(Scanner sc) {
        int n = sc.nextInt();
        GiaiThua xuli = new GiaiThua(n);
        inKetQua(xuli);
    }

    private void inKetQua(GiaiThua xuli) {
        System.out.print(xuli.tinhTongGiaiThua());
    }
}

public class J01009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01009().thucThi(sc);
        sc.close();
    }
}
