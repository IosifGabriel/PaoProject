package Management;

import models.*;

public interface ServiciuCompanie {
    void AdaugaOras(Oras oras);
    void StergereOras(String Nume);
    void AdaugaDepozit(Depozit depozit, String oras);
    void StergereDepozit(String adresaDepozit, String adresaOras);
    void AdaugaAngajatinCompanie(Angajati angajat, String oras, String adresasucursala);
    void StergereAngajat(String CNP);
    void AdaugaDocument(Document doc, String adresaOras, String adresaSediu, String Registru);
    void StergereDocument(String NumeDocument, String adresaOras, String Registru , Integer Nrordin);
    void AdaugaRegistru(Registre Registru, String adresaOras, String Cladire ,String adresaSediu);
    void StergereRegistru(String NumeRegistru, String adresaOras, String Cladire, String adresaSediu);
    void AdaugaSucursala(Sucursale Sucursala, String oras);
    void AfiseazaDocumente();
    void AfiseazaOrase();
    void SalveazaAngajatDB(Angajati angajat);
}
