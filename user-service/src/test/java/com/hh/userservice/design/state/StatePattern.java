package com.hh.userservice.design.state;

/**
 * @ClassName StatePattern
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/6/24 14:18
 * @Version 1.0
 **/
public class StatePattern {

    public static void main(String[] args) {
        Context context = new Context();
        context.state();
        context.state();
    }

}

class Context {
    private AbstractDevice abstractDevice;

    public Context() {
        this.abstractDevice = new Device1();
    }

    public void setAbstractDevice(AbstractDevice abstractDevice) {
        this.abstractDevice = abstractDevice;
    }

    public void state() {
        abstractDevice.state(this);
    }
}

interface AbstractDevice {
    void state(Context context);
}

class Device1 implements AbstractDevice {

    @Override
    public void state(Context context) {
        System.out.println("device1");
        context.setAbstractDevice(new Device2());
    }

}

class Device2 implements AbstractDevice {

    @Override
    public void state(Context context) {
        System.out.println("device2");
        context.setAbstractDevice(new Device1());
    }

}