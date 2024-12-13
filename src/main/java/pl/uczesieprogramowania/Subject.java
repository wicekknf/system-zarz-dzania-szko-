package pl.uczesieprogramowania;

import java.io.Serializable;

// klasa, która stworzy nam obiekt Subject
public class Subject implements Serializable {
//    pola klasy, których użyjemy do stworzenia objektu przedmiot
    private String nazwa;
    private String opis;

//    konstruktor, do tworzenia obiektu przedmiot
    public Subject (String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public String getNazwa() { //metoda do pobrania nazwy
        return nazwa;
    }
    public void setNazwa (String nazwa) { //metoda do ustawienia nazwy
        this.nazwa = nazwa;
    }

    public String getOpis() { //metoda do pobrania opisu przedmiotu
        return opis;
    }

}
