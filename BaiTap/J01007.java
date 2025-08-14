import java.util.*;

/*
Bài: J01007 - Kiểm tra số Fibonacci
Input:
- Số bộ test T (int)
- Mỗi test: 1 số nguyên n (0 ≤ n ≤ 10^18)

Output:
- Với mỗi test, in ra "YES" nếu n là số Fibonacci, "NO" nếu không

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01007
2. XuLyBaiToanJ01007 -> Đọc input từ Scanner, lặp qua các test
3. Tạo object XetSoFibo(n)
4. XetSoFibo -> Kiểm tra số Fibonacci (kiemTraFibo / isSoFibo)
5. XuLyBaiToanJ01007 -> Nhận kết quả từ XetSoFibo và in ra màn hình
*/

class XetSoFibo {
    private long soCanXet;
    public XetSoFibo(long soCanXet) {
        this.soCanXet = soCanXet;
    }
    public boolean isSoFibo() {
        if (soCanXet == 0 || soCanXet == 1) return true;
        else {
            long a = 0,b = 1;
            while (b < soCanXet){
                long bienTam = b;
                b += a;
                a = bienTam;
            }
            if (b == soCanXet) return true;
            else return false;
        }
    }
}

class XuLyBaiToanJ01007 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            long n = sc.nextLong();
            XetSoFibo xuli = new XetSoFibo(n);
            inKetQua(xuli);
        }
    }

    private void inKetQua(XetSoFibo xuli) {
        System.out.println(xuli.isSoFibo() ? "YES" : "NO");
    }
}

public class J01007 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01007().thucThi(sc);
        sc.close();
    }
}
