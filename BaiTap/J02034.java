import java.util.*;

class TaoListTu1toiN {
    private int so;
    public TaoListTu1toiN(int so) {
        this.so = so;
    }
    public List<Integer> taoList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < so; i++) {
            list.add(i+1);
        }
        return list;
    }
}

class XuLyBaiToanJ02034 implements XuLiBaiToan {
    private Set<Integer> ketQua;
    private Scanner sc ;

    @Override
    public void docInput(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void thucThi() {
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while (N-- > 0) {
            list.add(sc.nextInt());
        }
        XetListSoNguyen xetListSoNguyen = new XetListSoNguyen(list);
        TaoListTu1toiN taoListTu1toiN = new TaoListTu1toiN(xetListSoNguyen.maxList());
        List<Integer> list1 = taoListTu1toiN.taoList();
        Set<Integer> set = new LinkedHashSet<>(list);
        Set<Integer> set1 = new LinkedHashSet<>(list1);
        XuLiHaiTap xuLiHaiTap = new XuLiHaiTap(set1,set);
        ketQua = xuLiHaiTap.phanBuCuaA();
    }

    @Override
    public void inKetQua() {
        if (ketQua.size() == 0) {
            System.out.println("Excellent!");
        } else {
            for (int x : ketQua) {
                System.out.println(x);
            }
        }
    }
}

public class J02034 {
    public static void main(String[] args) {
        XuLiBaiToan xl = new XuLyBaiToanJ02034(); // tính đa hình

        Scanner sc = new Scanner(System.in);
        xl.docInput(sc);
        xl.thucThi();
        xl.inKetQua();
        sc.close();
    }
}
