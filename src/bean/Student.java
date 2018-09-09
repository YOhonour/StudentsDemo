package bean;

import java.util.Date;

public class Student {
    private int id;                 // 在数据库中的ID
    private int studentNumber;     // 学号，跟ID区分开为了方便数据库操作
    private String name;             // 姓名
    private int age;                 // 年龄
    private int sex;               // 性别
    private int major;           // 专业
    /*
    专业代码1-4，分别指通信、电信、信息、广电
     */

    public int getMajor() {
        return major;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getSex() {
        return sex;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }
}

