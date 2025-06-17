package main;

import magazyn.*;
import java.util.Calendar;
import magazyn.Towar;
import dokumenty.Faktura;

//ZEWNETRZNY RABAT
import rabatlosowy.LosowyRabat;
import rabaty.Konfiguracja;

public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();
		
		//Tworzymy towary
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");
		
		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);

        Konfiguracja.getInstance().getPrinter().drukujFakture(f);
		
		//TEST ZEWN. rabatu
		LosowyRabat lr=new LosowyRabat();
		System.out.println(lr.losujRabat());

        Subcategory root = new Subcategory("Katalog Produktów");

        // Kategorie
        Category electronics = new Category("Elektronika");
        electronics.dodajTowar(new Towar(1500.0, "Telewizor"));
        electronics.dodajTowar(new Towar(200.0, "Radio"));

        Category fruit = new Category("Owoce");
        fruit.dodajTowar(new Towar(3.0, "Jabłko"));
        fruit.dodajTowar(new Towar(2.5, "Banan"));

        // Podkategorie
        Subcategory computers = new Subcategory("Komputery");
        computers.dodajTowar(new Towar(3000.0, "Laptop"));
        computers.dodajTowar(new Towar(100.0, "Mysz komputerowa"));

        // Składamy drzewo
        root.dodaj(electronics);
        root.dodaj(fruit);
        root.dodaj(computers);

        root.drukuj("");  // rekurencyjny wydruk całego katalogu
	}
}
