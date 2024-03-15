package ir.dte.boodgedaftar.model;

import java.math.BigDecimal;

public class Faaliat {
    public BigDecimal id;
    public String title;
    public String edare;
    public String edareURL;
    public String edareKol;
    public String edareKolURL;
    public String type;
    public String ghotb;
    public String miz;
    public BigDecimal amalkardNameDaryafti;
    public BigDecimal gharardad;

    public BigDecimal baghimandeGharardad;
    public BigDecimal amalkardNameHayeDaryaftiVaBaghimandeGharardad;
    public BigDecimal ghabelTakhsismenhayeBaghimandehGharardad;
    public BigDecimal ghanoon;
    public BigDecimal mosavabSate;
    public BigDecimal takhsisSate;
    public BigDecimal amalkardSate;
    public BigDecimal amalkardTaahodi;
    public BigDecimal amalkardKol;
    public BigDecimal ghabelTakhsis;


    @Override
    public String toString() {
        return "Faaliat{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", edare='" + edare + '\'' +
                ", edareURL='" + edareURL + '\'' +
                ", edareKol='" + edareKol + '\'' +
                ", edareKolURL='" + edareKolURL + '\'' +
                ", type='" + type + '\'' +
                ", ghotb='" + ghotb + '\'' +
                ", miz='" + miz + '\'' +
                ", amalkardNameDaryafti=" + amalkardNameDaryafti +
                ", gharardad=" + gharardad +
                ", baghimandeGharardad=" + baghimandeGharardad +
                ", amalkardNameHayeDaryaftiVaBaghimandeGharardad=" + amalkardNameHayeDaryaftiVaBaghimandeGharardad +
                ", ghabelTakhsismenhayeBaghimandehGharardad=" + ghabelTakhsismenhayeBaghimandehGharardad +
                ", ghanoon=" + ghanoon +
                ", mosavabSate=" + mosavabSate +
                ", takhsisSate=" + takhsisSate +
                ", amalkardSate=" + amalkardSate +
                ", amalkardTaahodi=" + amalkardTaahodi +
                ", amalkardKol=" + amalkardKol +
                ", ghabelTakhsis=" + ghabelTakhsis +
                '}';
    }
}
