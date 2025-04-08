package pl.edu.agh.dronka.shop.model;

import java.time.LocalDate;

public enum Type {
    BOOLEAN {
        @Override
        public Object parse(String value) {
            return Boolean.valueOf(value);
        }
    },
    INTEGER {
        @Override
        public Object parse(String value) {
            return Integer.valueOf(value);
        }
    },
    ENUM {
        @Override
        public Object parse(String value) {
            // Nie było sprecyzowane jaki Enum, więc tutaj po prostu zwracam tego samego Stringa
            return value;
        }
    },
    STRING {
        @Override
        public Object parse(String value) {
            return value;
        }
    },

    DATATYPE {
        @Override
        public Object parse(String value) { return LocalDate.parse(value); }
    };

    public abstract Object parse(String value);
}
