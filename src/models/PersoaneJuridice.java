package models;

public final class PersoaneJuridice extends Persoane {

    private String Denumire;
    private String CUI;
    private String TipSediu;
    private String TipServiciu;


    public PersoaneJuridice(String Denumire, String CUI, String TipSediu, String TipServiciu,
                            String AdresaMail, String AdresaDomiciliu, String Telefon){

        this.Telefon=Telefon;
        this.AdresaDomiciliu=AdresaDomiciliu;
        this.AdresaMail=AdresaMail;
        this.Denumire = Denumire;
        this.CUI = CUI;
        this.TipSediu = TipSediu;
        this.TipServiciu = TipServiciu;
    }

    public String getDenumire(){
        return this.Denumire;
    }

    public void setDenumire(String Denumire){
        this.Denumire = Denumire;
    }

    public String getCUI(){
        return this.CUI;
    }

    public void setCUI(String CUI){
        this.CUI = CUI;
    }

    public String getTipSediu(){
        return this.TipSediu;
    }

    public void setTipSediu(String TipSediu){
        this.Denumire = TipSediu;
    }

    public String TipServiciu(){
        return this.TipServiciu;
    }

    public void setTipServiciu(String TipServiciu){
        this.TipServiciu = TipServiciu;
    }
}
