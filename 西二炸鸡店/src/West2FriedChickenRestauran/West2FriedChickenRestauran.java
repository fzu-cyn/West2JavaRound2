package West2FriedChickenRestauran;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class West2FriedChickenRestauran implements FriedChickenRestaurant{
    Scanner scanner = new Scanner(System.in); // 创建Scanner对象
    public double AccountBalance;
    ArrayList<Beer> BeerList = new ArrayList<Beer>();
    ArrayList<Juice> JuiceList = new ArrayList<Juice>();
    static final ArrayList<SetMeal> SetMealList = new ArrayList<SetMeal>();
   // static final public SetMeal setmealone ;
    West2FriedChickenRestauran(double AccountBalance){
        this.AccountBalance=AccountBalance;
    }

    //use函数
    public void Use(Juice juices) throws IngredientSortOutException{
        boolean flag=true;
        int size=JuiceList.size();
        for(int i=0;i<size;i++)
            if(JuiceList.get(i).stale())
            {
                JuiceList.remove(i);
                i--;
                System.out.println("已过期");
            }
        for(Juice juice:JuiceList){
            if(juices.name.equals(juice.name)){
                JuiceList.remove(juice);
                flag=false;
                break;
            }
        }
        if (flag) throw new IngredientSortOutException(juices.name + "售罄");

    }

    public void Use(Beer beers) throws IngredientSortOutException{
        boolean flag=true;
        int size=BeerList.size();
        for(int i=0;i<size;i++)
            if(BeerList.get(i).stale())
            {
                BeerList.remove(i);
                i--;
                System.out.println("已过期");
            }
        for(Beer beer:BeerList){
            if(beers.name.equals(beer.name)){
                BeerList.remove(beer);
                flag=false;
                break;
            }
        }
        if(flag) throw new IngredientSortOutException(beers.name+"售罄");
    }

    //售卖
    @Override
    public void PackageForSale(SetMeal setmeal){
        AccountBalance+=setmeal.price;
        if(setmeal.drinks instanceof Beer){
            try{
                Use((Beer)setmeal.drinks);
                System.out.println("成功售出:");
                setmeal.toString();
                System.out.println("余额:"+AccountBalance);
            }
            catch(IngredientSortOutException x){
                AccountBalance-=setmeal.price;
                System.out.println(x.getMessage());
                System.out.println("缺货："+setmeal.name);
                System.out.println("售出失败");
                x.printStackTrace();
            }
        }
        if(setmeal.drinks instanceof Juice){
            try{
                Use((Juice)setmeal.drinks);
                System.out.println("成功售出:");
                setmeal.toString();
                System.out.println("余额:"+AccountBalance);
            }
            catch(IngredientSortOutException x){
                AccountBalance-=setmeal.price;
                System.out.println(x.getMessage());
                System.out.println("缺货："+setmeal.name);
                System.out.println("售出失败");
                x.printStackTrace();
            }
        }
    }

    //进货
    @Override
    public void BulkPurchase(Drinks drinks,int number) throws OverdraftBalanceException{
        try{
            if(drinks instanceof Juice){
                Juice juice = (Juice) drinks;
                if(AccountBalance-juice.cost*number>=0){
                    AccountBalance-=juice.cost*number;
                    for(int i=0;i<number;i++)
                        JuiceList.add(juice);
                    System.out.println("已购买"+number+"瓶"+juice.name);
                    System.out.println("余额:"+AccountBalance);
                }
                else throw new OverdraftBalanceException("余额不足，仍需资金"+(juice.cost*number-AccountBalance)+"元。购买"+juice.name+"失败");
            }
            if(drinks instanceof Beer){
                Beer beer = (Beer) drinks;
                if(AccountBalance-beer.cost*number>=0){
                    AccountBalance-=beer.cost*number;
                    for(int i=0;i<number;i++)
                        BeerList.add(beer);
                    System.out.println("已购买"+number+"瓶"+beer.name);
                    System.out.println("余额:"+AccountBalance);
                }
                else throw new OverdraftBalanceException("余额不足，仍需资金"+(beer.cost*number-AccountBalance)+"元。购买"+beer.name+"失败");
            }
        }
        catch(OverdraftBalanceException x) {
            x.printStackTrace();
        }
    }

    static{
        LocalDate production=LocalDate.of(2020,12,12);
        // setmealone = new SetMeal("套餐一",25,"原味炸鸡",new Juice("可乐",5,LocalDate.now()));
        SetMealList.add(new SetMeal("套餐1",25,"原味炸鸡",new Juice("可乐",5,LocalDate.now())));
        SetMealList.add(new SetMeal("套餐2",25,"原味炸鸡",new Juice("雪碧",5,LocalDate.now())));
        SetMealList.add(new SetMeal("套餐3",25,"原味炸鸡",new Juice("芬达",5,LocalDate.now())));
        SetMealList.add(new SetMeal("套餐4",25,"原味炸鸡",new Juice("菠萝啤",5,LocalDate.now())));
        SetMealList.add(new SetMeal("套餐5",25,"孜然炸鸡",new Beer("雪津啤酒",5,LocalDate.now(),3)));
        SetMealList.add(new SetMeal("套餐6",25,"孜然炸鸡",new Beer("青岛啤酒",5,LocalDate.now(),3)));
        SetMealList.add(new SetMeal("套餐7",25,"孜然炸鸡",new Beer("百威啤酒",5,LocalDate.now(),3)));
    }


}
