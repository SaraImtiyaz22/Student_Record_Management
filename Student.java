public class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    public Student(int rollNo, String name, int age, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and Setters

public int getRollNo() { return rollNo; }
public String getName() { return name; }
public int getAge() { return age; }
public String getCourse() { return course; }

public void setRollNo(int rollNo) { this.rollNo = rollNo; }
public void setName(String name) { this.name = name; }
public void setAge(int age) { this.age = age; }
public void setRCourse(String course) { this.course = course; }

}
