package magazyn;

import java.util.ArrayList;
import java.util.List;

public class Subcategory extends KategoriaComponent {
    private List<KategoriaComponent> children = new ArrayList<>();

    public Subcategory(String nazwa) {
        super(nazwa);
    }

    @Override
    public void dodaj(KategoriaComponent component) {
        children.add(component);
    }

    @Override
    public void usun(KategoriaComponent component) {
        children.remove(component);
    }

    @Override
    public void drukuj(String prefix) {
        System.out.println(prefix + "+ Podkategoria: " + nazwa);
        // najpierw towary w tej podkategorii
        for (var t : towary) {
            System.out.println(prefix + "    * "
                    + t.getNazwa() + " (cena: " + t.getCena() + ")");
        }
        // potem rekurencyjnie dzieci
        for (var child : children) {
            child.drukuj(prefix + "    ");
        }
    }
}
