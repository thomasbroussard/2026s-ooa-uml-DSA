package fr.epita.biostat.datamodel;

import java.util.Objects;

public class BiostatEntry {
    private String name;
    private String gender;
    private Integer age;
    private Integer height;
    private Integer weight;

    public BiostatEntry() {
    }

    public BiostatEntry(String name, String gender, Integer age, Integer height, Integer weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BiostatEntry{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BiostatEntry entry = (BiostatEntry) o;
        return Objects.equals(name, entry.name) && Objects.equals(gender, entry.gender) && Objects.equals(age, entry.age) && Objects.equals(height, entry.height) && Objects.equals(weight, entry.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, height, weight);
    }
}
