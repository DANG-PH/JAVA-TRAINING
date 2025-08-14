import java.util.*;

/*
Bài: J01006 - Số Fibonacci
Input:
- Số bộ test T (int)
- Mỗi test: 1 số nguyên n (1 ≤ n ≤ 92)

Output:
- Mỗi test: in ra số Fibonacci thứ n (F1=1, F2=1)

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01006
2. XuLyBaiToanJ01006 -> Đọc input từ Scanner, lặp qua các test
3. Tạo object XuLySoFibo(n)
4. XuLySoFibo -> Tính số Fibonacci thứ n (tinhSoFibo)
5. XuLyBaiToanJ01006 -> Nhận kết quả từ XuLySoFibo và in ra màn hình
*/

class XuLySoFibo {
    private int chiSo;
    public XuLySoFibo(int chiSo) {
        this.chiSo = chiSo;
    }
    public int tinhSoFibo() {
        if (chiSo == 1 || chiSo == 2) return 1;
        else {
            int a = 1,b = 1;
            for (int i = 0; i < chiSo-2; i++) {
                int bienTam = b;
                b += a;
                a = bienTam;
            }
            return b;
        }
    }
}

class XuLyBaiToanJ01006 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            int n = sc.nextInt();
            XuLySoFibo xuli = new XuLySoFibo(n);
            inKetQua(xuli);
        }
    }

    private void inKetQua(XuLySoFibo xuli) {
        System.out.println(xuli.tinhSoFibo());
    }
}

public class J01006 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01006().thucThi(sc);
        sc.close();
    }
}
