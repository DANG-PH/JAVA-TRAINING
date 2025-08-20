import java.util.*;

/*
Bài: J01016 - CHỮ SỐ 4 VÀ CHỮ SỐ 7
Input:
- Dòng 1: Chuỗi số nguyên dương a (1 ≤ length(a) ≤ 100)

Output:
- "YES" nếu tổng số ký tự '4' và '7' trong a bằng 4 hoặc 7
- "NO" nếu không thỏa

Luồng xử lý (OOP):

1. Main -> Gọi XuLyBaiToanJ01016

2. XuLyBaiToanJ01016:
   - Đọc chuỗi số từ Scanner
   - Tạo đối tượng XetXau (chứa chuỗi cần xét)
   - Tạo đối tượng DemSoMayMan (chứa logic kiểm tra)
   - Gọi phương thức laSoMayMan(xuliXau, '4', '7')
   - In "YES" nếu đúng, ngược lại in "NO"

3. === Các class chức năng ===

   - **XetXau**:
     - Chứa dữ liệu chuỗi cần xét (xauCanXet)
     - Phương thức demKyTuTrongXau(char kyTu): đếm số lần xuất hiện của ký tự
     - Tách riêng xử lý chuỗi → có thể tái sử dụng cho bài toán chuỗi khác

   - **DemSoMayMan**:
     - Nhận 1 XetXau và 2 ký tự may mắn
     - Kiểm tra tổng số lần xuất hiện 2 ký tự này
     - Trả về true nếu tổng == giá trị số của ký tự 1 hoặc ký tự 2
     - Tách riêng logic kiểm tra → dễ thay đổi tiêu chí "số may mắn"

4. Ưu điểm OOP:
   - **Tách biệt nhiệm vụ**:
     + XetXau → xử lý chuỗi
     + DemSoMayMan → kiểm tra số may mắn
     + XuLyBaiToan → điều phối input/output
   - **Tái sử dụng**: XetXau có thể dùng cho các bài khác; DemSoMayMan dùng cho nhiều kiểu ký tự may mắn
   - **Mở rộng dễ dàng**: Muốn thay ký tự may mắn chỉ cần đổi tham số khi gọi hàm, không sửa code lõi
   - **Code rõ ràng, dễ đọc, dễ bảo trì**
*/

class XetXau {
    private final String xauCanXet;
    public XetXau(String xauCanXet) {
        this.xauCanXet = xauCanXet;
    }
    public int demKyTuTrongXau(char kyTu) {
        int dem = 0;
        for (char kt : xauCanXet.toCharArray()) {
            if (kt == kyTu) dem ++;
        }
        return dem;
    }
    public char kyTuHienTai(int index) {
        return xauCanXet.charAt(index);
    }
    public int doDai() {
        return xauCanXet.length();
    }
    public int tongChuSo() {
        int sum = 0;
        for (char c : xauCanXet.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
    public String traVeXau() {
        return xauCanXet;
    }
    public String[] chiaDoiXau() {
        if (xauCanXet.length()%2==0) {
            return new String[] {xauCanXet.substring(0,xauCanXet.length()/2), xauCanXet.substring(xauCanXet.length()/2)};
        } else {
            return new String[] {xauCanXet.substring(0,(xauCanXet.length()-1)/2), xauCanXet.substring((xauCanXet.length()+1)/2)};
        }
    }
    public String daoNguocXau() {
        char[] mangKyTu = xauCanXet.toCharArray();
        for (int i = 0;i < mangKyTu.length/2; i++) {
            char tmp = mangKyTu[i];
            mangKyTu[i] = mangKyTu[mangKyTu.length-1-i];
            mangKyTu[mangKyTu.length-1-i] = tmp;
        }
        return String.valueOf(mangKyTu);
    }
}

class SoMayMan {
    public boolean laSoMayMan(XetXau xau,char kytu1, char kytu2) {
        int so4 = xau.demKyTuTrongXau(kytu1);
        int so7 = xau.demKyTuTrongXau(kytu2);
        int tong = so4 + so7;
        return (tong == (kytu1 - '0') || tong == (kytu2 - '0'));
    }
    public boolean laSoLienKe(XetXau xau,int khoangCach) {
        for (int i = 0; i < xau.doDai() - 1; i++) {
            int hieu = Math.abs(xau.kyTuHienTai(i+1) - xau.kyTuHienTai(i));
            if (hieu != khoangCach) {
                return false;
            }
        }
        return true;
    }
    public boolean duCacKyTu(XetXau xau, char[] kytu) {
        int[] so = new int[kytu.length];
        for (int i = 0; i < kytu.length; i++) {
            so[i] = xau.demKyTuTrongXau(kytu[i]);
        }
        int tong = 0;
        for (int cacso : so) {
            tong += cacso;
        }
        return (tong == xau.doDai());
    }
}

class XuLyBaiToanJ01016 {
    public void thucThi(Scanner sc) {
        String a = sc.next();
        XetXau xuliXau = new XetXau(a);
        SoMayMan checker = new SoMayMan();

        String ketQua = checker.laSoMayMan(xuliXau,'4','7') ? "YES" : "NO";
        inKetQua(ketQua);
    }

    private void inKetQua(String ketQua) {
        System.out.println(ketQua);
    }
}

public class J01016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01016().thucThi(sc);
        sc.close();
    }
}
