package DataPersistence;

import models.Companie;
import models.Oras;
import models.Sucursale;
import models.Depozit;

import java.io.*;
import java.util.Scanner;

public class CladiriService {
    private File CladiriFile;
    private FileWriter CladiriWriter;
    private Scanner CladiriReader;

    private static CladiriService instance = null;

    public static CladiriService getInstance() {
        if (instance == null)
            instance = new CladiriService();

        return instance;
    }

    private CladiriService() {
        CladiriFile = new File("src/CSV/Cladiri.csv");

    }

    public Companie CitesteCladiri(Companie MyCompany){
        try{
            CladiriReader = new Scanner(CladiriFile);
            while(CladiriReader.hasNext()) {
                String data = CladiriReader.next();
                String[] values = data.split(",");

                String Oras = values[0];
                String TipCladire = values[1];
                String AdresaCladire = values[2];
                int Capacite = Integer.parseInt(values[3]);

                if (TipCladire.equals("Depozit")) {
                    MyCompany.AdaugaDepozit(new Depozit(Capacite, AdresaCladire), Oras);
                }
                else {
                    MyCompany.AdaugaSucursala(new Sucursale(AdresaCladire), Oras);
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        return MyCompany;
    }

    public void writeCladiri(Companie MyCompany) {
        try {
            CladiriWriter = new FileWriter("src/CSV/cladiriwrit.csv", false);
            PrintWriter pw = new PrintWriter(CladiriWriter);

            if(MyCompany.getOrase()!=null)
            for(Oras o : MyCompany.getOrase()){
                if(o.getSedii()!=null)
                   for(Sucursale s : o.getSedii()){
                       pw.println(o.getNume()+",Sucursala,"+s.getAdresa());
                   }

                if(o.getDepozite() != null)
                   for(Depozit d: o.getDepozite()){
                       pw.println(o.getNume()+",Depozit,"+d.getAdresa()+","+d.getCapacitate().toString());
                   }

            }


            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println("Could not save data");
        }


    }
}
