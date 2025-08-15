import java.util.*;

/*
Bài: J01011 - BỘI SỐ CHUNG - ƯỚC SỐ CHUNG
Input:
- Dòng 1: Số bộ test T (1 ≤ T ≤ 100)
- Mỗi bộ test: Hai số nguyên dương a và b (1 ≤ a, b ≤ 10^9)

Output:
- Với mỗi bộ test: In ra LCM(a, b) và GCD(a, b) cách nhau 1 dấu cách

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01011
2. XuLyBaiToanJ01011 -> Đọc số bộ test T từ Scanner
3. Với mỗi test:
    a. Đọc a và b
    b. Tạo object GCD_LCM(a, b)
4. GCD_LCM:
    - tinhGCD(): Tính ước số chung lớn nhất của a và b bằng thuật toán Euclid
    - tinhLCM(): Tính bội số chung nhỏ nhất bằng công thức LCM = (a * b) / GCD
5. XuLyBaiToanJ01011:
    - In kết quả: tinhLCM() và tinhGCD() theo yêu cầu
*/

class GCD_LCM {
    private long so1;
    private long so2;

    public GCD_LCM(long so1, long so2) {
        this.so1 = so1;
        this.so2 = so2;
    }

    public long tinhGCD() {
        long a = so1;
        long b = so2;
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public long tinhLCM() {
        long gcd = tinhGCD();
        return so1 * so2 / gcd;
    }
}

class XuLyBaiToanJ01011 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            GCD_LCM xuli = new GCD_LCM(a, b);
            inKetQua(xuli);
        }
    }

    private void inKetQua(GCD_LCM xuli) {
        System.out.print(xuli.tinhLCM() + " ");
        System.out.println(xuli.tinhGCD());
    }
}

public class J01011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01011().thucThi(sc);
        sc.close();
    }
}