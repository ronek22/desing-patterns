import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable {
    private volatile static Singleton instance;
    private String _name;

    private Singleton() {
        if (instance != null) {
            throw new RuntimeException(); // Reflection proof
        }
    }

    public static Singleton getInstance() { // DCL
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    public String get_singletonName() {
        return _name;
    }

    public void set_singletonName(String _singletonName) {
        this._name = _singletonName;
    }

    private Object readResolve() throws ObjectStreamException {
        if(instance == null)
            instance = this;
        instance.set_singletonName(this._name);
        return instance;
    }



}
