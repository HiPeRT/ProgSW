package OfRectanglesAndSquares;

public class SingletonClass {
    static private SingletonClass _obj = null;

    private SingletonClass(){}

    public static SingletonClass getInstance()
    {
        if(_obj == null)
            _obj = new SingletonClass();

        return _obj;
    }

    public void count()
    {
        this._counter ++;
    }
    private int _counter = 0;
}
