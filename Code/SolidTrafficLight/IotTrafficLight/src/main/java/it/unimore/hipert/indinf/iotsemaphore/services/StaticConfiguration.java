package it.unimore.hipert.indinf.iotsemaphore.services;

public class StaticConfiguration implements IConfiguration{
    @Override
    public String getMqttBrokerAddress() {
        return "155.185.228.19";
    }

    @Override
    public int getMqttBrokerPort() {
        return 7883;
    }

    @Override
    public String getMqttUsername() {
        return "pburgio";
    }

    @Override
    public String getMqttPassword() {
        return "zkcqjqrv";
    }

    @Override
    public String getMqttBasicTopic() {
        return "/iot/user/pburgio/";
    }
}
