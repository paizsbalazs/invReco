package com.sirchc.invReco;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

public class Dao {

    Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    public String invreco(Invrecoo invReco) throws FileNotFoundException, SQLException {

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

    public List<PendingInvs> getpendinglist(String verifid) throws SQLException {
        /*List<String> result = new ArrayList<>();*/

        List<PendingInvs> result = new ArrayList<>();

        String storedProcudureCall = "? = call GET_PENDING_INVS(?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, verifid);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            /*result.add(rs.getString(1));*/
            result.add(new PendingInvs(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }

        rs.close();
        cs.close();
        connection.close();

        return result;
    }

    public String getpendinglistN(String verifid) throws SQLException {

        String storedProcudureCall = "? = call GET_PENDING_NUM_INVS(?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, verifid);
        ResultSet rs = cs.executeQuery();
        rs.next();
        String result = rs.getString(1);
        cs.close();
        connection.close();
        return result;
    }

    public String setinvset(Invset invset) throws SQLException {

        String storedProcudureCall = "? = call INS_INVSET(?, ?, ?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, invset.supvatnum);
        cs.setString(3, invset.cusvatnum);
        cs.setString(4, invset.invnum);

        /* Ez akkor, ha jó az új BLOB is
        byte[] decodedByte = Base64.getEncoder().encode(invReco.pdf.getBytes());
        Blob b = new SerialBlob(decodedByte);*/

        cs.execute();
        String result = cs.getString(1);
        /*System.out.println("Ez van " + cs.getString(1));*/
        cs.close();
        connection.close();

        return result;
    }

    public String getReadylistN(String verifid) throws SQLException {

        String storedProcudureCall = "? = call GET_READY_NUM_INVS(?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, verifid);
        ResultSet rs = cs.executeQuery();
        rs.next();
        String result = rs.getString(1);
        cs.close();
        connection.close();
        return result;
    }

    public List<ReadyInvs> getreadylist(String verifid) throws SQLException {
        /*List<String> result = new ArrayList<>();*/

        List<ReadyInvs> result = new ArrayList<>();

        String storedProcudureCall = "? = call GET_READY_INVS(?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, verifid);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            /*result.add(rs.getString(1));*/
            result.add(new ReadyInvs(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }

        rs.close();
        cs.close();
        connection.close();

        return result;
    }

    public List<PendingInvs> getproclist(String verifid) throws SQLException {
        /*List<String> result = new ArrayList<>();*/

        List<PendingInvs> result = new ArrayList<>();

        String storedProcudureCall = "? = call GET_PROC_INVS(?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, verifid);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            /*result.add(rs.getString(1));*/
            result.add(new PendingInvs(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }

        rs.close();
        cs.close();
        connection.close();

        return result;
    }

    public String getproclistN(String verifid) throws SQLException {

        String storedProcudureCall = "? = call GET_PROC_NUM_INVS(?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, verifid);
        ResultSet rs = cs.executeQuery();
        rs.next();
        String result = rs.getString(1);
        cs.close();
        connection.close();
        return result;
    }

    public String closeinv(String verifid, String invid) throws SQLException {

        String storedProcudureCall = "? = call CLOSE_INVS(?,?)";
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall(storedProcudureCall);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, verifid);
        cs.setString(3, invid);

        System.out.println(verifid + " " + invid);

        ResultSet rs = cs.executeQuery();
        rs.next();
        String result = rs.getString(1);
        cs.close();
        connection.close();
        return result;
    }
}
