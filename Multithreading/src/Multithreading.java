
import java.util.Scanner;

public class Multithreading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.println("请输入目标数字：");
        int target=scanner.nextInt();//输入target目标数字
        int number=1000;//设置1000个线程
        int size=1000000;//每个线程的大小
        MyThread []t = new MyThread[1000000];
        for(int i=0;i<number;i++){
            t[i]=new MyThread(i*size,(i+1)*size,target);//传入线程区间及目标数字
            t[i].start();//开始
        }
        for (int i=0;i<number; i++) {
            try{
                t[i].join();
            }
            catch (InterruptedException x) {
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
    public long ans=0;
    public int Start,End;
    public int target;
    public MyThread(int start,int end,int tar){
        this.Start=start;
        this.End=end;
        this.target=tar;
    }//构造函数
    public long getAnswer(){
        return ans;
    }
    @Override
    public void run() {
        for(int i=Start;i<=End;i++)
            if(Multithreading.contain(i,target))
                ans+=i;
    }

}


