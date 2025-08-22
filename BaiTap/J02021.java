import java.util.*;

class XuLyBaiToanJ02021 extends XuLyBaiToanJ02020 {
    @Override
    public void inKetQua() {
        List<List<Integer>> ketQua = getKetQua();
        for (List<Integer> list : ketQua) {
            for (int x : list) {
                System.out.print(x);
            }
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("Tong cong co "+ketQua.size()+" to hop");
    }
}

public class J02021 {
    public static void main(String[] args) {
        XuLiBaiToan xl = new XuLyBaiToanJ02021(); // tính đa hình

        Scanner sc = new Scanner(System.in);
        xl.docInput(sc);
        xl.thucThi();
        xl.inKetQua();
        sc.close();
    }
}
