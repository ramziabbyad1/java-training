package generic;

public class Singleton<T>{

    public Singleton<T> getInstance() {
        if (instance == null)
            instance = new Singleton<T>();

        return instance;
    }

    private Singleton<T> instance = null;
}
