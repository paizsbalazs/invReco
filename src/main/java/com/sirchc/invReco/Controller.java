package com.sirchc.invReco;

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
    public String doSomeThing(@RequestBody InvReco invReco) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3050/c:/invRecBackend/INVRECO.fdb",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        String result = dao.invreco(invReco);

        return result;
    }

    @GetMapping("getPendingInvs/{verifid}")
    public List<String> getPendingInvs (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3050/c:/invRecBackend/INVRECO.fdb",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.getpendinglist(verifid);
    }

    @GetMapping("getPendingInvsN/{verifid}")
    public String getPendingInvsN (@PathVariable String verifid) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql://localhost:3050/c:/invRecBackend/INVRECO.fdb",
                "SYSDBA", "masterkey");

        Dao dao = new Dao(connection);
        return dao.getpendinglistN(verifid);
    }

}
