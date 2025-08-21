import java.util.*;

class XuLyBaiToanJ02006 {
    public void thucThi(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        Set<Integer> A = new TreeSet<>();
        Set<Integer> B = new TreeSet<>();

        for (int i = 0; i < a; i++) A.add(sc.nextInt());
        for (int i = 0; i < b; i++) B.add(sc.nextInt());

        XuLiHaiTap xuLi = new XuLiHaiTap(A, B);
        inKetQua(xuLi.hopHaiTap());
    }
    public void inKetQua(Set<Integer> ketQua) {
        for (int phanTu : ketQua) {
            System.out.print(phanTu+" ");
        }
    }
}

public class J02006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ02006().thucThi(sc);
        sc.close();
    }
}
