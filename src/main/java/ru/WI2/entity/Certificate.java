package ru.WI2.entity;

import javax.persistence.*;
import java.sql.Blob;

//@NamedQueries({
//        @NamedQuery(
//                name = "addCertificate",
//                query = "from Certificate c"
//        )
//})


@Entity
@Table
public class Certificate {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String company;

    @Column//(nullable = false)
    @Lob
    private Blob scan;

    public Certificate() {
    }

    public Certificate(String name, String company, Blob scan) {
        this.name = name;
        this.company = company;
        this.scan = scan;
    }

    public Certificate(int id, String name, String company, Blob scan) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.scan = scan;
    }

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Blob getScan() {
        return scan;
    }

    public void setScan(Blob scan) {
        this.scan = scan;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", scan=" + scan +
                '}';
    }
}
