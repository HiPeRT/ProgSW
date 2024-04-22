package it.unimore.hipert.indinf.iotsemaphore.services;

import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreColors;

/**
 * Use this during development on other computers
 */
public class FakeLightsController implements ILightsController {
    @Override
    public void changeLightColors(SemaphoreColors color) {
        System.out.println("Now lights are " + color);
    }
}
