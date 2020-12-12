package West2FriedChickenRestauran;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Drinks {
    Scanner scanner = new Scanner(System.in); // 创建Scanner对象
    protected String name;//名字
    protected double cost;//成本
    protected LocalDate production;//生产日期
    protected int ShelfLife;
    Drinks(){}
    Drinks(String name,double cost,LocalDate production,int ShelfLife){
        this.name=name;
        this.cost=cost;
        this.production=production;
        this.ShelfLife=ShelfLife;
    }
    public boolean stale(){
        if(this instanceof Beer){
            Beer beer = (Beer) this;
            if(production.plusDays(beer.ShelfLife).isAfter(LocalDate.now())) return false;
            else return true;
        }
        else if(this instanceof Juice){
            Juice juice = (Juice) this;
            if(production.plusDays(juice.ShelfLife).isAfter(LocalDate.now())) return false;
            else return true;
        }
        else return false;
    }//函数，判断是否过期
    public abstract String toString();

}
