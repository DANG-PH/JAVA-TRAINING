import java.util.Scanner;

public class J01002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            long b = sc.nextLong();
            System.out.println(b*(b+1)/2);
        }
    }
}
