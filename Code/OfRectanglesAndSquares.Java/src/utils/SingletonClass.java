package utils;

public class SingletonClass {
    static private SingletonClass _obj = null;
    private int _counter = 0;

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
    public int getCount() {
    	return this._counter;
    }
}
