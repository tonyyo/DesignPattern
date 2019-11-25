package 设计模式.十八_中介者模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */
import java.util.*;
public class SimpleMediatorPattern
{
    public static void main(String[] args)
    {
        SimpleColleague c1,c2;
        c1=new SimpleConcreteColleague1();
        c2=new SimpleConcreteColleague2();
        c1.send();
        System.out.println("-----------------");
        c2.send();
    }
}
//简单单例中介者
class SimpleMediator
{
    private static SimpleMediator smd=new SimpleMediator();
    private List<SimpleColleague> colleagues=new ArrayList<SimpleColleague>();
    private SimpleMediator(){}
    public static SimpleMediator getMedium()
    {    return(smd);   }
    public void register(SimpleColleague colleague)
    {
        if(!colleagues.contains(colleague))
        {
            colleagues.add(colleague);
        }
    }
    public void relay(SimpleColleague scl)
    {
        for(SimpleColleague ob:colleagues)
        {
            if(!ob.equals(scl))
            {
                ((SimpleColleague)ob).receive();
            }
        }
    }
}
//抽象同事类
interface SimpleColleague
{
    void receive();
    void send();
}
//具体同事类
class SimpleConcreteColleague1 implements SimpleColleague
{
    SimpleConcreteColleague1(){
        SimpleMediator smd=SimpleMediator.getMedium();   //  自动注册，所以在main函数中只需要发送请求就好
        smd.register(this);
    }
    public void receive()
    {    System.out.println("具体同事类1：收到请求。");    }
    public void send()
    {
        SimpleMediator smd=SimpleMediator.getMedium();
        System.out.println("具体同事类1：发出请求...");
        smd.relay(this); //请中介者转发
    }
}
//具体同事类
class SimpleConcreteColleague2 implements SimpleColleague
{
    SimpleConcreteColleague2(){
        SimpleMediator smd=SimpleMediator.getMedium();
        smd.register(this);
    }
    public void receive()
    {    System.out.println("具体同事类2：收到请求。");    }
    public void send()
    {
        SimpleMediator smd=SimpleMediator.getMedium();
        System.out.println("具体同事类2：发出请求...");
        smd.relay(this); //请中介者转发
    }
}