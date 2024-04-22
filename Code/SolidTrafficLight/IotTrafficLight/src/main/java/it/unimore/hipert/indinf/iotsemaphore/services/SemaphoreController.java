package it.unimore.hipert.indinf.iotsemaphore.services;

import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreConfigurationMessage;
import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreMode;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * This class dispatches among the different FSMs of the Semaphore
 */
public class SemaphoreController implements IMessageListener, ISemaphoreController{

    private final Dictionary<SemaphoreMode, ISemaphoreFsm> semaphoreFsms;
    private SemaphoreMode currentMode;

    public SemaphoreController(IMessageReceiver messageReceiver, ILightsController lightsController) {
        // Register to listen to messages
        messageReceiver.registerListener(this);

        // Initialize vars
        currentMode = SemaphoreMode.BLINKING_YELLOW;

        // Register FSMs
        semaphoreFsms = new Hashtable<SemaphoreMode, ISemaphoreFsm>();
        semaphoreFsms.put(SemaphoreMode.ITALIAN_LIGHTS, new ItalianSemaphore(lightsController));
        semaphoreFsms.put(SemaphoreMode.BLINKING_YELLOW, new BlinkingYellowSemaphore(lightsController));
    }

    @Override
    public void onMessageReceived(SemaphoreConfigurationMessage message) {
        switch(message.getFsm()) {
            case 1:
                this.currentMode = SemaphoreMode.ITALIAN_LIGHTS;
                break;
            case 2:
                this.currentMode = SemaphoreMode.BLINKING_YELLOW;
                break;
            default:
                // TODO unknown, do something
                break;
        }
    }

    @Override
    public void tick() {
        this.semaphoreFsms.get(this.currentMode).maybeChangeState();
    }
}
