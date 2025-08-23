import java.util.*;

class XuLyBaiToanJ02022 implements XuLiBaiToan {
    private List<String> ketQua = new ArrayList<>();
    private Scanner sc ;

    @Override
    public void docInput(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void thucThi() {
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();

            ToHop_ChinhHop toHopChinhHop = new ToHop_ChinhHop(N, N);
            toHopChinhHop.backTrackingChinhHop();

            List<List<Integer>> lists = toHopChinhHop.getListChinhHop();
            for (List<Integer> l : lists ) {
                String xau = "";
                for (int x : l) {
                    xau += x;
                }
                SoMayMan soMayMan = new SoMayMan();
                XetXau xetXau = new XetXau(xau);
                boolean tonTaiCapHieu1 = soMayMan.coCapHieuBang(xetXau,1);
                if (!tonTaiCapHieu1) {
                    ketQua.add(xau);
                }
            }
        }
    }

    @Override
    public void inKetQua() {
        for (String x : ketQua) {
            System.out.println(x);
        }
    }
}

public class J02022 {
    public static void main(String[] args) {
        XuLiBaiToan xl = new XuLyBaiToanJ02022(); // tính đa hình

        Scanner sc = new Scanner(System.in);
        xl.docInput(sc);
        xl.thucThi();
        xl.inKetQua();
        sc.close();
    }
}
