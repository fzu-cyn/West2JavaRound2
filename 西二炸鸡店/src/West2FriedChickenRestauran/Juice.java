package West2FriedChickenRestauran;

import java.time.LocalDate;
import java.util.Scanner;

public class Juice extends Drinks{
    Scanner scanner = new Scanner(System.in); // 创建Scanner对象
    int ShelfLife=2;
    Juice(String name,double cost,LocalDate production){
        this.name=name;
        this.cost=cost;
        this.production=production;
    }

    @Override
    public String toString() {
        System.out.println("饮料名:"+name);
        System.out.println("成本:"+cost);
        System.out.println("生产日期:"+production);
        System.out.println("保质期:"+ShelfLife);
        return null;
    }
}
