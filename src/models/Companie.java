package models;


import Audit.AuditService;
import Management.ServiciuCompanie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;


public class Companie implements ServiciuCompanie {

    private List<Oras> Orase;

    public Companie(List<Oras> Orase){
        this.Orase = Orase;
    }

    public Companie(){
        Orase = new ArrayList<>();
    };

    public List<Oras> getOrase(){
        return this.Orase;
    }

    public void AdaugaOras(Oras Oras){
        this.Orase.add(Oras);
        AuditService.getInstance().writeAudit("Oras adaugat");
    }

    public void StergereOras(String name){
        if(Search(name)!=null){
            Orase.remove(Search(name));
            AuditService.getInstance().writeAudit("Oras sters " + name );
        }
        else{
            AuditService.getInstance().writeAudit("orasul nu este in lista");
        }
    }

    public void AdaugaDepozit(Depozit depozit, String oras){
        if(Search(oras)!=null){
            Search(oras).AdaugaDepozit(depozit);
            AuditService.getInstance().writeAudit("Depozit adaugat in orasul " + oras);
        }else{
            AuditService.getInstance().writeAudit("Nu s-a putut adauga depozit in orasul " + oras);
        }
    }

    public void StergereDepozit(String adresaDepozit, String numeoras){
        if(Search(numeoras).SearchDepozit(adresaDepozit) != null){
            Search(numeoras).StergeDepozit(Search(numeoras).SearchDepozit(adresaDepozit));
            AuditService.getInstance().writeAudit("Depozitul sters de la adresa " + adresaDepozit + " " + numeoras);
        }else{
            AuditService.getInstance().writeAudit("depozitul nu este in lista");
        }
    }

    public void AdaugaAngajatinCompanie(Angajati angajat, String numeoras, String adresasucursala){
        if(Search(numeoras).SearchSucursale(adresasucursala) != null){
            Search(numeoras).SearchSucursale(adresasucursala).adaugaAngajat(angajat);
            AuditService.getInstance().writeAudit("Angajatul " + angajat.getNume() + "a fost adaugat in " + numeoras + " " + adresasucursala);
        }else{
            AuditService.getInstance().writeAudit("Angajatul nu a putut fi adaugat");
        }
    }

    public void StergereAngajat(String CNP){
        for(Oras o : Orase){
            for(Sucursale s : o.getSedii()){
                for(Angajati a: s.getAngajatiSucursala()){
                    if(s.stergeAngajat(CNP) == 1)
                        AuditService.getInstance().writeAudit("Angajatul cu CNP " + CNP + " a fost sters");
                }
            }
        }
    }

    public void AdaugaDocument(Document doc, String adresaOras, String adresaSediu, String Registru){
        if(Search(adresaOras).SearchSucursale(adresaSediu).searchRegistre(Registru) != null){
            Search(adresaOras).SearchSucursale(adresaSediu).searchRegistre(Registru).AdaugaDocument(doc);
            AuditService.getInstance().writeAudit("Document adaugat in" + Registru + " din " + adresaOras);
        }
        else {
            AuditService.getInstance().writeAudit("Nu s-a putut adauga documentul");
        }
    }

    public void StergereDocument(String NumeDocument, String adresaOras, String Registru , Integer Nrordine){
        Set<Sucursale> sediioras = Search(adresaOras).getSedii();

        for(Sucursale s : sediioras){
            if(s.searchRegistre(Registru) != null){
                s.searchRegistre(Registru).StergeDocument(NumeDocument, Nrordine);
                AuditService.getInstance().writeAudit("S-a sters documentul " + NumeDocument + " cu nr de ordine " + Nrordine.toString());
                return;
            }
        }
        AuditService.getInstance().writeAudit("Nu s-a gasit documentul");
    }

    public void AdaugaRegistru(Registre Registru, String oras, String cladire ,String adresaSediu){

        if(cladire.equals("sucursala")){
            if(Search(oras).SearchSucursale(adresaSediu) == null) {
                System.out.println("Adresa este gresita");
                AuditService.getInstance().writeAudit("Adauga registru - Adresa orasului este gresita");
            }
            else
            {
                Search(oras).SearchSucursale(adresaSediu).addRegistre(Registru);
                AuditService.getInstance().writeAudit("registru adaugat");
                return;
            }
        }
        else if(cladire.equals("depozit")){
            if(Search(oras).SearchDepozit(adresaSediu) == null){
                System.out.println("Adresa este gresita");
                AuditService.getInstance().writeAudit("Adauga registru - Adresa orasului este gresita");
            }
            else
            {
                Search(oras).SearchDepozit(adresaSediu).addRegistre(Registru);
                System.out.println("--- A fost adaugat un reigstru ---");
                AuditService.getInstance().writeAudit("registru adaugat");
                return;
            }
        }
    }

    public void StergereRegistru(String NumeRegistru, String adresaOras, String Cladire, String adresaSediu){

        if(Cladire.equals("sucursala")){
            if(Search(adresaOras).SearchSucursale(adresaSediu) == null) {
                System.out.println("Adresa este gresita");
                AuditService.getInstance().writeAudit("Adresa orasului este gresita");
            }
            else
            {
                Search(adresaOras).SearchSucursale(adresaSediu).stergeRegistru(NumeRegistru);
                AuditService.getInstance().writeAudit("registru sters " + NumeRegistru + " ");
                return;
            }
        }
        else if(Cladire.equals("depozit")){
            if(Search(adresaOras).SearchDepozit(adresaSediu) == null)
                System.out.println("Adresa este gresita");
            else
            {
                Search(adresaOras).SearchDepozit(adresaSediu).stergeRegistru(NumeRegistru);
                System.out.println("--- A fost adaugat un reigstru ---");
                AuditService.getInstance().writeAudit("registru sters " + NumeRegistru + " ");
                return;
            }
        }

    }

    public void AfiseazaDocumente(){
        AuditService.getInstance().writeAudit("Afisare documente");
        for(Oras o : Orase){
            if(o.getSedii() != null)
            for(Sucursale s: o.getSedii()){
                if(s.GetRegistre() !=null)
                for(Registre r: s.GetRegistre()){
                    if(r.getDocument() != null)
                    for(Document d: r.getDocument()) {
                        System.out.println("Oras + " + o.getNume()
                        + "Sucursala din " + s.getAdresa() + " Registrul " + r.getNumeRegistru() + d.toString());
                    }
                }
            }

            for(Depozit d: o.getDepozite()){
                if(d.getRegistreStocate() != null)
                for(Registre r : d.getRegistreStocate()){
                    if(r.getDocument() != null)
                    for( Document doc: r.getDocument()){
                        System.out.println("Oras + " + o.getNume()
                                + "Sucursala din " + d.getAdresa() + " Registrul " + r.getNumeRegistru() + doc.toString());
                    }
                }
            }
        }
    }


    public void AdaugaSucursala(Sucursale Sucursala, String oras){

        if(Search(oras) == null){
            System.out.println("Nu exista orasul pentru a aronda un sediu");
            return;
        }

        else if(Search(oras) != null){
            Search(oras).AdaugaSucursala(Sucursala);
            AuditService.getInstance().writeAudit("Sucursala adaugat in orasul " + oras);
        }else{
            AuditService.getInstance().writeAudit("Nu s-a putut adauga sucursala in orasul " + oras);
        }
    }

    public void AfiseazaOrase(){
        AuditService.getInstance().writeAudit("Afisare orase");
        System.out.println("Firma are sedii in urmatoarele orase");
        for(Oras o: Orase)
            System.out.println(o.toString());
    }


    public Oras Search(String name){

            for (Oras o : Orase){
                if (o.getNume().equals(name))
                    return o;

            }

        return null;
    }


}
