import java.util.*;

interface ThuGonList {
    List<Integer> thuGon();
}

// tính đa hình
class BaiToanThuGonList implements ThuGonList {
    private List<Integer> list;

    public BaiToanThuGonList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public List<Integer> thuGon() {
        List<Integer> ketQua = new ArrayList<>();
        for (int num : list) {
            if (!ketQua.isEmpty() && (num + ketQua.get(ketQua.size() - 1)) % 2 == 0) {
                ketQua.remove(ketQua.size() - 1);
            } else {
                ketQua.add(num);
            }
        }
        return ketQua;
    }
}

class XuLyBaiToanJ02017 implements XuLiBaiToan {
    private List<Integer> ketQua;
    private Scanner sc ;

    @Override
    public void docInput(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void thucThi() {
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(sc.nextInt());
        }
        ThuGonList baiToan = new BaiToanThuGonList(list);
        ketQua = baiToan.thuGon();
    }

    @Override
    public void inKetQua() {
        System.out.println(ketQua.size());
    }
}

public class J02017 {
    public static void main(String[] args) {
        XuLyBaiToanJ02017 xl = new XuLyBaiToanJ02017();

        Scanner sc = new Scanner(System.in);
        xl.docInput(sc);
        xl.thucThi();
        xl.inKetQua();
        sc.close();
    }
}
