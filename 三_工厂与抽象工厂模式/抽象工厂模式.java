package 设计模式.三_工厂与抽象工厂模式;/*
 * @Author:vincent
 * @Describe:
 * @Modify By:
 *
 * */

public class 抽象工厂模式{
    public static void main(String[] args)
    {
        try
        {
            Farm f;
            Animal a;
            Plant p;
            f=new SGfarm();
            a=f.newAnimal();
            p=f.newPlant();
            a.show();
            p.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
//抽象产品：动物类
interface Animal
{
    public void show();
}
//具体产品：马类
class Horse implements Animal
{
    public void show()
    {
        System.out.println("培养出一匹马");
    }
}
//具体产品：牛类
class Cattle implements Animal
{
    public void show()
    {
        System.out.println("培养出一头牛");
    }
}
//抽象产品：植物类
interface Plant
{
    public void show();
}
//具体产品：水果类
class Fruitage implements Plant
{
    public void show()
    {
        System.out.println("种水果");
    }
}
//具体产品：蔬菜类
class Vegetables implements Plant
{
    public void show()
    {
        System.out.println("种蔬菜");
    }
}
//抽象工厂：农场类
interface Farm
{
    public Animal newAnimal();
    public Plant newPlant();
}
//具体工厂：韶关农场类
class SGfarm implements Farm
{
    public Animal newAnimal()
    {
        System.out.println("韶关农场可以培养动物！");
        return new Cattle();
    }
    public Plant newPlant()
    {
        System.out.println("韶关农场可以种植植物！");
        return new Vegetables();
    }
}
//具体工厂：上饶农场类
class SRfarm implements Farm
{
    public Animal newAnimal()
    {
        System.out.println("上饶农场可以培养动物！");
        return new Horse();
    }
    public Plant newPlant()
    {
        System.out.println("上饶农场可以种植植物！");
        return new Fruitage();
    }
}