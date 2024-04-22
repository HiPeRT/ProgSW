package it.unimore.hipert.indinf.iotsemaphore.services;

public interface IMessageReceiver {
    void registerListener(IMessageListener messageListener);
    void start();
}
