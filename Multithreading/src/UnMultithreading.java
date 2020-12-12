import java.util.Scanner;

public class UnMultithreading {
    public static void main(String[] args) {
        long ans = 0;
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        for (long i = 1; i < 1000000000; i++) {
            if (contain(i, x)) ans += i;
        }System.out.println(ans); }
        private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}
