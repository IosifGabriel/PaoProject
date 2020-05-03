package DataPersistence;

import models.*;

import java.io.*;
import java.util.Scanner;

public class OraseService{
    private File OraseFile;
    private FileWriter OraseWriter;
    private Scanner OraseReader;

    private static OraseService instance = null;

    public static OraseService getInstance() {
        if (instance == null)
            instance = new OraseService();
        return instance;
    }

    private OraseService() {
        OraseFile = new File("src/CSV/Orase.csv");

    }

    public Companie CitesteOrase(Companie MyCompany){
        try{
            OraseReader = new Scanner(OraseFile);
            while(OraseReader.hasNext()) {
                String data = OraseReader.next();
                String[] values = data.split(",");

                String NumeOras = values[0];
                String Tara = values[1];

                MyCompany.AdaugaOras(new Oras(NumeOras, Tara));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        return MyCompany;
    }

    public void writeOrase(Companie MyCompany) {
        try {
            OraseWriter = new FileWriter("src/CSV/orasewrit.csv", false);
            PrintWriter pw = new PrintWriter(OraseWriter);

            if(MyCompany.getOrase() != null)
                for(Oras o: MyCompany.getOrase()){
                    pw.println(o.getNume()+","+o.getTara());
                }

            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println("Could not save data");
        }


    }
}
