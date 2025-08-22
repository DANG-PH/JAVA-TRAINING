import java.util.*;

/*
Bài: J01004 - Số Nguyên Tố
Input:
- Số bộ test (int)
- Mỗi test: 1 số nguyên
Output:
- "YES" nếu số nguyên tố, "NO" nếu không

Luồng xử lý (OOP):
1. Main -> Gọi XuLyBaiToanJ01004
2. XuLyBaiToan -> Đọc inputf
3. SoNguyenTo -> Kiểm tra số nguyên tố
4. XuLyBaiToan -> In kết quả
*/

class SoNguyenTo {
    private int soCanTest;

    public SoNguyenTo(int soCanTest) {
        this.soCanTest = soCanTest;
    }

    public boolean isSoNguyenTo() {
        if (soCanTest <= 1) return false;
        int sqrt = (int) Math.sqrt(soCanTest);
        for (int i = 2; i <= sqrt; i++) {
            if (soCanTest % i == 0) return false;
        }
        return true;
    }

    public List<Integer> soNguyenToNhoHonBang_N() {
        List<Integer> listSnt = new ArrayList<>();
        for (int i = 0; i <= soCanTest; i++) {
            if (isSoNguyenTo(i)) {
                listSnt.add(i);
            }
        }
        return listSnt;
    }

    //static
    public static boolean isSoNguyenTo(int so) {
        if (so <= 1) return false;
        int sqrt = (int) Math.sqrt(so);
        for (int i = 2; i <= sqrt; i++) {
            if (so % i == 0) return false;
        }
        return true;
    }
}

class XuLyBaiToanJ01004 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int i = 0; i < boTest; i++) {
            int soCanTest = sc.nextInt();
            SoNguyenTo xsnt = new SoNguyenTo(soCanTest);
            System.out.println(xsnt.isSoNguyenTo() ? "YES" : "NO");
        }
    }
}

public class J01004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01004().thucThi(sc);
        sc.close();
    }
}
