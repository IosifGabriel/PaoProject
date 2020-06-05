import Audit.AuditService;
import DataPersistence.AngajatService;
import DataPersistence.CladiriService;
import DataPersistence.OraseService;
import DataPersistence.RegistreService;
import Helper.CompanieHelper;
import View.OrasePannel;
import View.OraseSave;
import View.Start;
import models.*;

import javax.swing.*;
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
            System.out.println("18. Sterge angajat din baza de date");
            System.out.println("19. Gaseste angajat in baza de date");
            System.out.println("20. Updateaza angajat in baza de date");
            System.out.println("21. Salveaza sucursala in baza de date");
            System.out.println("22. Sterge sucursala din baza de date");
            System.out.println("23. Gaseste sucursala in baza de date");
            System.out.println("24. Updateaza sucursala in baza de date");
            System.out.println("25. Salveaza depozit in baza de date");
            System.out.println("26. Sterge depozit din baza de date");
            System.out.println("27. Gaseste depozit in baza de date");
            System.out.println("28. Updateaza depozit in baza de date");
            System.out.println("29. Salveaza registru in baza de date");
            System.out.println("30. Sterge registru din baza de date");
            System.out.println("31. Gaseste registru in baza de date");
            System.out.println("32. Updateaza registru in baza de date");
            System.out.println("33. Salveaza oras in baza de date");
            System.out.println("34. Sterge oras din baza de date");
            System.out.println("35. Gaseste oras in baza de date");
            System.out.println("36. Updateaza oras in baza de date");
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
                    break;
                }
                case 18:{
                    scan.nextLine();
                    System.out.println("Id-ul angajatului care vreti sa fie sters");
                    int id = scan.nextInt();

                    MyCompany.StergeAngajatDB(id);
                    break;
                }
                case 19:{
                    scan.nextLine();
                    System.out.println("Id-ul angajatului pe care il cauti");
                    int id = scan.nextInt();

                    Angajati cautat = MyCompany.GasesteAngajatDB(id);
                    System.out.println(cautat.getNume());
                    break;
                }
                case 20:{
                    scan.nextLine();
                    System.out.println("Numele angajatului, Adresa mail, Nr telefon, Adresa Domiciliu, CNP, Salariu, id-ul angajatului updatat");
                    String numeangajat = scan.next();
                    String adresamail = scan.next();
                    String nrtelefon = scan.next();
                    String addomiciliu =scan.next();
                    String CNP = scan.next();
                    Integer salariu = scan.nextInt();
                    int idANgajat = scan.nextInt();

                    MyCompany.UpdateAngajatDB(new Angajati(numeangajat,salariu,adresamail,addomiciliu,nrtelefon,CNP), idANgajat);
                    break;

                }
                case 21:{
                    scan.nextLine();
                    System.out.println("Adresa sucursalei, orasul, tara");
                    String adresa = scan.next();
                    String oras = scan.next();
                    String tara = scan.next();

                    MyCompany.SalveazaSucursalaDB(new Sucursale(adresa), new Oras(oras,tara));

                    break;
                }
                case 22:{
                    scan.nextLine();
                    System.out.println("Id-ul sucursalei");
                    int id = scan.nextInt();

                    MyCompany.StergeSucursalaDB(id);
                    break;
                }
                case 23:{
                    scan.nextLine();
                    System.out.println("Id-ul sucursalei cautate");
                    int id = scan.nextInt();

                    Sucursale s = MyCompany.GasesteSucursalaDB(id);

                    System.out.println(s.getAdresa()+ " " +s.GetRegistre());
                    break;
                }
                case 24:{
                    scan.nextLine();
                    System.out.println("Updateaza sucursala, dati id, adresa");
                    int id = scan.nextInt();
                    String adresa = scan.next();

                    MyCompany.UpdateSucursalaDB(new Sucursale(adresa), new Oras(), id);
                    break;
                }
                case 25:{
                    scan.nextLine();
                    System.out.println("Adresa depozitului, capacitate, orasul, tara");
                    String adresa = scan.next();
                    int cap = scan.nextInt();
                    String oras = scan.next();
                    String tara = scan.next();

                    MyCompany.SalveazaDepozitDB(new Depozit(cap, adresa), new Oras(oras,tara));

                    break;
                }
                case 26:{
                    scan.nextLine();
                    System.out.println("Id-ul depozitului");
                    int id = scan.nextInt();

                    MyCompany.StergeDepozitDB(id);
                    break;
                }
                case 27:{
                    scan.nextLine();
                    System.out.println("Id-ul depozitului cautat");
                    int id = scan.nextInt();

                    Depozit d = MyCompany.GasesteDepozitDB(id);

                    System.out.println(d.getAdresa() +" "+ d.getRegistreStocate());
                    break;
                }
                case 28:{
                    scan.nextLine();
                    System.out.println("Updateaza depozitula, dati id, adresa, capacitate");
                    int id = scan.nextInt();
                    String adresa = scan.next();
                    int capacitate = scan.nextInt();

                    MyCompany.UpdateDepozitDB(new Depozit(capacitate,adresa), new Oras(), id);
                    break;
                }
                case 29:{
                    scan.nextLine();
                    System.out.println("Nume registru pentru adaugare, oras, cladire, adresa");
                    String nume = scan.next();
                    String oras = scan.next();
                    String cladire = scan.next();
                    String adresa = scan.next();

                    MyCompany.SalveazaRegistreDB(new Registre(nume), oras, cladire, adresa);
                }
                case 30:{
                    scan.nextLine();
                    System.out.println("Id-ul registrului ce trebuie sters");
                    int id = scan.nextInt();

                    MyCompany.StergeRegistreDB(id);
                    break;
                }
                case 31:{
                    scan.nextLine();
                    System.out.println("id-ul registrului ce trebuie gasit");
                    int id = scan.nextInt();

                    Registre registre = MyCompany.GasesteRegistruaDB(id);

                    System.out.println(registre.getNumeRegistru() + " " + registre.getDocument());

                    break;
                }
                case 32:{
                    scan.nextLine();
                    System.out.println("Nume registru pentru adaugare, oras, cladire, adresa, id update");
                    String nume = scan.next();
                    String oras = scan.next();
                    String cladire = scan.next();
                    String adresa = scan.next();
                    int id = scan.nextInt();

                    MyCompany.UpdateRegistreDB(new Registre(nume), oras, cladire, adresa, id);
                }
                case 33:{
                    scan.nextLine();
                    System.out.println("Nume oras, tara");
                    String nume = scan.next();
                    String tara = scan.next();

                    MyCompany.SalveazaOrasDB(new Oras(nume,tara));
                    break;
                }
                case 34:{
                    scan.nextLine();
                    System.out.println("Id-ul orasului ce trebuie gasit");
                    int id = scan.nextInt();

                    MyCompany.StergeOrasDB(id);
                    break;
                }
                case 35:{
                    scan.nextLine();
                    System.out.println("Id-ul orasului ce trebuie gasit");
                    int id = scan.nextInt();

                    Oras oras = MyCompany.GasesteOrasDB(id);

                    System.out.println(oras.getNume()+" " + oras.getTara());
                    break;
                }
                case 36:{
                    scan.nextLine();
                    System.out.println("Dati numele nou, tara noua, id-ul");
                    String nume = scan.next();
                    String tara = scan.next();
                    int id = scan.nextInt();

                    MyCompany.UpdateOrasDB(new Oras(nume,tara), id);
                    break;
                }
                case 37:{
                    JFrame f = new JFrame();
                    Start startpannel = new Start();
                    OrasePannel op = new OrasePannel();
                    OraseSave os = new OraseSave();
                    startpannel.setVisible(true);
                    op.setVisible(true);
                    os.setVisible(true);
                    f.add(op);
                    f.add(startpannel);
                    f.setSize(400,400);
                    f.setVisible(true);
                    break;
                }


            }
        }
    }
}
