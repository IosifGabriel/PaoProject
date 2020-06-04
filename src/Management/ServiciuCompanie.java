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
    void StergeAngajatDB(int idAngajat);
    Angajati GasesteAngajatDB(int idAngajat);
    Angajati UpdateAngajatDB(Angajati angajat, int idAngajat);
    void SalveazaSucursalaDB(Sucursale sucursala, Oras oras);
    void StergeSucursalaDB(int idSucursala);
    Sucursale GasesteSucursalaDB(int idSucursala);
    Sucursale UpdateSucursalaDB(Sucursale sucursala, Oras oras, int idSucursala);
    void SalveazaDepozitDB(Depozit depozit, Oras oras);
    void StergeDepozitDB(int idDepozit);
    Depozit GasesteDepozitDB(int idDepozit);
    Depozit UpdateDepozitDB(Depozit depozit, Oras oras, int idDepozit);
    void SalveazaOrasDB(Oras oras);
    void StergeOrasDB(int idOras);
    Oras GasesteOrasDB(int idOras);
    Oras UpdateOrasDB(Oras oras, int idOras);
    void SalveazaRegistreDB(Registre registru, String oras, String Tipcladire, String Adresa);
    void StergeRegistreDB(int idRegistru);
    Registre GasesteRegistruaDB(int idRegistru);
    Registre UpdateRegistreDB(Registre registru, String oras, String TipCladire,  String Adresa, int idRegistru);


}
