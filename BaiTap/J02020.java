import java.util.*;

// sau này dùng thuật toán sinh kế tiếp thì chỉ cần thêm hàm mới k đụng code cũ -> sức mạnh của cấu trúc OOP
class ToHop_ChinhHop {
    private int K;
    private int N;
    private List<Integer> toHop = new ArrayList<>();
    private List<List<Integer>> listToHop = new ArrayList<>();
    private List<Integer> chinhHop = new ArrayList<>();
    private List<List<Integer>> listChinhHop = new ArrayList<>();
    private boolean[] visited;

    public ToHop_ChinhHop(int N, int K) {
        this.K = K;
        this.N = N;
        this.visited = new boolean[N + 1];
    }
    public void backTrackingToHop(int diemBatDau) {
        if (toHop.size() == K) {
            listToHop.add(new ArrayList<>(toHop));
            return;
        }
        for (int i = diemBatDau; i <= N; i++) {
            toHop.add(i);
            backTrackingToHop(i+1);
            toHop.remove(toHop.size()-1);
        }
    }
    public List<List<Integer>> getListToHop() {
        return listToHop;
    }

    public void backTrackingChinhHop() {
        if (chinhHop.size() == K) {
            listChinhHop.add(new ArrayList<>(chinhHop));
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                chinhHop.add(i);
                backTrackingChinhHop();
                chinhHop.remove(chinhHop.size()-1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> getListChinhHop() {
        return listChinhHop;
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
        ToHop_ChinhHop toHop = new ToHop_ChinhHop(N, K);
        toHop.backTrackingToHop(1);
        ketQua = toHop.getListToHop();
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
