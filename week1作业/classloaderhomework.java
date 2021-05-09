package Week01.HomeWork;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class classloaderhomework extends ClassLoader{

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> helloClass = new classloaderhomework().findClass("Hello");
        Object helloInstance = helloClass.newInstance();
        Method[] methods = helloClass.getMethods();
        for(Method method:methods) {
            if(method.getName().equals("hello")) {
                method.invoke(helloInstance) ;
            }
        }

    }

    @Override
    protected Class<?> findClass(String name) {
        InputStream resource = classloaderhomework.class.getResourceAsStream("/Hello.xlass");
        int length = 0;
        try {
            length = resource.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] b = new byte[length] ;
        try {
            resource.read(b) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<length;i++) {
            b[i] = (byte) (255 - b[i]);
        }
        return defineClass(name,b,0,length) ;
    }
}
