import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SingletonTest {

    @Test
    public void CheckIfTwoSingletonsAreTheSameObject() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        assertSame(instance1, instance2);
    }

    @Test()
    public void IsReflectionProof() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;

        try {
            Class<Singleton> sinClass = Singleton.class;
            Constructor<Singleton> cons = sinClass.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2 = cons.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ignored) {

        }

        assertNull(instance2);
    }

    @Test
    public void IsThreadSafe() throws InterruptedException {

        int threadsAmount = 100;
        Set<Singleton> singletonSet = new HashSet<>();

        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);

        IntStream.range(0, threadsAmount)
                .forEach(i -> executorService.execute(
                        () -> singletonSet.add(Singleton.getInstance())
                ));

        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1, singletonSet.size());
    }

    @Test
    public void SerializedIsTheSameObject() throws IOException, ClassNotFoundException {
        String filename = "threadsafe.bin";
        Singleton serializedSingleton = Singleton.getInstance();

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(serializedSingleton);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream(filename));
        Singleton deserializedSingleton = (Singleton) in.readObject();
        in.close();

        assertEquals(serializedSingleton, deserializedSingleton);
    }


    @Test
    public void SerializedIsTheSameObjectWithName() throws IOException, ClassNotFoundException {
        String filename = "threadsafe.bin";
        Singleton serializedSingleton = Singleton.getInstance();
        serializedSingleton.set_singletonName("Before serialization");

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(serializedSingleton);
        out.close();

        serializedSingleton.set_singletonName("After serialization");

        ObjectInput in = new ObjectInputStream(new FileInputStream(filename));
        Singleton deserializedSingleton = (Singleton) in.readObject();
        in.close();


        assertAll(
                () -> assertSame(serializedSingleton, deserializedSingleton),
                () -> assertEquals("Before serialization", serializedSingleton.get_singletonName())
        );


    }


}
