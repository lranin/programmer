package annotation;

@FirstAnnotation(desc = "方法注解")
@SecondAnnotation(desc = "第二个方法注解")
public class AnnotationTestClass {
    private String name;

    private void thisIsPrivateMethod() {
        System.out.printf("this is a private method");
    }

    @MethodAnnotation(desc = "public方法的注解")
    public void thisIsPublicMethod() {
        System.out.printf("this is a public method");

    }

    protected void thisIsProtectedMethod() {
        System.out.printf("this is a protected method");

    }
}
