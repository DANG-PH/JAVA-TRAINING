import java.util.*;

/*
Bài: J01010 - Cắt đôi
Input:
- Số bộ test T (1 ≤ T ≤ 100)
- Mỗi test: Một số nguyên dương không quá 18 chữ số

Output:
- Nếu số chứa chữ số không hợp lệ (không thuộc {0, 1, 8, 9}) -> in "INVALID"
- Nếu sau khi cắt đôi ra toàn số 0 -> in "INVALID"
- Ngược lại -> In kết quả cắt đôi (bỏ các chữ số 0 ở đầu)

Quy tắc cắt đôi từng chữ số:
0 -> 0
1 -> 1
8 -> 0
9 -> 0
Các số khác -> INVALID

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01010
2. XuLyBaiToanJ01010 -> Đọc số bộ test T từ Scanner
3. Với mỗi test:
    a. Đọc chuỗi N
    b. Tạo object CatDoi(N)
4. CatDoi:
    - hopLe(): Kiểm tra N có chỉ gồm {0, 1, 8, 9} và có ít nhất một '1'
    - chuyenDoi(): Chuyển đổi N theo quy tắc cắt đôi và bỏ số 0 ở đầu
5. XuLyBaiToanJ01010:
    - Nếu hopLe() == false -> in "INVALID"
    - Ngược lại -> in kết quả từ chuyenDoi()
*/

class CatDoi {
    private String chuoiCanCat;

    public CatDoi(String chuoiCanCat) {
        this.chuoiCanCat = chuoiCanCat;
    }

    public boolean hopLe() {
        if (!chuoiCanCat.contains("1")) return false;
//        for (char c : chuoiCanCat.toCharArray()) {
//            if (c != '0' && c != '1' && c != '8' && c != '9') return false;
//        }
        for (int i = 0; i < chuoiCanCat.length(); i++) {
            char c = chuoiCanCat.charAt(i);
            if (c != '0' && c != '1' && c != '8' && c != '9') {
                return false;
            }
        }
        return true;
    }

    public String chuyenDoi() {

        String ketQua = "";
        for (int i = 0; i < chuoiCanCat.length(); i++) {
            char a = chuoiCanCat.charAt(i);
            if (a == '1') {
                ketQua += '1';
            } else {
                ketQua += '0';
            }
        }
//        int idx = 0;
//        while (idx < ketQua.length() && ketQua.charAt(idx) == '0') idx++;
//        if (ketQua.replace("0", "").isEmpty()) return "INVALID";
//        return ketQua.substring(idx);
        long so = Long.parseLong(ketQua);
        return Long.toString(so);
    }
}

class XuLyBaiToanJ01010 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            String n = sc.next();
            CatDoi xuli = new CatDoi(n);
            System.out.println(ketQua(xuli));
        }
    }

    private String ketQua(CatDoi xuli) {
        if (!xuli.hopLe()) {
            return "INVALID";
        }
        return xuli.chuyenDoi();
    }
}

public class J01010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01010().thucThi(sc);
        sc.close();
    }
}