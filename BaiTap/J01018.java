import java.util.*;

/*
Bài: J01018 - SỐ KHÔNG LIỀN KỀ
-----------------------------------

Yêu cầu:
- Cho số nguyên dương N, kiểm tra:
  1) Tổng các chữ số của N chia hết cho 10.
  2) Các chữ số cạnh nhau chênh lệch đúng 2 đơn vị.

Input:
- Dòng 1: T - số bộ test (T ≤ 20)
- Tiếp theo: T dòng, mỗi dòng là số nguyên dương N
  (N có ít nhất 3 chữ số, không quá 18 chữ số).

Output:
- YES nếu thỏa mãn cả 2 điều kiện.
- NO nếu không.

-----------------------------------
Luồng xử lý (OOP):
-----------------------------------

1. Main → gọi XuLyBaiToanJ01018.

2. XuLyBaiToanJ01018:
   - Đọc số bộ test T.
   - Với mỗi test:
     + Đọc chuỗi số a.
     + Tạo đối tượng XetXau(a) → xử lý chuỗi số.
     + Tạo đối tượng SoMayMan → kiểm tra khoảng cách chữ số.
     + Tạo đối tượng XetChiaHet(xuliXau.tongChuSo()) → kiểm tra chia hết.
     + Kiểm tra:
         * chiaHetCho(10)
         * laSoLienKe(xuliXau, 2)
     + Nếu cả 2 điều kiện đúng → in "YES", ngược lại "NO".

-----------------------------------
=== Các class chức năng ===

- **XetXau**: -> bài J01016 + J01017
  + Lưu chuỗi cần xét.
  + Các phương thức:
    * demKyTuTrongXau(char kyTu)
    * kyTuHienTai(int index)
    * doDai()
    * tongChuSo() → tính tổng chữ số của chuỗi số.

- **SoMayMan**: -> bài J01016 + J01017
  + laSoMayMan(...) → dùng cho bài 16.
  + laSoLienKe(XetXau xau, int khoangCach) → kiểm tra khoảng cách chữ số kề nhau (linh hoạt khoảng cách 1, 2, ...).

- **XetChiaHet**: -> bài J01012
  + Nhận giá trị số bất kỳ → kiểm tra chia hết.
  + Phương thức:
    * chiaHetCho(int n)
    * static chiaHetCho(int soChia, int soBiChia) → nếu muốn dùng trực tiếp.

-----------------------------------
Ưu điểm OOP:
-----------------------------------
- **Tái sử dụng cao**: XetXau, SoMayMan, XetChiaHet đã dùng từ bài 12, 16, 17, và tiếp tục dùng ở đây.
- **Tách biệt nhiệm vụ**: xử lý chuỗi, kiểm tra khoảng cách, kiểm tra chia hết — mỗi class lo một việc.
- **Dễ bảo trì, mở rộng**: thay đổi yêu cầu chỉ cần điều chỉnh class liên quan.
- **Code sạch, rõ ràng**: main chỉ điều phối, không chứa logic xử lý lõi.
*/

class XuLyBaiToanJ01018 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            String a = sc.next();
            XetXau xuliXau = new XetXau(a);
            SoMayMan checker = new SoMayMan();
            XetChiaHet xch = new XetChiaHet(xuliXau.tongChuSo());
            boolean chiaHetCho10 = xch.chiaHetCho(10);
            boolean laSoLienKe2DonVi = checker.laSoLienKe(xuliXau,2);
            String ketQua = chiaHetCho10 && laSoLienKe2DonVi ? "YES" : "NO";
            inKetQua(ketQua);
        }
    }

    private void inKetQua(String ketQua) {
        System.out.println(ketQua);
    }
}


public class J01018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01018().thucThi(sc);
        sc.close();
    }
}