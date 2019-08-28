package ru.geekbrains.server.auth;

 class ServiceFactoryImpl implements AbstractServiceFactory {

    @Override
    public static AuthService createAuthService() {
        return new AuthServiceImpl(createAuthService());
    }
}