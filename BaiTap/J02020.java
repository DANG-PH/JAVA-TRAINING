import java.util.*;

// sau này dùng thuật toán sinh kế tiếp thì chỉ cần thêm hàm mới k đụng code cũ -> sức mạnh của cấu trúc OOP
class ToHopChapKcuaN {
    private int K;
    private int N;
    private List<Integer> toHop = new ArrayList<>();
    private List<List<Integer>> list = new ArrayList<>();

    public ToHopChapKcuaN(int N, int K) {
        this.K = K;
        this.N = N;
    }
    public void backTracking(int diemBatDau) {
        if (toHop.size() == K) {
            list.add(new ArrayList<>(toHop));
            return;
        }
        for (int i = diemBatDau; i <= N; i++) {
            toHop.add(i);
            backTracking(i+1);
            toHop.remove(toHop.size()-1);
        }
    }
    public List<List<Integer>> getList() {
        return list;
    }
}

class XuLyBaiToanJ02020 implements XuLiBaiToan {
    private List<List<Integer>> ketQua;
    private Scanner sc ;

    @Override
    public void docInput(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void thucThi() {
        int N = sc.nextInt();
        int K = sc.nextInt();
        ToHopChapKcuaN toHop = new ToHopChapKcuaN(N, K);
        toHop.backTracking(1);
        ketQua = toHop.getList();
    }

    @Override
    public void inKetQua() {
        for (List<Integer> list : ketQua) {
            for (int x : list) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println("Tong cong co "+ketQua.size()+" to hop");
    }

    protected List<List<Integer>> getKetQua() {
        return ketQua;
    }
}

public class J02020 {
    public static void main(String[] args) {
        XuLiBaiToan xl = new XuLyBaiToanJ02020(); // tính đa hình

        Scanner sc = new Scanner(System.in);
        xl.docInput(sc);
        xl.thucThi();
        xl.inKetQua();
        sc.close();
    }
}
