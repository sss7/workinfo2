package ru.WI2.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "readAllEmployees",
                query = "FROM Employee"
        ),
        @NamedQuery(
                name = "readEmployeeById",
                query = "FROM Employee e WHERE e.id = :id"
        )
})

@Entity
@Table
public class Employee {
    @Id
//    @JsonIgnore
//    @JsonProperty("id")
    private int id;

    @Column
    private String name;

    @Column
    private String sname;

    @ManyToOne
    private Grade grade;

    @ManyToOne //@OneToOne
    private Certificate certificate;

    public Employee() {
    }

//    public Employee(int id, String name, String sname, Grade grade, Certificate certificate) {
//        this.id = id;
//        this.name = name;
//        this.sname = sname;
//        this.grade = grade;
//        this.certificate = certificate;
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sname='" + sname + '\'' +
                ", grade=" + grade +
                ", certificate=" + certificate +
                '}';
    }
}
