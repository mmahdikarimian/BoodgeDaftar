package ir.dte.boodgedaftar.model;

import java.math.BigDecimal;

public class Faaliat {
    public BigDecimal id;
    public String title;
    public String edare;
    public String edareKol;
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
                "Id=" + id +
                ", Title='" + title + '\'' +
                ", Edare='" + edare + '\'' +
                ", EdareKol='" + edareKol + '\'' +
                ", Type='" + type + '\'' +
                ", Ghotb='" + ghotb + '\'' +
                ", Miz='" + miz + '\'' +
                ", AmalkardNameDaryafti=" + amalkardNameDaryafti +
                ", Gharardad=" + gharardad +
                ", BaghimandeGharardad=" + baghimandeGharardad +
                ", AmalkardNameHayeDaryaftiVaBaghimandeGharardad=" + amalkardNameHayeDaryaftiVaBaghimandeGharardad +
                ", GhabelTakhsismenhayeBaghimandehGharardad=" + ghabelTakhsismenhayeBaghimandehGharardad +
                ", Ghanoon=" + ghanoon +
                ", MosavabSate=" + mosavabSate +
                ", TakhsisSate=" + takhsisSate +
                ", AmalkardSate=" + amalkardSate +
                ", AmalkardTaahodi=" + amalkardTaahodi +
                ", AmalkardKol=" + amalkardKol +
                ", GhabelTakhsis=" + ghabelTakhsis +
                '}';
    }
}
