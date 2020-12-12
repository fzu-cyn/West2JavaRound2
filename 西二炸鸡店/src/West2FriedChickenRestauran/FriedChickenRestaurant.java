package West2FriedChickenRestauran;

import java.util.Scanner;

public interface FriedChickenRestaurant {
    Scanner scanner = new Scanner(System.in); // 创建Scanner对象

    public abstract void PackageForSale(SetMeal setmeal);

    public abstract void BulkPurchase(Drinks drinks,int number);
}
