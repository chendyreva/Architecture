package ru.geekbrains.server;

public abstract class AbstractFactoryMethod {
    public void  runService() {
        getService().run();
    }

    protected abstract Runnable getService();
}