package pl.uczesieprogramowania;

import java.io.Serializable;


//obiekt nauczyciel stworzymy rozszerzając klasę abstrakcyjną Person
public class Teacher extends Person implements Serializable {
//    dodatkowymi polami tego obiektu będą obiekt Subject
    private Subject subject;


    public Teacher(String name, String lastName, String dateOfBirth, Subject subject) {
//      konstruktor będzie się składał z pól klasy, po którje dziedziczymy
        super(name, lastName, dateOfBirth);
//        oraz nowego, który dodaliśmy w tej klasie
        this.subject = subject;
    }

//    aby uzyskać dostęp do "odczytu" Subject dodajmy "getter"
    public Subject getSubject() {
        return subject;
    }


}
