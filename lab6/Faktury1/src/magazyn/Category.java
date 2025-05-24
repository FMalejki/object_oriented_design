package magazyn;

public class Category extends KategoriaComponent {

    public Category(String nazwa) {
        super(nazwa);
    }

    @Override
    public void drukuj(String prefix) {
        System.out.println(prefix + "- Kategoria: " + nazwa);
        for (var t : towary) {
            System.out.println(prefix + "    * "
                    + t.getNazwa() + " (cena: " + t.getCena() + ")");
        }
    }
}
