package West2FriedChickenRestauran;

import java.util.Scanner;

public class IngredientSortOutException extends RuntimeException{
    Scanner scanner = new Scanner(System.in); // 创建Scanner对象
    public IngredientSortOutException(String message){
        super(message);
    }
}
