import java.util.*;

/*
Bài: J01008 - Phân tích thừa số nguyên tố
Input:
- Số bộ test T (1 ≤ T ≤ 100)
- Mỗi test: một số nguyên n (2 ≤ n ≤ 10^9)

Output:
- Với mỗi test, in ra: "Test i: " kèm danh sách các cặp (số nguyên tố, số mũ)

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01008
2. XuLyBaiToanJ01008 -> Đọc số bộ test T, lặp qua từng test
3. Với mỗi test:
    - Tạo object PhanTichSoNguyenTo(n)
4. PhanTichSoNguyenTo -> Phân tích n thành các cặp (số nguyên tố, số mũ) và trả về danh sách List<CapSoNguyenTo>
5. CapSoNguyenTo -> Lưu trữ thông tin một cặp (số nguyên tố, số mũ) và override toString() để định dạng xuất
6. XuLyBaiToanJ01008 -> Nhận danh sách các cặp từ PhanTichSoNguyenTo và in ra màn hình
*/

class PhanTichSoNguyenTo {
    private final long soCanXet;

    public PhanTichSoNguyenTo(long soCanXet) {
        this.soCanXet = soCanXet;
    }

    public List<CapSoNguyenTo> phanTichThuaSoNguyenTo() {
        List<CapSoNguyenTo> cacCap = new ArrayList<>();
        long n = soCanXet;

        for (long i = 2; i * i <= n; i++) {
            int chiSo = 0;
            while (n % i == 0) {
                chiSo++;
                n /= i;
            }
            if (chiSo > 0) {
                cacCap.add(new CapSoNguyenTo(i, chiSo));
            }
        }
        if (n > 1) {
            cacCap.add(new CapSoNguyenTo((int) n, 1));
        }
        return cacCap;
    }

    public long layUocSoNguyenToLonNhat() {
        long n = soCanXet;
        long maxUT = -1;
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                maxUT = i;
                n /= i;
            }
        }
        if (n > 1) maxUT = n;
        return maxUT;
    }
}

class CapSoNguyenTo {
    private long soNguyenTo;
    private int mu;

    public long getSoNguyenTo() {
        return soNguyenTo;
    }

    public int getMu() {
        return mu;
    }

    public CapSoNguyenTo(long soNguyenTo, int mu) {
        this.soNguyenTo = soNguyenTo;
        this.mu = mu;
    }

    @Override
    public String toString() {
        return soNguyenTo + "(" + mu + ")";
    }
}


class XuLyBaiToanJ01008 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            long n = sc.nextLong();
            PhanTichSoNguyenTo xuli = new PhanTichSoNguyenTo(n);
            inKetQua(xuli, t);
        }
    }

    private void inKetQua(PhanTichSoNguyenTo xuli, int chiSoBoTest) {
        System.out.print("Test "+(chiSoBoTest+1)+": ");
        List<CapSoNguyenTo> cacCap = xuli.phanTichThuaSoNguyenTo();
        for (CapSoNguyenTo cap : cacCap) {
            System.out.print(cap + " ");
        }
        System.out.println();
    }
}

public class J01008 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01008().thucThi(sc);
        sc.close();
    }
}
