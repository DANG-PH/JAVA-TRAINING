import java.util.*;

class BaiToanCanBang {
    private XetListSoNguyen xuLy;

    public BaiToanCanBang(XetListSoNguyen xuLy) {
        this.xuLy = xuLy;
    }

    public int timDiemCanBang() {
        List<Integer> list = xuLy.getList();
        int tong = xuLy.tongList();

        int tongTrai = 0;
        for (int i = 0; i < list.size(); i++) {
            int tongPhai = tong - tongTrai - list.get(i);
            if (tongTrai == tongPhai) {
                return i + 1;
            }
            tongTrai += list.get(i);
        }
        return -1;
    }
}

class XuLyBaiToanJ02014 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int i = 0; i < boTest; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            XetListSoNguyen listSoNguyen = new XetListSoNguyen(list);
            BaiToanCanBang baiToan = new BaiToanCanBang(listSoNguyen);

            int ketQua = baiToan.timDiemCanBang();
            System.out.println(ketQua);
        }
    }
}

public class J02014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ02014().thucThi(sc);
        sc.close();
    }
}
