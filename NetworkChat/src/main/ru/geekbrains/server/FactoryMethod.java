package ru.geekbrains.server;

public class FactoryMethod extends AbsctractFactoryMethod {

    @Override
    protected  Runnable getService() {
        return () -> System.out.println("Factory method implemenation!")
    }
}