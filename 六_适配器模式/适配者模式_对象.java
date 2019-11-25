package 设计模式.六_适配器模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */
//目标接口
interface target
{
    public void request();
}
//适配者接口
class adptee
{
    public void specificRequest()
    {
        System.out.println("适配者接口的业务代码被调用！");
    }
}

//对象适配器类
class ObjectAdapter implements Target
{
    private adptee adaptee;
    public ObjectAdapter(adptee adaptee)
    {
        this.adaptee=adaptee;
    }
    public void request()
    {
        adaptee.specificRequest();  //实例化对象，用对象调用方法，所以叫对象适配器模式
    }
}
//客户端代码
public class 适配者模式_对象{
    public static void main(String[] args)
    {
        System.out.println("对象适配器模式测试：");
        adptee adaptee = new adptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
