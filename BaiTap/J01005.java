import java.util.*;

/*
Bài: J01005 - Chia Tam Giác Cân
Input:
- Số bộ test T (int)
- Mỗi test: 2 số nguyên N H (N: số phần chia, H: chiều cao tam giác)

Output:
- Mỗi test: N-1 số là khoảng cách từ lát cắt thứ i tới đỉnh tam giác
- In 6 chữ số thập phân, cách nhau 1 khoảng trắng

Luồng xử lý (OOP):
1. Main -> Gọi XuLyBaiToanJ01005
2. XuLyBaiToanJ01005 -> Đọc input từ Scanner, lặp qua các test
3. Tạo object ChiaTamGiac(N, H)
4. ChiaTamGiac -> Tính toán danh sách khoảng cách các lát cắt (traVeListChieuCao)
5. XuLyBaiToanJ01005 -> Nhận danh sách từ ChiaTamGiac và in kết quả
*/

class ChiaTamGiac {
    private int soPhanChia;
    private int chieuCao;

    public ChiaTamGiac(int N, int H) {
        this.soPhanChia = N;
        this.chieuCao = H;
    }

    public List<Double> traVeListChieuCao() {
        List<Double> ketQua = new ArrayList<>();
        for (int i = 1; i <= soPhanChia - 1; i++) {
            double a = chieuCao * Math.sqrt(i / (double) soPhanChia);
            ketQua.add(a);
        }
        return ketQua;
    }
}

class XuLyBaiToanJ01005 {
    public void thucThi(Scanner sc) {
        int boTest = sc.nextInt();
        for (int t = 0; t < boTest; t++) {
            int N = sc.nextInt();
            int H = sc.nextInt();
            ChiaTamGiac ctg = new ChiaTamGiac(N, H);
            inKetQua(ctg);
        }
    }

    private void inKetQua(ChiaTamGiac ctg) {
        List<Double> ketQua = ctg.traVeListChieuCao();
        for (Double d : ketQua) {
            System.out.printf("%.6f ", d);
        }
        System.out.println();
    }
}

public class J01005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new XuLyBaiToanJ01005().thucThi(sc);
        sc.close();
    }
}