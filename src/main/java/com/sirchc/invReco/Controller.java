package com.sirchc.invReco;

import org.firebirdsql.encodings.IEncodingFactory;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@RestController
public class Controller {

    /*@GetMapping("recInv")
    public String respond() {

        RecInv recInv = new RecInv ();

        ObjectMapper mapper = new ObjectMapper();

        try {
            RecInv recInv1 = mapper.readValue(Paths.get("book.json").toFile(), RecInv.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            recInv = mapper.readValue("{\"taxnumber\": \"taxnumber2\"}", RecInv.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return recInv.taxnumber;
    }*/

    @GetMapping("invReco")
    public String respond() {

        return "OK";

    }


    /*@RequestMapping(
            value = "/recInv",
            method = RequestMethod.POST,
            consumes = "text/plain")

        public String process(@RequestBody String payload) throws Exception {

        return payload;

    }*/

    @PostMapping("/invReco")
    public String doSomeThing(@RequestBody Invrecoo invReco) throws ClassNotFoundException, SQLException, FileNotFoundException {

        if (!new Senderverify(invReco).getverify()) {
            return "Access Denied";
        }

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        String result = dao.invreco(invReco);

        return result;
    }

    @PostMapping("/invSet")
    public String doSomeThing(@RequestBody Invset invset) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        String result = dao.setinvset(invset);

        return result;
    }

    @GetMapping("getPendingInvs/{verifid}")
    public List<PendingInvs> getPendingInvs (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.getpendinglist(verifid);
    }

    @GetMapping("getPendingInvsN/{verifid}")
    public String getPendingInvsN (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.getpendinglistN(verifid);
    }

    @GetMapping("getReadyInvsN/{verifid}")
    public String getReadyInvsN (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.getReadylistN(verifid);
    }

    @GetMapping("getReadyInvs/{verifid}")
    public List<ReadyInvs> getReadyInvs (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.getreadylist(verifid);
    }

    @GetMapping("getProcInvs/{verifid}")
    public List<PendingInvs> getProcInvs (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.getproclist(verifid);
    }

    @GetMapping("getProcInvsN/{verifid}")
    public String getProcInvsN (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.getproclistN(verifid);
    }

    @GetMapping("close/{verifid}/{invid}")
    public String closeInvs (@PathVariable String verifid, @PathVariable String invid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.closeinv(verifid, invid);
    }

    @GetMapping("reprocInvs/{verifid}")
    public String reProcInvs (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3051/C:/invReco/release/INVRECO.fdb?encoding=UTF8",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.reproc(verifid);
    }

}
