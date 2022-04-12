package com.sirchc.invReco;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Senderverify {

    public InvReco invreco;

    public Senderverify(InvReco invreco) {
        this.invreco = invreco;
    }

    public boolean getverify() {

        try {

            File jarPath=new File(Senderverify.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String propertiesPath=jarPath.getParentFile().getAbsolutePath();

            List<String> Licenses = Files.readAllLines(Paths.get(propertiesPath + "/contract.txt"));

            if (Licenses.contains(invreco.licence)) {return true;}

        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        return false;
    }
}
