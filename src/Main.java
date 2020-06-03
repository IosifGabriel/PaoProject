import Audit.AuditService;
import DataPersistence.AngajatService;
import DataPersistence.CladiriService;
import DataPersistence.OraseService;
import DataPersistence.RegistreService;
import Helper.CompanieHelper;
import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
            Scenariul este ->
            Vine un Client, persoana fizica sau juridica si vrea sa depuna niste acte inspre a fi arhivate,
            Problema e ca firma are mai multe sucursale si mai multe depozite arondate ( vreau sa pot sa arondez un depozit la mai multe sucursale)
            Actele vor fi depuse intr-un registru la o sucursala, si, la cerere pot fi tinute in sucursala sau trimise in depozit.
            Fiecare registru contine mai multe documente si mai multe nume de persoana, documentele contin ca "id" numele persoanei,iar cautarea se face dupa asta
            De asemenea, intr-o sucursala pot fi mai multe registre

            Ca ordonare o sa fie registrele si documentele, primele dupa volum (len(Documente) din ele), documentele alfabetic
         */

        Scanner scan = new Scanner(System.in);

        Companie MyCompany= new CompanieHelper().CompanieInitializareInit();



        AuditService.getInstance().writeAudit("Initializare companie");


        boolean flag = true;

        while (flag) {
            System.out.println("Companie de arhivistica");
            System.out.println("1. Adauga Oras");
            System.out.println("2. Adauga Registru");
            System.out.println("3. Adauga Document");
            System.out.println("4. Adauga Angajat");
            System.out.println("5. Adauga Depozit");
            System.out.println("6. Sterge Depozit");
            System.out.println("7. Sterge Document");
            System.out.println("8. Sterge Registru");
            System.out.println("9. Sterge Angajat");
            System.out.println("10. Arata Documente");
            System.out.println("11. Afiseaza orase");
            System.out.println("12. Stergere oras");
            System.out.println("13. Scrie Angajati");
            System.out.println("14. Scrie Registre");
            System.out.println("15. Scrie Cladiri");
            System.out.println("16. Scrie Orase");
            System.out.println("17. Salveaza angajat in baza de date");
            System.out.println("0. Exit");

            int choice = scan.nextInt();

            switch(choice) {
                case 0:
                    flag = false;
                    break;
                case 1: {
                    scan.nextLine();
                    System.out.println("Numele orasului");
                    String nume = scan.nextLine();

                    Oras oras = new Oras(nume);
                    System.out.println("---- A fost adaugat un nou oras ----");
                    MyCompany.AdaugaOras(oras);
                    break;
                }
                case 2: {
                    scan.nextLine();
                    System.out.println("Numele registrului");
                    String nume = scan.next();
                    System.out.println("Orasul, sucursala sau depozit, adresa cladirii");
                    String oras = scan.next();
                    String cladire = scan.next();
                    String adresa = scan.next();

                    Registre registru = new Registre(nume);

                    if (MyCompany.Search(oras) == null) {
                        System.out.println("Nume de oras gresit");
                        break;

                    } else {
                        MyCompany.AdaugaRegistru(new Registre(nume), oras, cladire, adresa);
                        System.out.println("Registru adaugat");
                        break;
                    }

                }
                case 3:{
                    scan.nextLine();
                    System.out.println("Numele Documentului");
                    String numedocument = scan.next();
                    System.out.println("Categorie document");
                    String categorie =scan.next();
                    System.out.println("Persoana Documentului, clasificare, datadocumentului");
                    String nume = scan.next();
                    String clasificare = scan.next();
                    String Datadocumentului = scan.next();

                    System.out.println("Oras, Adresa Sediului, Numele registrului");
                    String oras = scan.next();
                    String adresaSediului = scan.next();
                    String Numeregistru = scan.next();

                    MyCompany.AdaugaDocument(new Document(numedocument, categorie, nume,
                            clasificare.equals("secret")? true : false, Datadocumentului),oras,adresaSediului,Numeregistru);
                    break;
                }
                case 4:{
                    scan.nextLine();
                    System.out.println("Numele angajatului, Adresa mail, Nr telefon, Adresa Domiciliu, CNP, Salariu");
                    String numeangajat = scan.next();
                    String adresamail = scan.next();
                    String nrtelefon = scan.next();
                    String addomiciliu =scan.next();
                    String CNP = scan.next();
                    Integer salariu = scan.nextInt();

                    System.out.println("locatia unde va fi angajat, Oras, Sucursala");
                    String oras = scan.next();
                    String sucursala = scan.next();

                    MyCompany.AdaugaAngajatinCompanie(new Angajati(numeangajat, salariu, adresamail, addomiciliu, nrtelefon, CNP), oras, sucursala);
                    break;
                }
                case 5:{
                    scan.nextLine();
                    System.out.println("Adresa depozitului, capacitate");
                    String adresadep = scan.next();
                    Integer capacitate = scan.nextInt();

                    System.out.println("Orasul unde vreti sa fie adaugat");
                    String adresaoras = scan.next();

                    MyCompany.AdaugaDepozit(new Depozit(capacitate, adresadep), adresaoras);
                    break;
                }

                case 6:{
                    scan.nextLine();
                    System.out.println("Adresa depozitului sters");
                    String adresadepozit = scan.next();


                    System.out.println("Orasul de unde sa fie sters");
                    String adresaoras = scan.next();

                    MyCompany.StergereDepozit(adresadepozit,adresaoras);
                    break;
                }

                case 7:{
                    scan.nextLine();
                    System.out.println("Numele documentului sters, adresa orasului, nume registru, nr de ordine");
                    String numedocument = scan.next();
                    String adresaorasului = scan.next();
                    String numeregistru = scan.next();
                    Integer nrordine = scan.nextInt();

                    MyCompany.StergereDocument(numedocument,adresaorasului,numeregistru,nrordine);
                    break;
                }

                case 8:{
                    scan.nextLine();
                    System.out.println("Numele registrului sters, adresa orasului, tipul cladirii, adresa cladirii");
                    String numeregistru = scan.next();
                    String adresaorasului = scan.next();
                    String tipulcladirii = scan.next();
                    String adresacladirii = scan.next();

                    MyCompany.StergereRegistru(numeregistru,adresaorasului,tipulcladirii,adresacladirii);
                    break;
                }

                case 9:{

                    scan.nextLine();
                    System.out.println("CNP-ul angajatului");
                    String CNP = scan.next();

                    MyCompany.StergereAngajat(CNP);
                    break;
                }

                case 10:{

                    System.out.println("Documentele din firma sunt:");
                    MyCompany.AfiseazaDocumente();
                    break;
                }

                case 11:{
                    System.out.println("Orasele din firma sunt");
                    MyCompany.AfiseazaOrase();
                    break;
                }

                case 12:{
                    scan.nextLine();
                    System.out.println("Orasul care vreti sa fie sters");
                    String oras = scan.next();

                    MyCompany.StergereOras(oras);
                    break;
                }
                case 13:{
                    AngajatService.getInstance().writeAngajati(MyCompany);
                    break;
                }
                case 14:{
                    RegistreService.getInstance().writeRegistre(MyCompany);
                    break;
                }
                case 15:{
                    CladiriService.getInstance().writeCladiri(MyCompany);
                    break;
                }
                case 16:{
                    OraseService.getInstance().writeOrase(MyCompany);
                    break;
                }
                case 17:{
                    scan.nextLine();
                    System.out.println("Numele angajatului, Adresa mail, Nr telefon, Adresa Domiciliu, CNP, Salariu");
                    String numeangajat = scan.next();
                    String adresamail = scan.next();
                    String nrtelefon = scan.next();
                    String addomiciliu =scan.next();
                    String CNP = scan.next();
                    Integer salariu = scan.nextInt();

                    MyCompany.SalveazaAngajatDB(new Angajati(numeangajat,salariu,adresamail,addomiciliu,nrtelefon,CNP));
                }

            }
        }
    }
}
