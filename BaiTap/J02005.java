import java.util.*;

class XuLiHaiTap {
    private Set<Integer> A;
    private Set<Integer> B;

    public XuLiHaiTap(Set<Integer> A, Set<Integer> B) {
        this.A = A;
        this.B = B;
    }

    public Set<Integer> giaoHaiTap() {
        Set<Integer> giao = new TreeSet<>(A);
        giao.retainAll(B);
        return giao;
    }

    public Set<Integer> hopHaiTap() {
        Set<Integer> hop = new TreeSet<>(A);
        hop.addAll(B);
        return hop;
    }
}

class XuLyBaiToanJ02005 {
    public void thucThi(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        Set<Integer> A = new TreeSet<>();
        Set<Integer> B = new TreeSet<>();

        for (int i = 0; i < a; i++) A.add(sc.nextInt());
        for (int i = 0; i < b; i++) B.add(sc.nextInt());

        XuLiHaiTap xuLi = new XuLiHaiTap(A, B);
        inKetQua(xuLi.giaoHaiTap());
    }
    public void inKetQua(Set<Integer> ketQua) {
        for (int phanTu : ketQua) {
            System.out.print(phanTu+" ");
        }
    }
}

public class J02005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ02005().thucThi(sc);
        sc.close();
    }
}
