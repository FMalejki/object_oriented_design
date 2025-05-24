package magazyn;

import java.util.List;

public abstract class KategoriaComponent {
    protected String nazwa;
    protected List<Towar> towary;

    public KategoriaComponent(String nazwa) {
        this.nazwa = nazwa;
        this.towary = new java.util.ArrayList<>();
    }

    public void dodajTowar(Towar towar) {
        towary.add(towar);
    }

    public void usunTowar(Towar towar) {
        towary.remove(towar);
    }

    public void dodaj(KategoriaComponent component) {
        throw new UnsupportedOperationException("Nie można dodać podkategorii");
    }

    public void usun(KategoriaComponent component) {
        throw new UnsupportedOperationException("Nie można usunąć podkategorii");
    }

    public abstract void drukuj(String prefix);
}
