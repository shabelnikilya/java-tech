package org.example.loader;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ClassLoader classLoader = new MyClassLoader();
        Runnable runnable = new TestRunnable();
        runnable.run();
        System.out.println(runnable.getClass().getClassLoader());
        Class<?> loadedClass = classLoader.loadClass("TestRunnable");
        Runnable loadedRunnable = loadedClass.asSubclass(Runnable.class).getConstructor().newInstance();
        loadedRunnable.run();
        System.out.println(loadedRunnable.getClass().getClassLoader());
    }
}
