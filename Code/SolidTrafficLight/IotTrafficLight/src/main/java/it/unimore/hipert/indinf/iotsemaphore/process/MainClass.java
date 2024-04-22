package it.unimore.hipert.indinf.iotsemaphore.process;

import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreConfigurationMessage;
import it.unimore.hipert.indinf.iotsemaphore.services.*;

public class MainClass {
    public static void main(String[] args) {
        IConfiguration config = new StaticConfiguration();

        IJsonParser<SemaphoreConfigurationMessage> jsonParser = new GsonParser<>(SemaphoreConfigurationMessage.class);

        // Services
        ILightsController lightsController;

        //lightsController= new RaspberryPiGpioController();
        lightsController = new FakeLightsController();

        IMessageReceiver mqttReceiver = new MqttReceiver(config, jsonParser);
        ISemaphoreController semaphoreController = new SemaphoreController(mqttReceiver, lightsController);
        Runnable semaphoreFsmThread = new SemaphoreFsmThread(semaphoreController);

        // Start services and threads
        mqttReceiver.start();
        semaphoreFsmThread.run();

    }
}
