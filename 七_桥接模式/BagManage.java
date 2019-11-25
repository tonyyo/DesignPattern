package 设计模式.七_桥接模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

import java.awt.*;
import javax.swing.*;
public class BagManage
{
    public static void main(String[] args)
    {
        Color color;
        Bag bag;
        color= new Yellow();
        bag=new HandBag();
        bag.setColor(color);
        String name=bag.getName();
        show(name);
    }
    public static void show(String name)
    {
        System.out.println(name);
    }
}
//实现化角色：颜色
interface Color
{
    String getColor();
}
//具体实现化角色：黄色
class Yellow implements Color
{
    public String getColor()
    {
        return "yellow";
    }
}
//具体实现化角色：红色
class Red implements Color
{
    public String getColor()
    {
        return "red";
    }
}
//抽象化角色：包
abstract class Bag
{
    protected Color color;
    public void setColor(Color color)
    {
        this.color=color;
    }
    public abstract String getName();
}
//扩展抽象化角色：挎包
class HandBag extends Bag
{
    public String getName()
    {
        return color.getColor()+"HandBag";
    }
}
//扩展抽象化角色：钱包
class Wallet extends Bag
{
    public String getName()
    {
        return color.getColor()+"Wallet";
    }
}