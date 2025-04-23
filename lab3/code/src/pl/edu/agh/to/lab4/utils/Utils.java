package pl.edu.agh.to.lab4.utils;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static int getBirthYearFromPesel(String pesel) {
        if (pesel == null || pesel.length() != 11) {
            throw new IllegalArgumentException("Nieprawidłowy numer PESEL.");
        }

        int year = Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));

        int birthYear;

        if (month >= 1 && month <= 12) {
            birthYear = 1900 + year;
        } else if (month >= 21 && month <= 32) {
            birthYear = 2000 + year;
        } else if (month >= 41 && month <= 52) {
            birthYear = 2100 + year;
        } else if (month >= 61 && month <= 72) {
            birthYear = 2200 + year;
        } else if (month >= 81 && month <= 92) {
            birthYear = 1800 + year;
        } else {
            throw new IllegalArgumentException("Nieprawidłowy miesiąc w numerze PESEL.");
        }
        return birthYear;
    }

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static <T> List<T> flatifyList(Collection<? extends Collection<? extends T>> nested) {
        return nested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
