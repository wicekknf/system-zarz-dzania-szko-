package pl.uczesieprogramowania;

import java.io.Serializable;

// klasa, która tworzy obiekt Student dziedzicząc po klasie Person
public class Student extends Person implements Serializable {
//    pole klasy
    private String groupClass;

//    konstruktor, do utworzenia obiektu Stusdent
    public Student(String name, String lastName, String dateOfBirth, String groupClass) {
        super(name, lastName, dateOfBirth);
        this.groupClass = groupClass;
    }

//    aby mieć dostęp do odczytu i przypisania tworzymy odpowiednio "getter" oraz "setter"
    public String getGroupClass() { //metoda do pobrania grupy/klasy ucznia
        return groupClass;
    }


}
