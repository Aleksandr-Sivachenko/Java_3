import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        start(TestCase.class);
    }

    public static void start(Class<?> className) {
        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;
        Map<Integer, Method> map = new TreeMap<>();

        for (Method method : className.getDeclaredMethods()) {
            if (method.getAnnotation(Annotation1.BeforeSuite.class) != null) {
                map.put(MIN_PRIORITY - 1, method);
            }
            if (method.getAnnotation(Annotation2.AfterSuite.class) != null) {
                map.put(MAX_PRIORITY + 1, method);
            }
            if (method.getAnnotation(Annotation3.Test.class) != null) {
                Annotation3.Test test = method.getAnnotation(Annotation3.Test.class);
                map.put(test.priority(), method);
            }
        }

        System.out.println("\nMap for "+className.getSimpleName()+":");
        for (Integer key : map.keySet()) {
            System.out.println("priority:" + key + " " + map.get(key).getName());
        }
        System.out.println("\nReflections for "+className.getSimpleName()+":");

        try {
            Object testCase = className.newInstance();
            for (Integer key : map.keySet()) {
                map.get(key).invoke(testCase);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
