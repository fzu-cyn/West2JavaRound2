import java.util.Scanner;

public class UnMultithreading {
    public static void main(String[] args) {
        long ans = 0;
        System.out.println("请输入目标数字：");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        ans=0;
        for (long i = 1; i < 1000000000; i++) {
            if (contain(i, x)) ans += i;
        }
        System.out.println("含有数字"+x+"的所有数字之和为："+ans);
    }
        private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}
