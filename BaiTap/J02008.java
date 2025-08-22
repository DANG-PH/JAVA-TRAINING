import java.util.*;

class XuLyBaiToanJ02008 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int i = 0; i < boTest; i++) {
            int n = sc.nextInt();
            SoNguyenTo soNguyenTo = new SoNguyenTo(n);
            List<Integer> list = soNguyenTo.soNguyenToNhoHonBang_N();
            List<Long> listSau = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                int MAX = 0;
                while (ToanHoc.luyThuaNhiPhan(list.get(j),MAX+1) <= n ) {
                    MAX++;
                }
                listSau.add(ToanHoc.luyThuaNhiPhan(list.get(j),MAX));
            }
            long ketQua = 1;
            for (long so : listSau) {
                ketQua *= so;
            }
            inKetQua(ketQua);
        }
    }
    private void inKetQua (long ketQua) {
        System.out.println(ketQua);
    }
}

public class J02008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ02008().thucThi(sc);
        sc.close();
    }
}
