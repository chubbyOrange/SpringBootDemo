package com.example.ReflectDemo;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Properties;

@SuppressWarnings("all")
public class ReflectDemo {
    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
            NoSuchMethodException, InstantiationException, InvocationTargetException, IOException,
            ClassNotFoundException {
        Class<Student> studentClass = Student.class;

        // * Field[] getDeclaredFields(): 获取所有成员变量，不考虑修饰符
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Student student = new Student();

        // * Field getDeclaredField(String name)
        Field name = studentClass.getDeclaredField("name");
        // * 忽略访问权限修饰符的安全检查 ጿ ኈ ቼ ዽ ጿ
        name.setAccessible(true);
        Object value = name.get(student);
        System.out.println(value);

        // * Constructor<T> getConstructor(Class<?>... parameterTypes)
        Constructor<Student> constructor = studentClass.getConstructor(String.class, String.class, LocalDate.class);
        // System.out.println(constructor);
        // * 创建对象
        Object studentObject = constructor.newInstance("Mason", "mason.jing@uwaterloo.ca", LocalDate.of(2001, 11, 21));
        // System.out.println(studentObject);

        Constructor<Student> constructor1 = studentClass.getConstructor();
        // System.out.println(constructor1);
        // * 创建对象
        Object studentObject1 = constructor1.newInstance();
        // System.out.println(studentObject1);
        // Object studentObject2 = studentClass.newInstance();
        // System.out.println(studentObject2);

        // * Method getMethod(String name, Class<?>... parameterTypes)
        Method eatMethod = studentClass.getMethod("eat");
        eatMethod.invoke(student);

        Method eatMethod1 = studentClass.getMethod("eat", String.class);
        eatMethod1.invoke(student, "noodle");

        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            // System.out.println(method);
            String methodName = method.getName();
            System.out.print(methodName + " ");
        }
        System.out.print("\n");

        // * ᕕ(ᐛ)ᕗ 变身!
        // * 1.创建Properties对象
        Properties pro = new Properties();

        // * 2.加载配置文件，转换为一个集合
        // ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        // InputStream resourceAsStream =
        // classLoader.getResourceAsStream("pro.properties");
        // pro.load(resourceAsStream);
        FileReader fileReader = new FileReader(
                "E:\\Spring Boot Codes\\demo\\src\\main\\java\\pro.properties");
        pro.load(fileReader);

        // * 3.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        // * 4.加载该类进内存
        Class<?> aClass = Class.forName(className);

        // * 5.创建对象
        // Object newInstance = aClass.newInstance();
        Constructor<?> ctor = studentClass.getConstructor();
        Object object = ctor.newInstance();

        // * 6.获取方法对象
        Method aMethod = aClass.getMethod(methodName);

        // * 7.执行方法
        aMethod.invoke(object);
    }
}
