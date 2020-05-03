package DataPersistence;

import models.Angajati;
import models.Companie;
import models.Oras;
import models.Sucursale;

import java.io.*;
import java.util.Scanner;

public class AngajatService {
    private File AngajatiFile;
    private FileWriter angajatiWriter;
    private Scanner angajatiReader;

    private static AngajatService instance = null;

    public static AngajatService getInstance() {
        if (instance == null)
            instance = new AngajatService();

        return instance;
    }

    private AngajatService() {
        AngajatiFile = new File("src/CSV/Angajati.csv");

    }

    public Companie citesteAngajati(Companie MyCompany){
        try{
            angajatiReader = new Scanner(AngajatiFile);
            while(angajatiReader.hasNext()){
                String data = angajatiReader.next();
                String[] values = data.split(",");

                String nume = values[0];
                int salariu =  Integer.parseInt(values[1]);
                String adresamail = values[2];
                String adresadomiciliu = values[3];
                String Telefon = values[4];
                String CNP = values[5];
                String oras = values[6];
                String AdresaSucursala = values[7];

                MyCompany.AdaugaAngajatinCompanie(new Angajati(nume,salariu,adresamail,adresadomiciliu,Telefon,CNP), oras, AdresaSucursala);
            }

        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        return MyCompany;
    }

    public void writeAngajati(Companie MyCompany) {
        try {
            angajatiWriter = new FileWriter("src/CSV/angajatiwrit.csv", false);
            PrintWriter pw = new PrintWriter(angajatiWriter);

            for (Oras o : MyCompany.getOrase()) {
                if(o.getSedii() != null)
                for (Sucursale s : o.getSedii()) {
                    if(s.getAngajatiSucursala() != null)
                    for(Angajati a: s.getAngajatiSucursala()){
                        pw.println(a.getNume()+","+a.getSalariu()+","+a.getAdresaMail()+","+a.getAdresaDomiciliu()+","+a.getTelefon()+","+a.getCNP());
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
