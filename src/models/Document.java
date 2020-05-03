package models;

import java.util.Date;

public class Document {
    private String NumeDoc;
    private String CategorieDocument;
    private boolean Clasificat;
    private static Integer NumarOrdine=0;
    private String DataDocumentului;
    private String PersoanaDocumentului;

    public Document(String NumeDoc, String CategorieDocument, String PersoanaDocumentului, boolean Clasificat, String DataDocumentului){

        this.NumeDoc=NumeDoc;
        this.CategorieDocument=CategorieDocument;
        this.Clasificat=Clasificat;
        this.DataDocumentului=DataDocumentului;
        this.NumarOrdine++;
        this.PersoanaDocumentului = PersoanaDocumentului;
    }

    public String getCategorieDocument(){
        return this.CategorieDocument;
    }

    public void setCategorieDocument(String CategorieDocument){
        this.CategorieDocument = CategorieDocument;
    }

    public boolean getClasificat(){
        return this.Clasificat;
    }

    void setClasificat(boolean Clasificat){
        this.Clasificat = Clasificat;
    }

    public Integer getNumarOrdine(){
        return this.NumarOrdine;
    }

    public String getDataDocumentului(){
        return this.DataDocumentului;
    }

    public void setDataDocumentului(String DataDocumentului){
        this.DataDocumentului = DataDocumentului;
    }

    public String getPersoanaDocumentului(){
        return this.PersoanaDocumentului;
    }

    public void setPersoanaDocumentului(String PersoanaDocumentului){
        this.PersoanaDocumentului = PersoanaDocumentului;;
    }

    public String getNumeDoc(){
        return this.NumeDoc;
    }

    @Override
    public String toString(){
        return "Document{" + NumeDoc + " " + CategorieDocument + " " + Clasificat + " " + PersoanaDocumentului + " dataL " + DataDocumentului;
    }

}
