package ru.WI2.service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.WI2.entity.Certificate;
import ru.WI2.util.SessionUtil;

import javax.persistence.NoResultException;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class CertificateService  extends SessionUtil {

//    public static void main(String[] args) {
//        CertificateService service = new CertificateService();
//        try {
///*
//            service.create("certificate_1.png");
//            service.create("certificate_2.png");
//            service.create("certificate_3.jpg");
//*/
//            service.create("certificate_4.jpg");
//        } catch (SQLException e) {}
//    }


    public Certificate getCertificateById(Integer id) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        Certificate certificate = (Certificate) session.get(Certificate.class, id);
        closeTransactionSession();
        return certificate;
    }

    public void create(/*Certificate certificate*/ String path) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();

        File resume = new File(path);
        byte[] fileContent = new byte[(int) resume.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(resume);
            fileInputStream.read(fileContent);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Blob blob = new SerialBlob(fileContent);
        Certificate certificate = new Certificate("name", "company", blob);
//        Certificate certificate = new Certificate();
//        certificate.setScan(blob);
//        certificate.setId(2);
//        certificate.setName("name");
//        certificate.setCompany("company");

        session.save("Certificate", certificate);
        closeTransactionSession();
    }

    public void update(Certificate certificate) throws SQLException, NoResultException {
        openTransactionSession();
        Session session = getSession();
        session.update(session);
        closeTransactionSession();
    }

}
