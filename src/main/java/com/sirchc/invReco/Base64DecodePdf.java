package com.sirchc.invReco;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

class Base64DecodePdf {
    public File generate(String s, String t) {

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String formattedDate = myDateObj.format(myFormatObj);

        File file = new File("./" + t + "_" + formattedDate + ".pdf");

        try ( FileOutputStream fos = new FileOutputStream(file); ) {
            byte[] decoder = Base64.getDecoder().decode(s);
            fos.write(decoder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }
}
