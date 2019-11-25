package 设计模式.一_单例模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

public class 单例懒汉模式{
    public static void main(String[] args)
    {
        President zt1=President.getInstance();// new创建后只能当次使用，而getInstance()可以跨栈区域使用，或者远程跨区域使用。所以getInstance()通常是创建static静态实例方法的
                                              // 对于抽象类，是只能用getInstance()方法,是不能new出来的，
        zt1.getName();    //输出总统的名字
        President zt2=President.getInstance();
        zt2.getName();    //输出总统的名字
        if(zt1==zt2)
        {
            System.out.println("他们是同一人！");
        }
        else
        {
            System.out.println("他们不是同一人！");
        }
    }
}
class President
{
    private static volatile President instance=null;    //保证instance在所有线程中同步，volatile 是一个类型修饰符。volatile 的作用是作为指令关键字，确保本条指令不会因编译器的优化而省略。
                                                        //懒汉式，等到别人调用getInstance时再创建对象
    //private避免类在外部被实例化
    private President()
    {
        System.out.println("产生一个总统！");
    }
    public static synchronized President getInstance()
    {
        //在getInstance方法上加同步
        if(instance==null)
        {
            instance=new President();
        }
        else
        {
            System.out.println("已经有一个总统，不能产生新总统！");
        }
        return instance;
    }
    public void getName()
    {
        System.out.println("我是美国总统：特朗普。");
    }
}
