package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;

public class BasicLogger {
    private File logFile;
    private String destinationPath;
    private String destinationFile;


    public BasicLogger(String destinationPath, String destinationFile) throws IOException {
        this.destinationPath = destinationPath;
        this.destinationFile = destinationFile;
        logFile = new File(destinationPath, destinationFile);
        logFile.createNewFile();

    }




    public void writeToLog(String message) throws IOException {

        if (logFile.exists()){
            String msgDate = LocalDate.now() + " " + LocalTime.now().toString();
            String output = msgDate + ": " + message + " " + " " + "\n";
            try (FileOutputStream fos = new FileOutputStream(logFile,true)) {
                fos.write(output.getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}
