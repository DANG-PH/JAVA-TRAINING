import java.util.*;

class XuLiHaiXau {
    private String xau1;
    private String xau2;
    public XuLiHaiXau(String xau1, String xau2) {
        this.xau1 = xau1;
        this.xau2 = xau2;
    }
    public String congHaiXau() {
        return xau1+xau2;
    }
}

class XuLiHaiXauFib {
    private final long[] fib;

    public XuLiHaiXauFib(long[] fib) {
        this.fib = fib;
    }

    public char timKyTu(int n, long k) {
        if (n == 1) return '0';
        if (n == 2) return '1';
        if (k <= fib[n - 2]) {
            return timKyTu(n - 2, k);
        } else {
            return timKyTu(n - 1, k - fib[n - 2]);
        }
    }
}

class XuLyBaiToanJ01022 {
    public void ThucThi(Scanner sc) {
        int boTest = sc.nextInt();

        long[] fib = new long[93];
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= 92; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        for (int i = 0; i < boTest; i++) {
            int N = sc.nextInt();
            long K = sc.nextLong();
            XuLiHaiXauFib xuLi = new XuLiHaiXauFib(fib);
            char ans = xuLi.timKyTu(N, K);
            XetXau xet = new XetXau(Character.toString(ans));
            System.out.println(xet.kyTuHienTai(0));
        }
    }
}

public class J01022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01022().ThucThi(sc);
        sc.close();
    }
}
