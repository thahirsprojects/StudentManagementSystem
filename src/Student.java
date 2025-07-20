public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private String batch;
    static int idCounter = 0;

    public Student(String name, int age, String course, String batch) {
        this.id = ++idCounter;
        this.name = name;
        this.age = age;
        this.course = course;
        this.batch = batch;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", batch='" + batch + '\'' +
                ']';
    }
}
