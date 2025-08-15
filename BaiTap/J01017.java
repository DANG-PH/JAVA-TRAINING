import java.util.*;

/*
Bài: J01017 - SỐ LIỀN KỀ
------------------------

Yêu cầu:
- Kiểm tra số nguyên dương N có tính chất:
  "Tất cả các chữ số liền kề nhau chỉ sai khác đúng 1 đơn vị".
- Ví dụ:
    + 123212 → YES
    + 34578  → NO

Input:
- Dòng 1: Số lượng test T (1 ≤ T ≤ 20)
- Tiếp theo: T dòng, mỗi dòng là số nguyên dương N
  (N có ít nhất 2 chữ số, không quá 18 chữ số).

Output:
- Mỗi test: In "YES" nếu thỏa mãn, "NO" nếu không.

------------------------
Luồng xử lý (OOP):
------------------------

1. Main → Gọi XuLyBaiToanJ01017

2. XuLyBaiToanJ01017:
   - Đọc chuỗi số N từ Scanner
   - Tạo đối tượng XetXau (chứa chuỗi cần xét)
   - Tạo đối tượng SoMayMan (chứa logic kiểm tra)
   - Gọi phương thức laSoLienKe(xuliXau)
   - In "YES" nếu đúng, ngược lại in "NO"

3. === Các class chức năng ===

   - **XetXau**:
     - Lưu trữ dữ liệu chuỗi (xauCanXet)
     - Các phương thức:
       + demKyTuTrongXau(char kyTu) → (dùng cho bài 16)
       + kyTuHienTai(int index) → lấy ký tự tại vị trí index
       + doDai() → độ dài chuỗi
     - Tách riêng xử lý chuỗi → có thể tái sử dụng cho nhiều bài toán chuỗi

   - **SoMayMan**:
     - (Bài 16) laSoMayMan(...) → kiểm tra số may mắn
     - (Bài 17) laSoLienKe(xau) → kiểm tra điều kiện liền kề:
       * Duyệt qua các cặp ký tự liên tiếp
       * Lấy hiệu tuyệt đối |cặp sau - cặp trước|
       * Nếu có cặp nào ≠ 1 → trả về false
       * Nếu duyệt hết không vi phạm → trả về true

4. Ưu điểm OOP:
   - **Tách biệt nhiệm vụ**:
     + XetXau → xử lý chuỗi
     + SoMayMan → kiểm tra điều kiện
     + XuLyBaiToan... → điều phối input/output
   - **Tái sử dụng cao**: XetXau và SoMayMan dùng cho cả bài 16 & 17
   - **Mở rộng dễ dàng**: Thêm điều kiện mới chỉ cần thêm phương thức mới
   - **Code rõ ràng, dễ đọc, dễ bảo trì**
*/

class XuLyBaiToanJ01017 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            String a = sc.next();
            XetXau xuliXau = new XetXau(a);
            SoMayMan checker = new SoMayMan();

            String ketQua = checker.laSoLienKe(xuliXau) ? "YES" : "NO";
            inKetQua(ketQua);
        }
    }

    private void inKetQua(String ketQua) {
        System.out.println(ketQua);
    }
}

public class J01017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01017().thucThi(sc);
        sc.close();
    }
}