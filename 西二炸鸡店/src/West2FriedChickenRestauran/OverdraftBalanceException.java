package West2FriedChickenRestauran;

import java.util.Scanner;

public class OverdraftBalanceException extends RuntimeException{
    Scanner scanner = new Scanner(System.in); // 创建Scanner对象
    public OverdraftBalanceException(String message){
        super(message);
    }
}
