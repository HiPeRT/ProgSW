package it.unimore.hipert.indinf.iotsemaphore.services;

import com.google.gson.Gson;

public class GsonParser<T> implements IJsonParser<T> {

    final Class<T> typeParameterClass;

    public GsonParser(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public T parseObject(byte[] payload) {
        try {

            Gson gson = new Gson();
            return gson.fromJson(new String(payload), typeParameterClass);

        }catch(Exception e) {
            return null;
        }
    }
}
