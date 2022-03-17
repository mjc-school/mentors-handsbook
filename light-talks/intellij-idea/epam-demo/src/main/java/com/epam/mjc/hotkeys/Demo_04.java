package com.epam.mjc.hotkeys;

import java.util.Objects;

public class Demo_04 {

    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public Demo_04 setId(int id) {
        this.id = id;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Demo_04 setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Demo_04 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo_04 demo_04 = (Demo_04) o;
        return id == demo_04.id && age == demo_04.age && Objects.equals(name, demo_04.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }

    @Override
    public String toString() {
        return "Demo_04{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
