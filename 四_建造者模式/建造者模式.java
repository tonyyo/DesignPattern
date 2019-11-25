package 设计模式.四_建造者模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

public class 建造者模式{
    public static void main(String[] args)
    {
        try
        {
            Decorator d;
            d= new ConcreteDecorator1();
            ProjectManager m=new ProjectManager(d);  //指挥家决定用哪一个具体装饰者进行装修
            Parlour p=m.decorate();   //该具体装饰者进行装修
            p.show();  //展示装修的客厅
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
//产品：客厅
class Parlour
{
    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发
    public void setWall(String wall)
    {
        this.wall=wall;
    }
    public void setTV(String TV)
    {
        this.TV=TV;
    }
    public void setSofa(String sofa)
    {
        this.sofa=sofa;
    }
    public void show()
    {
        System.out.println(wall+" "+TV+" "+sofa);
        System.out.print("装修完毕");
    }
}
//抽象建造者：装修工人，
//todo 建造者模式其实包含了简单工厂模式，相当于一个工厂生产两种工人，一种工人只有一种装修风格，可以抓为工厂模式，一个工厂生产一种工人
// 又因为单个工人的装修风格只能是一种，可以用抽象工厂，将工人的装修风格变为多种
// 总结来说，就是可以用多种工厂，生产能够装修风格多变的工人
abstract class Decorator
{
    //创建产品对象
    protected  Parlour product=new Parlour();
    public  abstract void buildWall();
    public  abstract void buildTV();
    public  abstract void buildSofa();
    //返回产品对象
    public  Parlour getResult()
    {
        return  product;
    }
}
//具体建造者：具体装修工人1
class ConcreteDecorator1  extends Decorator
{
    public void buildWall()
    {
        product.setWall("w1");
    }
    public void buildTV()
    {
        product.setTV("TV1");
    }
    public void buildSofa()
    {
        product.setSofa("sf1");
    }
}
//具体建造者：具体装修工人2
class ConcreteDecorator2 extends Decorator
{
    public void buildWall()
    {
        product.setWall("w2");
    }
    public void buildTV()
    {
        product.setTV("TV2");
    }
    public void buildSofa()
    {
        product.setSofa("sf2");
    }
}
//指挥者：项目经理
class ProjectManager
{
    private Decorator builder;
    public ProjectManager(Decorator builder)
    {
        this.builder=builder;
    }
    //产品构建与组装方法
    public Parlour decorate()
    {
        builder.buildWall();
        builder.buildTV();
        builder.buildSofa();
        return builder.getResult();
    }
}
