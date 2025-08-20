import java.util.*;
class SoChinhPhuong {
    private int soCanXet;
    public SoChinhPhuong(int soCanXet) {
        this.soCanXet = soCanXet;
    }
    public boolean laSoChinhPhuong() {
        int c = (int)Math.sqrt(soCanXet);
        return c*c == soCanXet;
    }
}

class XuLyBaiToanJ01026 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        while (boTest-- > 0) {
            inKetQua(new SoChinhPhuong(sc.nextInt()).laSoChinhPhuong());
        }
    }
    private void inKetQua(boolean ketQua) {
        System.out.println(ketQua ? "YES" : "NO");
    }
}

public class J01026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01026().thucThi(sc);
        sc.close();
    }
}
