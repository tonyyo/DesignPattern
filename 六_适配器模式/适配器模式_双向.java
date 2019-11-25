package 设计模式.六_适配器模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

//客户端代码
public class 适配器模式_双向{
    public static void main(String[] args)
    {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdaptee adaptee=new AdapteeRealize();    //提供适配者类
        TwoWayTarget target=new TwoWayAdapter(adaptee);  //实现适配器
        target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        target=new TargetRealize();    //提供适配者类
        adaptee=new TwoWayAdapter(target);
        adaptee.specificRequest();
    }
}
//目标接口/适配者接口
interface TwoWayTarget
{
    public void request();
}
//适配者接口/目标接口
interface TwoWayAdaptee
{
    public void specificRequest();
}
//目标实现/适配者实现
class TargetRealize implements TwoWayTarget
{
    public void request()
    {
        System.out.println("目标代码被调用！");
    }
}
//适配者实现/目标实现
class AdapteeRealize implements TwoWayAdaptee
{
    public void specificRequest()
    {
        System.out.println("适配者代码被调用！");
    }
}

// TODO: 19-11-21 一个适配者类，一个目标接口，适配器类实现目标接口，以调用适配者类中的方法的形式重写目标接口的方法，这样就实现了适配者模式 ，
//  双向适配器模式的适配器类实现了两个目标接口，通过调用对方适配者类的方法的形式重写自己目标接口。
//  双向适配器比较巧的地方在于实现一个目标接口后，就变成了一个适配者类。所以两个接口就有两个适配者类，交叉调用，就能实现双向。
//双向适配器
class TwoWayAdapter  implements TwoWayTarget,TwoWayAdaptee
{
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;
    public TwoWayAdapter(TwoWayTarget target)
    {
        this.target=target;
    }
    public TwoWayAdapter(TwoWayAdaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    public void request()
    {
        adaptee.specificRequest();  //重写Target，调用Adapt
    }
    public void specificRequest()
    {
        target.request();           //重写Adapt，调用Target
    }
}

