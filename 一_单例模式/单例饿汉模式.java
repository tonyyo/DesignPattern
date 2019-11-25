package 设计模式.一_单例模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

public class 单例饿汉模式{
    public static void main(String[] args)
    {
        president zt1=president.getInstance();// new创建后只能当次使用，而getInstance()可以跨栈区域使用，或者远程跨区域使用。所以getInstance()通常是创建static静态实例方法的
        // 对于抽象类，是只能用getInstance()方法,是不能new出来的，
        zt1.getName();    //输出总统的名字
        president zt2=president.getInstance();
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
class president
{
    private static volatile president instance=new president();    //保证instance在所有线程中同步，volatile 是一个类型修饰符。volatile 的作用是作为指令关键字，确保本条指令不会因编译器的优化而省略。
    //private避免类在外部被实例化
    private president()
    {
        System.out.println("产生一个总统！");
    }
    public static  president getInstance()
    {
        return instance;//该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
    }
    public void getName()
    {
        System.out.println("我是美国总统：特朗普。");
    }
}
