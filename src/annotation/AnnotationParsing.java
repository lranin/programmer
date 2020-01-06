package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationParsing {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("annotation.AnnotationTestClass");
//        getClassAnnotationByReflect(clazz);
//        getAllMethodByReflect(clazz);
        getPublicMethodByReflect(clazz);
//        getAnnotationByReflect(clazz);
    }

    private static void getClassAnnotationByReflect(Class clazz) {
        if (clazz.isAnnotationPresent(FirstAnnotation.class)) {
            FirstAnnotation firstAnnotation = (FirstAnnotation) clazz.getAnnotation(FirstAnnotation.class);
            try {
                Field testLight = firstAnnotation.getClass().getField("annotationName");
                if (testLight.getType().getName().equals(String.class.getName())) {
                    Object o = testLight.get(firstAnnotation);
                    System.out.println(o.toString());
                }
                Method message = firstAnnotation.getClass().getMethod("desc");
                System.out.println(message.invoke(firstAnnotation).toString());
//                System.out.printf(filedClassName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (clazz.isAnnotationPresent(SecondAnnotation.class)) {
            SecondAnnotation secondAnnotation = (SecondAnnotation) clazz.getAnnotation(SecondAnnotation.class);
            try {
                Field testLight = secondAnnotation.getClass().getField("annotationName");
                if (testLight.getType().getName().equals(String.class.getName())) {
                    Object o = testLight.get(secondAnnotation);
                    System.out.println(o.toString());
                }
                Method message = secondAnnotation.getClass().getMethod("desc");
                System.out.println(message.invoke(secondAnnotation).toString());
//                System.out.printf(filedClassName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void getPublicMethodByReflect(Class clazz) {
        Arrays.stream(clazz.getMethods()).forEach(method -> {
            try {
                MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
                if (methodAnnotation != null) {
                    System.out.println(methodAnnotation.desc());
                    Method annotationMethod = methodAnnotation.getClass().getMethod("desc");
                    System.out.println(annotationMethod.invoke(methodAnnotation).toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(method.getName());
        });
    }

    private static void getAllMethodByReflect(Class clazz) {
        Arrays.stream(clazz.getDeclaredMethods()).forEach(method -> {
            System.out.println(method.getName());
        });
    }

    private static void getAnnotationByReflect(Class clazz) {
        Arrays.stream(clazz.getAnnotations()).forEach(annotation -> {
            System.out.println(annotation.getClass().getName());
        });

    }
}
