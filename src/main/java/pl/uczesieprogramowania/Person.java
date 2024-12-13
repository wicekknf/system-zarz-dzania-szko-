package pl.uczesieprogramowania;

import java.io.Serializable;

// Stworzyłem klasę abstrakcyjną, którą wykorzystam do tworzenia obiektów, takich jak nauczyciel czy uczeń
public abstract class Person implements Serializable {
/*    zdefiniujmy uniwersalne dla nas pola klasy,
   które będą dziedziczone przez inne klasy */
    protected final String name;
    private final String lastName;
    protected final String dateOfBirth;

//    Konstruktor klasy, który później jest dziedziczony:
    public Person(String name, String lastName, String dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

//    Metoda, któą wykorzystamy wobec każdego obiektu jak nauczyciel czy uczeń:
    public void infoAboutPerson() {
        System.out.println("Imię: " + name);
        System.out.println("Nazwisko: " + lastName);
        System.out.println("Data urodzenia: " + dateOfBirth);
    }

    public String getName() { //metoda zwracająca imię
        return name;
    }

    public String getLastName() { //metoda zwracająca nazwisko
        return lastName;
    }

}
