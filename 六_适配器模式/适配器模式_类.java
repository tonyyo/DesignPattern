package 设计模式.六_适配器模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

//目标接口
interface Target
{
    public void request();
}
//适配者接口
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("适配者接口的业务代码被调用！");
    }
}
//类适配器类
class ClassAdapter extends Adaptee implements Target
{
    public void request()
    {
        System.out.println("目标接口中request方法被重写，重写为调用适配者接口代码");
        specificRequest();  //利用继承调用类中的方法，所以叫类适配器模式
    }
}
//客户端代码
public class 适配器模式_类
{
    public static void main(String[] args)
    {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
