package adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);

        System.out.println("Czy okrągły kołek (r=5) pasuje do okrągłego otworu (r=5)?");
        System.out.println(hole.fits(rpeg)); // true

        SquarePeg small_sqpeg = new SquarePeg(5);
        SquarePeg large_sqpeg = new SquarePeg(10);

        SquarePegAdapter small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg);
        SquarePegAdapter large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg);

        System.out.println("Promień adaptera dla małego kwadratowego kołka: " + small_sqpeg_adapter.getRadius());
        System.out.println("Czy mały kwadratowy kołek (w=5) pasuje do okrągłego otworu (r=5)?");
        System.out.println(hole.fits(small_sqpeg_adapter)); // true

        System.out.println("Promień adaptera dla dużego kwadratowego kołka: " + large_sqpeg_adapter.getRadius());
        System.out.println("Czy duży kwadratowy kołek (w=10) pasuje do okrągłego otworu (r=5)?");
        System.out.println(hole.fits(large_sqpeg_adapter)); // false
    }
}
