package ir.dte.boodgedaftar.model;

import java.math.BigDecimal;

public class EdareKolViewModel {
    public String edareKolName;
    public BigDecimal takhsis = BigDecimal.ZERO;
    public BigDecimal mosavab = BigDecimal.ZERO;
    public BigDecimal amalkard = BigDecimal.ZERO;
    public BigDecimal amalkardNameDaryafty = BigDecimal.ZERO;
    public BigDecimal pardakhti = BigDecimal.ZERO;
    public BigDecimal gharardad = BigDecimal.ZERO;

    @Override
    public String toString() {
        return "EdareKolViewModel{" +
                "edareKolName='" + edareKolName + '\'' +
                ", takhsis=" + takhsis +
                ", mosavab=" + mosavab +
                ", amalkard=" + amalkard +
                ", amalkardNameDaryafty=" + amalkardNameDaryafty +
                ", pardakhti=" + pardakhti +
                ", gharardad=" + gharardad +
                '}';
    }
}
