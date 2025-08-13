import java.util.*;

class PhuongTrinhBacNhat {
    private float a, b;

    public PhuongTrinhBacNhat(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public String giai() {
        if (a == 0 && b == 0) return "VSN";
        if (a == 0) return "VN";
        return String.format("%.2f", -b / a);
    }
}

public class J01003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();

        PhuongTrinhBacNhat pt = new PhuongTrinhBacNhat(a, b);
        System.out.println(pt.giai());
    }
}