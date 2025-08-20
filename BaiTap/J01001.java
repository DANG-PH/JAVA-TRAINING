import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J01001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) {
            System.out.println(0);
            return;
        }
        long a = sc.nextLong();
        if (!sc.hasNextLong()) {
            System.out.println(0);
            return;
        }
        long b = sc.nextLong();

        if (a <= 0 || b <= 0) {
            System.out.println(0);
        } else {
            long perimeter = 2 * (a + b);
            long area = a * b;
            System.out.println(perimeter + " " + area);
        }
    }
}