package it.unimore.hipert.indinf.iotsemaphore.services;

import com.pi4j.io.gpio.*;
import it.unimore.hipert.indinf.iotsemaphore.model.SemaphoreColors;

public class RaspberryPiGpioController implements ILightsController{

    final GpioController gpio;
    final GpioPinDigitalOutput redPin;
    final GpioPinDigitalOutput yellowPin;
    final GpioPinDigitalOutput greenPin;

    public RaspberryPiGpioController() {
        this.gpio = GpioFactory.getInstance();
        this.redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
        this.yellowPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.HIGH);
        this.greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.HIGH);

        // set shutdown state for this pin
        redPin.setShutdownOptions(true, PinState.LOW);
        yellowPin.setShutdownOptions(true, PinState.LOW);
        greenPin.setShutdownOptions(true, PinState.LOW);
    }
    @Override
    public void changeLightColors(SemaphoreColors color) {

        switch (color) {
            case OFF:
                this.redPin.setState(PinState.LOW);
                this.yellowPin.setState(PinState.LOW);
                this.greenPin.setState(PinState.LOW);
                break;
            case GREEN:
                this.redPin.setState(PinState.LOW);
                this.yellowPin.setState(PinState.LOW);
                this.greenPin.setState(PinState.HIGH);
                break;
            case YELLOW:
                this.redPin.setState(PinState.LOW);
                this.yellowPin.setState(PinState.HIGH);
                this.greenPin.setState(PinState.LOW);
                break;
            case RED:
                this.redPin.setState(PinState.HIGH);
                this.yellowPin.setState(PinState.LOW);
                this.greenPin.setState(PinState.LOW);
                break;

            // Turn all pins on to notify that it's not supported
            default:
                this.redPin.setState(PinState.HIGH);
                this.yellowPin.setState(PinState.HIGH);
                this.greenPin.setState(PinState.HIGH);
                break;
        }
    }
}
