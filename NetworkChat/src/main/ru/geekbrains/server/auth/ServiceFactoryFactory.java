package ru.geekbrains.server.auth;

public class ServiceFactoryFactory {

    public static AbstractServiceFactory createServiceFactory() {
        return new ServicceFactoryImpl();
    }
}