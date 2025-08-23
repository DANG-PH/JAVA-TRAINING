import java.util.*;

class XetListSoNguyen {
    private List<Integer> list;

    public XetListSoNguyen(List<Integer> list) {
        this.list = list;
    }

    public List<SoLanXuatHienMotSo> soLanXuatHienPhanTu() {
        List<SoLanXuatHienMotSo> cacCap = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), 0);
            }
            map.put(list.get(i),map.get(list.get(i))+1);
        }
        for (int key : map.keySet()) {
            cacCap.add(new SoLanXuatHienMotSo(key,map.get(key)));
        }
        return cacCap;
    }

    public int tongTrai(int index) {
        int tong = 0;
        for (int i = 0; i < index; i++) tong += list.get(i);
        return tong;
    }

    public int tongPhai(int index) {
        int tong = 0;
        for (int i = index + 1; i < list.size(); i++) tong += list.get(i);
        return tong;
    }

    public List<Integer> getList() {
        return list;
    }

    public int tongList() {
        int tong = 0;
        for (int x : list) {
            tong += x;
        }
        return tong;
    }

    public int maxList() {
        int Max = list.get(0);
        for (int x : list) {
            if (Max < x) {
                Max = x;
            }
        }
        return Max;
    }
}

class SoLanXuatHienMotSo {
    private int soCanXet;
    private int lanXuatHien;

    public int getSoCanXet() {
        return soCanXet;
    }

    public int getLanXuatHien() {
        return lanXuatHien;
    }

    public SoLanXuatHienMotSo(int soCanXet, int lanXuatHien) {
        this.soCanXet = soCanXet;
        this.lanXuatHien = lanXuatHien;
    }
}


class XuLyBaiToanJ02007 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int i = 0; i < boTest; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                list.add(sc.nextInt());
            }
            XetListSoNguyen xetListSoNguyen = new XetListSoNguyen(list);
            List<SoLanXuatHienMotSo> listCap = xetListSoNguyen.soLanXuatHienPhanTu();
            inKetQua(listCap, i);
        }
    }

    private void inKetQua(List<SoLanXuatHienMotSo> listCap, int chiSoBoTest) {
        System.out.println("Test "+(chiSoBoTest+1)+":");
        for (int i = 0; i < listCap.size(); i++) {
            System.out.println(listCap.get(i).getSoCanXet()+" xuat hien "+listCap.get(i).getLanXuatHien()+" lan");
        }
    }
}

public class J02007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ02007().thucThi(sc);
        sc.close();
    }
}
