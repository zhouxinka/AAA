package com.example.entity;

/**
 * @author zhoupeng
 * @create time 2021-05-07-16:51
 */
public class Teacher extends DataEntity<Teacher>{
    private Integer id;
    private String name;
    private int age;
    private String gender;
    private Encrypt phone;

    public Teacher() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Encrypt getPhone() {
        return phone;
    }

    public void setPhone(Encrypt phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                ", remarks='" + remarks + '\'' +
                ", createBy=" + createBy +
                ", createDate=" + createDate +
                ", updateBy=" + updateBy +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
