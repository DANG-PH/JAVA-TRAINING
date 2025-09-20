import java.util.*;

class TinhTong {
    public static String tinhTong2PhanSo(long a, long b, long c, long d) {
        long tu = a*d+c*b;
        long mau = b*d;
        long ucln = gcd(tu, mau);
        return tu/ucln+"/"+mau/ucln;
    }

    public static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a%b);
    }
}

public class TongPhanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] mang = new long[4];
        for (int i = 0; i < 4; i++) {
            mang[i] = sc.nextLong();
        }
        System.out.print(TinhTong.tinhTong2PhanSo(mang[0],mang[1],mang[2],mang[3]));
    }
}
