import java.util.*;

/*
Bài: J01013 - TỔNG ƯỚC SỐ - 1
Input:
- Dòng 1: Số bộ test T (1 ≤ T ≤ 100)
- Mỗi test: Một số nguyên dương a (2 ≤ a ≤ 10^9)

Output:
- Với mỗi test: In ra tổng của (số nguyên tố * số mũ) của tất cả các thừa số nguyên tố của a

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01013
2. XuLyBaiToanJ01013:
   - Đọc số bộ test T từ Scanner
   - Với mỗi test:
     a. Đọc số nguyên a
     b. Tạo object PhanTichSoNguyenTo(a)  <-- **tái sử dụng class từ bài 8**
     c. Lấy danh sách các cặp (số nguyên tố, số mũ) từ phương thức phanTichThuaSoNguyenTo()
     d. Tính tổng: ketQua += cap.getSoNguyenTo() * cap.getMu()
     e. In kết quả

3. === Tái sử dụng class từ bài 8 ====
   - **PhanTichSoNguyenTo**: phân tích a thành danh sách các cặp (số nguyên tố, số mũ)
   - **CapSoNguyenTo**: lưu trữ thông tin một cặp (số nguyên tố, số mũ), override toString() để xuất định dạng
   - Nhờ OOP, bài 13 **không cần viết lại logic phân tích số nguyên tố** mà chỉ dùng lại class đã viết sẵn từ bài 8
   - Điều này minh họa **tái sử dụng code và modularity** trong OOP

4. XuLyBaiToanJ01013:
   - Nhận danh sách các cặp từ PhanTichSoNguyenTo
   - Tính tổng và in ra kết quả

Ưu điểm OOP:
- Tách biệt nhiệm vụ từng class: phân tích số nguyên tố, lưu cặp, xử lý input/output
- Dễ tái sử dụng: PhanTichSoNguyenTo có thể dùng cho các bài toán khác (bài 13 chính là ví dụ)
- Dễ mở rộng: thêm tính năng mới mà không sửa class cũ
- Code rõ ràng, dễ đọc, dễ bảo trì
*/

class XuLyBaiToanJ01013 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        int ketQua = 0;
        for (int t = 0; t < boTest; t++) {
            int a = sc.nextInt();
            PhanTichSoNguyenTo xuli = new PhanTichSoNguyenTo(a);
            List<CapSoNguyenTo> cacCap = xuli.phanTichThuaSoNguyenTo();
            for (CapSoNguyenTo cap : cacCap) {
                ketQua += cap.getMu() * cap.getSoNguyenTo();
            }
        }
        inKetQua(ketQua);
    }

    private void inKetQua(int ketQua) {
        System.out.println(ketQua);
    }
}

public class J01013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01013().thucThi(sc);
        sc.close();
    }
}
