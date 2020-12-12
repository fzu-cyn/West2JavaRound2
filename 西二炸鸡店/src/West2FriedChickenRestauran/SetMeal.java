package West2FriedChickenRestauran;

import java.util.Scanner;

public class SetMeal {
    Scanner scanner = new Scanner(System.in); // 创建Scanner对象
    public String name;
    public double price;
    public String FriedChicken;
    Drinks drinks;
    SetMeal(){}
    SetMeal(String name,double price,String FriedChicken,Drinks drinks){
        this.name=name;
        this.price=price;
        this.FriedChicken=FriedChicken;
        this.drinks=drinks;
    }

    public String toString() {
        System.out.println("套餐名:"+name);
        System.out.println("套餐价格:"+price);
        System.out.println("炸鸡名:"+FriedChicken);
        System.out.println("饮料名:"+drinks.name);
        return null;
    }
}
