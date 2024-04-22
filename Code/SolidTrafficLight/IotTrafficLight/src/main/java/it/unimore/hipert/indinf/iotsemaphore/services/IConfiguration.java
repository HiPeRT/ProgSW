package it.unimore.hipert.indinf.iotsemaphore.services;

public interface IConfiguration {

    String getMqttBrokerAddress();
    int getMqttBrokerPort();
    String getMqttUsername();
    String getMqttPassword();
    String getMqttBasicTopic();
}
