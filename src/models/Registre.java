package models;

import java.util.ArrayList;

public class Registre {
    private String NumeRegistru;
    private ArrayList<Persoane> Operator;
    private ArrayList<Document> Document;


    public Registre(String NumeRegistru){
        this.NumeRegistru = NumeRegistru;
    }

    public Registre(String NumeRegistru, ArrayList<Persoane> Operator, ArrayList<Document> Documente){
        this.NumeRegistru = NumeRegistru;
        this.Operator = Operator;
        this.Document = Documente;
    }

    public void AdaugaDocument(Document doc){
        Document.add(doc);
    }

    public void StergeDocument(String NumeDoc, Integer Nrordine){
        for(Document d: Document){
            if(d.getNumeDoc().equals(NumeDoc) && d.getNumarOrdine().equals(Nrordine))
            {
                Document.remove(d);
            }
        }
    }

    public String getNumeRegistru(){
        return this.NumeRegistru;
    }

    public void setNumeRegistru(String NumeRegistru){
        this.NumeRegistru = NumeRegistru;
    }

    public ArrayList<Persoane> getOperator(){
        return this.Operator;
    }

    public void setOperator(ArrayList<Persoane> Operator){
        this.Operator=Operator;
    }

    public ArrayList<Document> getDocument(){
        return this.Document;
    }

    public void setDocument(ArrayList<Document> Document){
        this.Document = Document;
    }
}
