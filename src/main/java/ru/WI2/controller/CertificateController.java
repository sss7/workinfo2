package ru.WI2.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ru.WI2.entity.Certificate;
import ru.WI2.service.CertificateService;

import javax.persistence.NoResultException;
import java.io.*;
import java.sql.*;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    protected Connection connection = null;
    private   final  String  INSERT_blob   = "insert into %s(%s) values(%d)"    ;
    private   final  String  UPDATE_blob   = "update %s set %s = ? where %s = ?";

    private CertificateService service;

    @Autowired
    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Certificate getCertificateById(@PathVariable Integer id) throws SQLException, NoResultException {
        return service.getCertificateById(id);
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("name") String name, @RequestParam("scan") MultipartFile scan) {

//        String name = null;
        if (!scan.isEmpty()) {

            try {
                byte[] bytes = scan.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "Вы удачно загрузили " + name + " в " + name + "-uploaded !";
            } catch (IOException e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }

        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }

    }


    @RequestMapping(method = RequestMethod.POST) //GET
    public void create(/*@RequestBody Certificate certificate*/ /*@PathVariable*/ String path) throws SQLException, NoResultException {

//        File resume = new File("certificate_1.png");
//        byte[] fileContent = new byte[(int) resume.length()];
//        try {
//            FileInputStream fileInputStream = new FileInputStream(resume);
//
//            fileInputStream.read(fileContent);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Blob blob = Hibernate.createBlob(fileContent);
//
//        byte[] blobAsBytes = blob.getBytes(1, (int)blob.length());





//        writeBlob("certificate", "scan", "id", 1, "certificate_1.png");
//        writeBlob("certificate", "scan", "id", 2, "certificate_2.png");
//
//        File file = null;
//        FileInputStream is = null;
//        PreparedStatement ps = null;
//
//        try {
//            file = new File("certificate_1.png");
//            is = new FileInputStream(file);
//
//        } catch (Exception e) {}
//        ps.setBinaryStream(1, is, (int)file.length());
//
//        Certificate cert = new Certificate(1, "n", "n", );
        service.create(path);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public void createall(@RequestBody Certificate certificate) throws SQLException, NoResultException {
//        service.create(certificate);
//    }


//    @RequestMapping(method = RequestMethod.PUT)
//    public void update(@RequestBody Certificate certificate) throws SQLException, NoResultException {
//        service.update(certificate);
//    }
//
//
//    public boolean writeBlob(final String table, final String field,
//                             final String pk, final int id,
//                             final String fpath)
//    {
//        boolean result = execSQL (String.format(INSERT_blob, table, pk, id));
//
//        if (result) {
//            PreparedStatement ps = null;
//            File file = new File(fpath);
//            try {
//                String sql = String.format(UPDATE_blob, table, field, pk);
//                FileInputStream is = new FileInputStream(file);
//                ps = connection.prepareStatement(sql);
//                ps.setBinaryStream(1, is, (int)file.length());
//                ps.setInt(2, id);
//                ps.executeUpdate();
//
//                connection.commit();
//                ps.close();
//            } catch (FileNotFoundException e) {
//                result = false;
//                e.printStackTrace();
//            } catch (SQLException e) {
//                result = false;
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }


//    public boolean execSQL (final String sql) {
//        boolean result = false;
//        try {
//            if (connection != null) {
//                Statement statement = connection.createStatement();
//                statement.execute(sql);
//                statement.close();
//                statement = null;
//                result = true;
//            }
//        } catch (SQLException e) {}
//
//        return result;
//    }



//    public void scanList() {
//        try {
//            File file = new File("certificate_1.png");
//            FileInputStream is = new FileInputStream(file);
//
//        } catch (Exception e) {}
//    }


}
