import java.util.*;

class XuLyBaiToanJ01024 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        while (boTest-- > 0) {
            XetXau xetXau = new XetXau(sc.next());
            boolean ketQua = new SoMayMan().duCacKyTu(xetXau,new char[] { '0','1','2'});
            inKetQua(ketQua);
        }
    }
    private void inKetQua(boolean ketQua) {
        System.out.println(ketQua ? "YES" : "NO");
    }
}

public class J01024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01024().thucThi(sc);
        sc.close();
    }
}
