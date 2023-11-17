package ir.dte.boodgedaftar.model;

import java.math.BigDecimal;

public class EdareViewModel {
    public String edareName;
    public String edareKolName;
    public BigDecimal takhsis = BigDecimal.ZERO;
    public BigDecimal mosavab = BigDecimal.ZERO;
    public BigDecimal amalkard = BigDecimal.ZERO;
    public BigDecimal amalkardNameDaryafti = BigDecimal.ZERO;
    public BigDecimal pardakhti = BigDecimal.ZERO;
    public BigDecimal gharardad = BigDecimal.ZERO;




    @Override
    public String toString() {
        return "EdareViewModel{" +
                "edareName='" + edareName + '\'' +
                ", takhsis=" + takhsis +
                ", mosavab=" + mosavab +
                ", amalkard=" + amalkard +
                ", amalkardNameDaryafti=" + amalkardNameDaryafti +
                ", pardakhti=" + pardakhti +
                ", gharardad=" + gharardad +
                '}';
    }
}
