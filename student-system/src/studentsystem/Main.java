package studentsystem;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        studentManagementSystem.displayStudents();

        Class<?> stmClass = studentManagementSystem.getClass();
        Method method;
        try {
            method = stmClass.getMethod("addStudents", Student.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        if (method.isAnnotationPresent(Deprecated.class)){
            System.out.println("Метод - " + method.getName() + " помечен аннотацией @Deprecated ");
        }
    }
}
