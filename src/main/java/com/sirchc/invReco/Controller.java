package com.sirchc.invReco;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}
