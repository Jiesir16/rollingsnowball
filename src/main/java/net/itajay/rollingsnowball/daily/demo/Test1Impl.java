package net.itajay.rollingsnowball.daily.demo;

public class Test1Impl extends Test1{

    public Test1Impl() {
    }

    @Override
    void sayHello() {
        super.exec();
        System.out.println("hello");
    }

    @Override
    public void exec() {
        super.exec();
    }
}
