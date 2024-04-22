package it.unimore.hipert.indinf.iotsemaphore.process;

import it.unimore.hipert.indinf.iotsemaphore.services.ISemaphoreController;

/**
 * This class implements a thread that "ticks" every second (hardcoded) and notifies the semaphore controller
 */
public class SemaphoreFsmThread implements Runnable{

    private ISemaphoreController semaphoreController;
    private int tickInSeconds = 1;

    public SemaphoreFsmThread(ISemaphoreController semaphoreController) {
        this.semaphoreController = semaphoreController;
    }

    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep(tickInSeconds * 1000);
            } catch (InterruptedException e) {
                //TODO what should we do with this?
                e.printStackTrace();
            }
            semaphoreController.tick();
        }
    }
}
