package ru.WI2.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "getAllGrades",
                query = "FROM Grade "
        ),
        @NamedQuery(
                name = "getGradeById",
                query = "FROM Grade g WHERE g.id = :id"
        )
})

@Entity
@Table
public class Grade {
    @Id
    private int id;

    @Column
    private String name;

    public Grade() {
    }

//    public Grade(int id, String name) {
//        this.id = id;
//        this.name = name;
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

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
