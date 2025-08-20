import java.util.*;

class XuLyBaiToanJ02004 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        while (boTest-- > 0) {
            int n = sc.nextInt();
            String xauCanXet = "";
            while (n-- > 0) {
                xauCanXet += sc.nextInt();
            }
            XetXau xetXau = new XetXau(xauCanXet);
            String[] xauChiaDoi = xetXau.chiaDoiXau();
            XetXau xetXau1 = new XetXau(xauChiaDoi[1]);
            boolean ketQua = false;
            if (xauChiaDoi[0].equals(xetXau1.daoNguocXau())) {
                ketQua = true;
            }
            inKetQua(ketQua);
        }
    }
    private void inKetQua(boolean ketQua) {
        System.out.println(ketQua ? "YES" : "NO");
    }
}

public class J02004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ02004().thucThi(sc);
        sc.close();
    }
}
