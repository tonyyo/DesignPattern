package 设计模式.五_代理模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

import javax.swing.*;
public class 代理模式{
    public static void main(String[] args)
    {
        SgProxy proxy=new SgProxy();
        proxy.display();
    }
}
//抽象主题：特产
interface Specialty
{
    void display();
}
//真实主题：婺源特产
class WySpecialty extends JFrame implements Specialty
{

    public void display()
    {
        System.out.println("开始售卖婺源特产");
    }
}
//代理：韶关代理
class SgProxy implements Specialty
{
    private WySpecialty realSubject=new WySpecialty();
    public void display()
    {
        preRequest();
        realSubject.display();
        postRequest();
    }
    public void preRequest()
    {
        System.out.println("韶关代理婺源特产开始前的准备工作。");
    }
    public void postRequest()
    {
        System.out.println("韶关代理婺源特产结束后的收尾工作。");
    }
}
