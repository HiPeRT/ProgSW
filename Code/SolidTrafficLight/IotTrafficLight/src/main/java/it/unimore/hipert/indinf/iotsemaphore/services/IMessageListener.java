package it.unimore.hipert.indinf.iotsemaphore.services;

import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreConfigurationMessage;

public interface IMessageListener {

    void onMessageReceived(SemaphoreConfigurationMessage message);
}
