package ru.WI2.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "getEmployeeById",
                query = "FROM Employee e WHERE e.id = :id"
        )
})

@Entity
@Table
public class Employee {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String sname;

    public Employee() {
    }

//    public Employee(int id, String name, String sname) {
//        this.id = id;
//        this.name = name;
//        this.sname = sname;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
