import java.util.*;

/*
Bài: J01014 - Tìm ước số nguyên tố lớn nhất của N
Input:
- Dòng 1: Số bộ test T (1 ≤ T ≤ 100)
- Mỗi test: Một số nguyên dương N (2 ≤ N ≤ 10^10)

Output:
- Với mỗi test, in ra ước số nguyên tố lớn nhất của N

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01014
2. XuLyBaiToanJ01014:
   - Đọc số bộ test T từ Scanner
   - Với mỗi test:
     a. Đọc số nguyên N
     b. Tạo object PhanTichSoNguyenTo(N)  <-- **tái sử dụng class từ bài 8**
     c. Gọi phương thức layUocSoNguyenToLonNhat() để lấy ước số nguyên tố lớn nhất
     d. In kết quả

3. === Tái sử dụng class từ bài 8 ====
   - **PhanTichSoNguyenTo**: phân tích N thành danh sách các cặp (số nguyên tố, số mũ)
   - **CapSoNguyenTo**: lưu trữ thông tin một cặp (số nguyên tố, số mũ), override toString() để xuất định dạng
   - Nhờ OOP, bài 14 **không cần viết lại logic phân tích số nguyên tố** mà chỉ dùng lại class đã viết sẵn từ bài 8
   - Điều này minh họa **tái sử dụng code và modularity** trong OOP

4. XuLyBaiToanJ01014:
   - Tạo object PhanTichSoNguyenTo với N
   - Gọi layUocSoNguyenToLonNhat() để lấy kết quả
   - In ra kết quả

Ưu điểm OOP:
- Tách biệt nhiệm vụ từng class: phân tích số nguyên tố, lưu cặp, xử lý input/output
- Dễ tái sử dụng: PhanTichSoNguyenTo có thể dùng cho các bài toán khác (bài 14 chính là ví dụ)
- Dễ mở rộng: thêm tính năng mới mà không sửa class cũ
- Code rõ ràng, dễ đọc, dễ bảo trì
*/

class XuLyBaiToanJ01014 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            long a = sc.nextLong();
            PhanTichSoNguyenTo xuli = new PhanTichSoNguyenTo(a);
            long ketQua = xuli.layUocSoNguyenToLonNhat();
            inKetQua(ketQua);
        }
    }

    private void inKetQua(long ketQua) {
        System.out.println(ketQua);
    }
}

public class J01014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01014().thucThi(sc);
        sc.close();
    }
}
