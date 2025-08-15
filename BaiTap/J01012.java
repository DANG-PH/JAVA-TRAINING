import java.util.*;

/*
Bài: J01012 - ƯỚC SỐ CHIA HẾT CHO 2
Input:
- Dòng 1: Số bộ test T (1 ≤ T ≤ 100)
- Mỗi bộ test: Một số nguyên dương a (1 ≤ a ≤ 10^9)

Output:
- Với mỗi bộ test: In ra số lượng ước chẵn của a trên một dòng

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01012
2. XuLyBaiToanJ01012:
    - Đọc số bộ test T từ Scanner
    - Với mỗi test:
        a. Đọc số nguyên a
        b. Tạo object UocSo(a)
        c. Lấy danh sách ước số: mangUocSo()
        d. Duyệt danh sách ước số:
            - Dùng XetChiaHet.chiaHetCho(ước số, 2) để kiểm tra chẵn
            - Tăng biến đếm ketQua nếu chia hết
        e. In kết quả ketQua
3. Class UocSo:
    - Thuộc tính private soCanXet
    - Phương thức mangUocSo(): trả về danh sách ước số, tối ưu lặp đến √soCanXet, tránh duplicate khi i*i = soCanXet
4. Class XetChiaHet:
    - Thuộc tính private soCanXet (cho trường hợp instance)
    - Phương thức chiaHetCho(int n) kiểm tra instance
    - Phương thức static chiaHetCho(int soChia, int soBiChia) dùng trực tiếp không cần tạo đối tượng
5. XuLyBaiToanJ01012:
    - Điều phối chương trình: đọc input, tính số ước chẵn, in kết quả
*/

class UocSo {
    private int soCanXet;
    public UocSo(int soCanXet) {
        this.soCanXet = soCanXet;
    }
    public List<Integer> mangUocSo() {
        List<Integer> mangUocSo = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(soCanXet); i++) {
            if (soCanXet%i==0) {
                mangUocSo.add(i);
                if (i != soCanXet / i) {
                    mangUocSo.add(soCanXet / i);
                }
            }
        }
        return mangUocSo;
    }
}

class XetChiaHet {
    private int soCanXet;
    public XetChiaHet(int soCanXet) {
        this.soCanXet = soCanXet;
    }
    public boolean chiaHetCho(int n) {
        return soCanXet % n == 0;
    }
    // static
    public static boolean chiaHetCho(int soChia, int soBiChia) {
        return soChia % soBiChia == 0;
    }
}

class XuLyBaiToanJ01012 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            int a = sc.nextInt();
            UocSo xuli = new UocSo(a);
            List<Integer> mangUocSo = xuli.mangUocSo();
            int ketQua = 0;
            for (int i = 0; i < mangUocSo.size(); i++) {
                if (XetChiaHet.chiaHetCho(mangUocSo.get(i),2)) {
                    ketQua++;
                }
            }
            inKetQua(ketQua);
        }
    }

    private void inKetQua(int ketQua) {
        System.out.println(ketQua);
    }
}

public class J01012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01012().thucThi(sc);
        sc.close();
    }
}
