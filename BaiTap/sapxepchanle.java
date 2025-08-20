import java.util.*;

class XuLyList {
    private List<Integer> list;
    public XuLyList(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> mangChan() {
        List<Integer> mangChan = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                mangChan.add(list.get(i));
            }
        }
        return mangChan;
    }

    public List<Integer> mangLe() {
        List<Integer> mangLe = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                mangLe.add(list.get(i));
            }
        }
        return mangLe;
    }
}

class SortList {
    public List<Integer> tangDan(List<Integer> arr) {
        List<Integer> kq = new ArrayList<>(arr);
        Collections.sort(kq);
        return kq;
    }
    public List<Integer> giamDan(List<Integer> arr) {
        List<Integer> kq = new ArrayList<>(arr);
        Collections.sort(kq, Collections.reverseOrder());
        return kq;
    }
}

class XuLyBaiToan {
    public List<Integer> xuLy(List<Integer> input) {
        XuLyList xl = new XuLyList(input);
        SortList sorter = new SortList();

        List<Integer> chan = sorter.tangDan(xl.mangChan());
        List<Integer> le = sorter.giamDan(xl.mangLe());

        List<Integer> ketQua = new ArrayList<>();
        int iChan = 0, iLe = 0;
        for (int x : input) {
            if (x % 2 == 0) ketQua.add(chan.get(iChan++));
            else ketQua.add(le.get(iLe++));
        }
        return ketQua;
    }
}

class Input {
    public List<Integer> nhapDanhSach(Scanner sc) {
        int n = sc.nextInt();
        List<Integer> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) ds.add(sc.nextInt());
        return ds;
    }
}

class Output {
    public void inDanhSach(List<Integer> ds) {
        for (int x : ds) System.out.print(x + " ");
    }
}

public class sapxepchanle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Input nhap = new Input();
        List<Integer> input = nhap.nhapDanhSach(sc);

        XuLyBaiToan xuLy = new XuLyBaiToan();
        List<Integer> ketQua = xuLy.xuLy(input);

        Output xuat = new Output();
        xuat.inDanhSach(ketQua);

        sc.close();
    }
}
