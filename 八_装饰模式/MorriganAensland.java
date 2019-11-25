package 设计模式.八_装饰模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

import java.awt.*;
import javax.swing.*;
public class MorriganAensland
{
    public static void main(String[] args)
    {
        Morrigan m0=new original();
        m0.display();
        Morrigan m1=new Succubus(m0);  //因为Morrigan是Changer的父接口，Succubus是Changer的子类，所以Succubus类型也是Morrigan的。
        m1.display();
        Morrigan m2=new Girl(m0);
        m2.display();
    }
}
//抽象构件角色：莫莉卡
interface  Morrigan
{
    public void display();
}
//具体构件角色：原身
class original extends JFrame implements Morrigan
{
    private static final long serialVersionUID = 1L;
    private String t="Morrigan0.jpg";
    public original()
    {
        super("《恶魔战士》中的莫莉卡·安斯兰");
    }
    public void setImage(String t)
    {
        this.t=t;
    }
    public void display()
    {
        this.setLayout(new FlowLayout());
        JLabel l1=new JLabel(new ImageIcon("/home/vincent/github/algorithm_practice/src/设计模式/八_装饰模式/"+t));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
//抽象装饰角色：变形
class Changer implements Morrigan {  //该抽象类的作用是能够实现多种具体装饰角色，没有该抽象类的话，如果装饰要换，就得修改源代码，有了他之后，只需增加一个具体装饰角色就好
    Morrigan m;                        //并且该抽象类使被装饰类和装饰类分离，这样，装饰去掉也不会影响被装饰类。
    public Changer(Morrigan m)
    {
        this.m=m;
    }
    public void display()
    {
        m.display();
    }
}
//具体装饰角色：女妖
class Succubus extends Changer
{
    public Succubus(Morrigan m)
    {
        super(m);
    }
    public void display()
    {
        setChanger();  //   就是在display方法加了点东西，不用修改源代码
        super.display();
    }
    public void setChanger()
    {
        ((original) super.m).setImage("Morrigan1.jpg");
    }
}
//具体装饰角色：少女
class Girl extends Changer
{
    public Girl(Morrigan m)
    {
        super(m);
    }
    public void display()
    {
        setChanger();
        super.display();
    }
    public void setChanger()
    {
        ((original) super.m).setImage("Morrigan2.jpg");
    }
}