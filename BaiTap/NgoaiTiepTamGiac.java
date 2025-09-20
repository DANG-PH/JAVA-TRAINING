import java.util.*;

class Diem {
    private final double x, y;

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Diem p1, Diem p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class HinhHoc {
    public static double dienTichHinhTronNgoaiTiepTamGiac(Diem p1, Diem p2, Diem p3) {
        double a = Diem.distance(p1, p2);
        double b = Diem.distance(p2, p3);
        double c = Diem.distance(p1, p3);

        if (a + b <= c || a + c <= b || b + c <= a) return -1;

        double p = (a + b + c) / 2.0;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double r = (a * b * c) / (4.0 * s);

        return Math.PI * r * r;
    }
}

public class NgoaiTiepTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            Diem p1 = new Diem(sc.nextDouble(), sc.nextDouble());
            Diem p2 = new Diem(sc.nextDouble(), sc.nextDouble());
            Diem p3 = new Diem(sc.nextDouble(), sc.nextDouble());

            double area = HinhHoc.dienTichHinhTronNgoaiTiepTamGiac(p1, p2, p3);
            if (area == -1) System.out.println("INVALID");
            else System.out.printf("%.3f\n", area);
        }
    }
}