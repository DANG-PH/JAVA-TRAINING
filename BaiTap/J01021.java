import java.util.*;

/*
Bài: J01021 - TÍNH LŨY THỪA NHỊ PHÂN MODULO
Input:
- Nhiều dòng, mỗi dòng chứa 2 số nguyên dương a, b (0 ≤ a, b ≤ 10^18)
- Kết thúc khi nhập "0 0"

Output:
- Giá trị (a^b) mod (1_000_000_007) cho mỗi dòng input

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01021

2. XuLyBaiToanJ01021:
   - Đọc a, b từ Scanner
   - Nếu a = 0 và b = 0 thì kết thúc
   - Gọi phương thức ToanHoc.luyThuaNhiPhan(a, b) để tính kết quả
   - In ra kết quả

3. === Các class chức năng ===

   - **ToanHoc**:
     - Hằng số MOD = 1_000_000_007
     - Phương thức luyThuaNhiPhan(long a, long b):
       + Sử dụng thuật toán lũy thừa nhị phân (Binary Exponentiation)
       + Mỗi phép nhân đều lấy mod MOD để tránh tràn số
       + Độ phức tạp: O(log2 b)
       + Tính chất sử dụng:
           (x * y) mod m = ((x mod m) * (y mod m)) mod m
     - Hoàn toàn tách biệt phần toán học, dễ tái sử dụng

   - **XuLyBaiToanJ01021**:
     - Chịu trách nhiệm đọc input và in output
     - Điều phối việc gọi hàm toán học
     - Giúp code main gọn gàng, dễ bảo trì

4. Thuật toán lũy thừa nhị phân:
   - Ý tưởng:
       + Biểu diễn b ở dạng nhị phân, ví dụ b = 13 = (1101)₂
       + a^13 = a^8 * a^4 * a^1 (ứng với bit 1)
       + Duyệt từng bit của b từ phải sang trái:
           * Nếu bit cuối = 1 → nhân kết quả với a
           * Luôn bình phương a để chuẩn bị cho bit tiếp theo
           * Dịch b sang phải (b /= 2)
        // 13 = 1101 = 1*2^3+1*2^2+0*2^1+1*2^0
        //   a^13
        // = a^(1*2^3+1*2^2+0*2^1+1*2^0)
        // = a^8.a^4.a^(2*0).a^1
        // bài toán con, b từ 13 về 0, result từ 0 lên 13 , kết quả là a^result, result được tăng theo pp dịch bit và xét bit cuối để cộng sao cho bằng đúng 13
        // -> for 4 lần , độ phức tạp O(log2(n))
        //1 a 13
        //a a^2 6
        //a a^4 3
        //a^5 a^8 1
        //a^13 a^13 0

5. Ưu điểm OOP:
   - **Tách biệt nhiệm vụ**:
     + ToanHoc → xử lý toán học
     + XuLyBaiToanJ01021 → xử lý input/output
   - **Tái sử dụng**: Hàm lũy thừa nhị phân có thể dùng cho mọi bài cần tính mũ mod
   - **Mở rộng dễ dàng**: Muốn đổi MOD hoặc thuật toán chỉ cần sửa ở ToanHoc
   - **Code rõ ràng, dễ đọc, dễ bảo trì**
*/

class ToanHoc {
    private static final long MOD = 1_000_000_007;

    public static long luyThuaNhiPhan(long a, long b) {
        long result = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b /= 2;
        }

        return result % MOD;
    }
}


class XuLyBaiToanJ01021 {
    public void thucThi(Scanner sc) {
        while (true) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == 0 && b == 0) return;
            long ketQua = ToanHoc.luyThuaNhiPhan(a, b);
            inKetQua(ketQua);
        }
    }

    private void inKetQua(long ketQua) {
        System.out.println(ketQua);
    }
}

public class J01021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01021().thucThi(sc);
        sc.close();
    }
}
