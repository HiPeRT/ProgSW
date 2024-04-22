package it.unimore.hipert.indinf.iotsemaphore.services;

import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreColors;

/**
 * The FSM for a blinking yellow semaphore. Its timings are hardcoded
 */
public class BlinkingYellowSemaphore implements ISemaphoreFsm {
    private final ILightsController lightsController;
    private SemaphoreColors currentColor;
    private static int BLINKING_TIME = 1;
    private int counter = 0;

    public BlinkingYellowSemaphore(ILightsController lightsController) {
        this.currentColor = SemaphoreColors.YELLOW;
        this.counter = BLINKING_TIME;
        this.lightsController = lightsController;
    }

    @Override
    public void maybeChangeState() {

        this.counter --;
        if(this.counter == 0) {
            switch (this.currentColor) {
                case YELLOW:
                    this.currentColor = SemaphoreColors.OFF;
                    break;
                case OFF:
                    this.currentColor = SemaphoreColors.YELLOW;
                    break;
            }
            // Reset counter
            this.counter = BLINKING_TIME;

            // Mealy: call Mfn (no private function here)
            this.lightsController.changeLightColors(this.currentColor);
        }

    }
}
