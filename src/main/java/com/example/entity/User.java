package com.example.entity;

/**
 * @author zhoupeng
 * @create time 2021-04-14-10:07
 */
public class User extends DataEntity<User> {
    private Integer id;
    private String name;
    private int age;
    private String gender;

    public User() {
        super();
        System.out.println("User类的无参构造方法");
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createBy=" + createBy +
                ", createDate=" + createDate +
                ", updateBy=" + updateBy +
                ", updateDate=" + updateDate +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
