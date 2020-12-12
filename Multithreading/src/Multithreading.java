
import java.util.Scanner;

public class Multithreading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.println("请输入目标数字：");
        int target=scanner.nextInt();//输入target
        int number=100;
        int length=10000000;
        MyThread []t = new MyThread[10000000];
        for(int i=0;i<number;i++){
            t[i]=new MyThread(i*length,(i+1)*length,target);
            t[i].start();
        }
        for (int i=0;i<number; i++) {
            try{
                t[i].join();
            } catch (InterruptedException x) {
                x.printStackTrace( );
            }
        }
        long Ans=0;
        for(int i=0;i<number;i++)
            Ans+=t[i].getAnswer();
        System.out.println("含有数字"+target+"的所有数字之和为："+Ans);//输出含有某个数字的所有数字之和
    }
    public static boolean contain(long number,int target){
        return String.valueOf(number).contains(String.valueOf(target));
    }
}

class MyThread extends Thread {
    private int Start,End;
    private long ans=0;
    private int target;
    public long getAnswer(){
        return ans;
    }
    public MyThread(int start,int end,int tar){
        this.Start=start;
        this.End=end;
        this.target=tar;
    }
    @Override
    public void run() {
        for(int i=Start;i<=End;i++){
            if(Multithreading.contain(i,target)){
                ans+=i;
            }
        }
    }

}


