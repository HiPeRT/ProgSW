package it.unimore.hipert.indinf.iotsemaphore.services;

public interface IJsonParser<T> {
    T parseObject(byte[] payload);
}
