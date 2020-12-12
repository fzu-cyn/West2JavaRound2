package West2FriedChickenRestauran;

import java.time.LocalDate;
import java.util.Scanner;

public class Beer extends Drinks{
    Scanner scanner = new Scanner(System.in); // 创建Scanner对象
    public float AlcoholDegree;
    int ShelfLife=30;
    Beer(){}
    Beer(String name,double cost,LocalDate production,int AlcoholDegree){
        this.name=name;
        this.cost=cost;
        this.production=production;
        this.AlcoholDegree=AlcoholDegree;
    }
    @Override
    public String toString() {
        System.out.println("饮料名:"+name);
        System.out.println("成本:"+cost);
        System.out.println("酒精度数:"+AlcoholDegree);
        System.out.println("生产日期:"+production);
        System.out.println("保质期:"+ShelfLife);
        return null;
    }
}
