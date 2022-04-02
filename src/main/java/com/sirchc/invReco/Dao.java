package com.sirchc.invReco;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

public class Dao {

    Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    String invreco(InvReco invReco) throws FileNotFoundException, SQLException {


        String storedProcudureCall = "? = call INS_INVS(?, ?, ?, ?, ?)";
        /*CallableStatement cs = connection.prepareCall("{EXECUTE PROCEDURE INS_INVS(?,?,?,?,?)}");*/
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, invReco.licence);
        cs.setInt(3, 1);
        cs.setString(4, invReco.taxnumber);

        /* Ez akkor, ha jó az új BLOB is
        byte[] decodedByte = Base64.getEncoder().encode(invReco.pdf.getBytes());
        Blob b = new SerialBlob(decodedByte);*/

        Base64DecodePdf b64d = new Base64DecodePdf();
        InputStream b = new FileInputStream(b64d.generate(invReco.getPdf(), invReco.getTaxnumber()));

        cs.setBlob(5, b);
        cs.setString(6, "test56");
        cs.execute();
        String result = cs.getString(1);
        /*System.out.println("Ez van " + cs.getString(1));*/
        cs.close();
        connection.close();

        return result;
    }

}
