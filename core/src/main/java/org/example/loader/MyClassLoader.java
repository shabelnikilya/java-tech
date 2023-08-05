package org.example.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class MyClassLoader extends ClassLoader {

    private final static String NAME_LOAD_CLASS = "TestRunnable";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        var clazz = TestRunnable.class;
        System.out.println(clazz.getClassLoader());
        if (NAME_LOAD_CLASS.equals(name)) {
            try (InputStream input = clazz.getResourceAsStream("TestRunnable.class")) {
                byte[] classData = Objects.requireNonNull(input).readAllBytes();
                return defineClass(clazz.getName(), classData, 0, classData.length);
            } catch (IOException e) {
                throw new ClassNotFoundException();
            }
        }

        return super.loadClass(name);
    }
}
