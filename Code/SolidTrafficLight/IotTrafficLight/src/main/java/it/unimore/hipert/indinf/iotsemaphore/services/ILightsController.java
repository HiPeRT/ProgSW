package it.unimore.hipert.indinf.iotsemaphore.services;

import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreColors;

public interface ILightsController {
    void changeLightColors(SemaphoreColors currentState);
}
