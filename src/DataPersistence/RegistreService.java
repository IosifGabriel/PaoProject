package DataPersistence;

import models.*;

import java.io.*;
import java.util.Scanner;

public class RegistreService{
    private File RegistreFile;
    private FileWriter RegistreWriter;
    private Scanner RegistreReader;

    private static RegistreService instance = null;

    public static RegistreService getInstance() {
        if (instance == null)
            instance = new RegistreService();

        return instance;
    }

    private RegistreService() {
        RegistreFile = new File("src/CSV/Registre.csv");

    }

    public Companie CitesteRegistre(Companie MyCompany){
        try{
            RegistreReader = new Scanner(RegistreFile);
            while(RegistreReader.hasNext()) {
                String data = RegistreReader.next();
                String[] values = data.split(",");

                String NumeRegistru = values[0];
                String Oras = values[1];
                String TipCladire = values[2];
                String AdresaCladire = values[3];

                MyCompany.AdaugaRegistru(new Registre(NumeRegistru),Oras, TipCladire, AdresaCladire);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        return MyCompany;
    }

    public void writeRegistre(Companie MyCompany) {
        try {
            RegistreWriter = new FileWriter("src/CSV/registrewrit.csv", false);
            PrintWriter pw = new PrintWriter(RegistreWriter);

            if(MyCompany.getOrase() != null) {
                for (Oras o : MyCompany.getOrase()) {
                    if (o.getDepozite() != null)
                        for(Depozit d :  o.getDepozite()){
                            if(d.getRegistreStocate() != null)
                                for(Registre r : d.getRegistreStocate()){
                                    pw.println(r.getNumeRegistru()+","+o.getNume()+",Depozit,"+d.getAdresa());
                                }
                        }
                    if(o.getSedii()!= null)
                        for(Sucursale s: o.getSedii())
                            if(s.GetRegistre() != null)
                                for(Registre r: s.GetRegistre()){
                                    pw.println(r.getNumeRegistru()+","+o.getNume()+",Sucursala,"+s.getAdresa());
                                }

                }
            }

            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println("Could not save data");
        }


    }
}
