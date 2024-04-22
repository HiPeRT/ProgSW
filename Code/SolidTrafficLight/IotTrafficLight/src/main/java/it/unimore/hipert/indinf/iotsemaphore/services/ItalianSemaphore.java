package it.unimore.hipert.indinf.iotsemaphore.services;

import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreColors;

/**
 * The FSM for a "normal" Italian semaphore: Red -> Yellow -> Green
 */
public class ItalianSemaphore implements ISemaphoreFsm {

    private SemaphoreColors currentState;
    private int counter = 0;

    private static int TIMING_RED = 5;
    private static int TIMING_YELLOW = 1;
    private static int TIMING_GREEN = 4;

    private ILightsController lightsController;

    public ItalianSemaphore(ILightsController lightsController) {
        this.currentState = SemaphoreColors.RED;
        this.counter = TIMING_RED;
        this.lightsController = lightsController;
    }

    private void mfn() {
        lightsController.changeLightColors(this.currentState);
    }

    private void sfn() {
        // Time to change our color
        switch (this.currentState) {
            case RED:
                this.currentState = SemaphoreColors.GREEN;
                this.counter = this.TIMING_GREEN;
                break;
            case GREEN:
                this.currentState = SemaphoreColors.YELLOW;
                this.counter = this.TIMING_YELLOW;
                break;
            case YELLOW:
                this.currentState = SemaphoreColors.RED;
                this.counter = this.TIMING_RED;
                break;
        }

    }

    /**
     * MFN and SFN are together here
     */
    @Override
    public void maybeChangeState() {

        this.counter--;

        if(this.counter == 0) {
            sfn();
            mfn(); // This makes it a Mealy machine: this is only triggered at change of status
        }
        //mfn(); // Put it here to implement a Moore machine, that fires output at every state

    }
}
