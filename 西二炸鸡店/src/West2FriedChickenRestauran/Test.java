package West2FriedChickenRestauran;

import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        LocalDate productionBeer=LocalDate.of(2020,12,12);
        LocalDate productionJuice=LocalDate.of(2020,12,12);
        Drinks juice=new Juice("可乐",5,LocalDate.now());
        Drinks beer=new Beer("雪津啤酒",5,LocalDate.now(),3);
        West2FriedChickenRestauran west2friedchickenrestauran= new West2FriedChickenRestauran(10000);
        west2friedchickenrestauran.BulkPurchase(juice,2);
        west2friedchickenrestauran.BulkPurchase(beer,2);
      //  West2FriedChickenRestauran.setmealone.toString();
        //West2FriedChickenRestauran.SetMealList.toString();
        West2FriedChickenRestauran.SetMealList.get(0).toString();
        west2friedchickenrestauran.PackageForSale(West2FriedChickenRestauran.SetMealList.get(0));
     //   west2friedchickenrestauran.PackageForSale(west2friedchickenrestauran.setmealone);


    }
}
