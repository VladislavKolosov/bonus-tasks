package studentsystem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> studentList = new ArrayList<>() {{
        add(new Student(1, "Vlad", "kolosov.vd.456@bk.ru", 22, "male"));
        add(new Student(2, "Polina", "pol.pl.123@gmail.com", 19, "female"));
        add(new Student(3, "Denis", "denis.ds.893@yandex.ru", 22, "male"));
    }};

    @Deprecated
    public void addStudents(Student student) {
        studentList.add(student);
    }

    public void displayStudents() {
        for (Student student : studentList) {
            Class<?> emploeeClass = student.getClass();
            Field[] fields = emploeeClass.getDeclaredFields();
            displayFields(student, fields);
        }
    }

    private void displayFields(Student student, Field[] fields) {
        for (Field field : fields) {
            StudentInfo annotation = field.getAnnotation(StudentInfo.class);
            field.setAccessible(true);

            String description = (annotation != null) ? annotation.value() : "Описания нет";
            try {
                System.out.println("Поле - " + field.getName() +
                        "(" + description + ")" +
                        " - " + field.get(student));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("_________");
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
