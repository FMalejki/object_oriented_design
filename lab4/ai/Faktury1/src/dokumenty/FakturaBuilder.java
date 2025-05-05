package dokumenty;

import java.util.Date;
import rabaty.Rabat;
import rabaty.BrakRabat;

public class FakturaBuilder {
    private Date dataSprzedazy;
    private String kontrahent;
    private Rabat rabat = new BrakRabat(); // domyślna strategia: brak rabatu

    public FakturaBuilder forKontrahent(String kontrahent) {
        this.kontrahent = kontrahent;
        return this;
    }

    public FakturaBuilder atDate(Date data) {
        this.dataSprzedazy = data;
        return this;
    }

    public FakturaBuilder withRabat(Rabat rabat) {
        this.rabat = rabat;
        return this;
    }

    public Faktura build() {
        return new Faktura(dataSprzedazy, kontrahent, rabat);
    }
}
