package pl.uczesieprogramowania;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Wiktor_Łaziński {
    public static void main(String[] args) {


        /* Program zarządzania szkołą - tworzy obiekty Przedmiot, Nauczyciel i Uczeń.
        W kodzie znajdują się nazwy po polsku. Wyjątkowo w tym projekcie zastosowałem taką metodę.
        Takie praktyki "polish-english" są niedopuszczalne i na co dzień ich nie stosuję.
        Kod powinien w całości zawierać nazwy po angielsku. */



//  stworzenie zmiennych potrzebnych w programie

        boolean loop = true; // Zmienna potrzebna do głównej pętli programu
        int przedmiotDoNauczania = 0;
        int uczenDoUsuniecia = -1;
        int nauczycielDoUsuniecia = -1;

        final String FILE_NAME_SUBJECTS = "przedmioty.dat"; // stworzenie stałej z nazwą pliku listy przedmiotów
        final String FILE_NAME_TEACHERS = "nauczyciele.dat"; // stworzenie stałej z nazwą pliku listy nauczycieli
        final String FILE_NAME_STUDENTS = "uczniowie.dat"; // stworzenie stałej z nazwą pliku listy uczniów

//  zainicjowanie list na użytek programu => do zapisu & odczytu plików

        List<Subject> listaPrzedmiotow;
        List<Teacher> listaNauczycieli;
        List<Student> listaUczniow;


//        poniższe trzy bloki kodu służą do przypisaniu listy w zależności, czy plik został utworzony czy nie

        File filePrzedmioty = new File(FILE_NAME_SUBJECTS); //stworzenie obiektu pliku z uprzednio stworzoną nazwą
        if (filePrzedmioty.exists()) { //sprawdzenie, czy lista została już utworzona
            listaPrzedmiotow = odczytListyPrzedmiotow(FILE_NAME_SUBJECTS); //jeżeli plik istnieje, dane z pliku zostają przypisane do listy
            System.out.println("Odczytano przedmioty z pliku"); //informacja dla użytkownika
        } else {
            listaPrzedmiotow = new ArrayList<>(); //jeżeli plik wcześniej nie istniał, tworzony jest obiekt listy
            System.out.println("Utworzono nową listę obiektów"); //informacja dla użytkownika
        }


        File fileNauczyciele = new File(FILE_NAME_TEACHERS); //stworzenie obiektu pliku z uprzednio stworzoną nazwą
        if (fileNauczyciele.exists()) { //sprawdzenie, czy lista została już utworzona
            listaNauczycieli = odczytListyNauczycieli(FILE_NAME_TEACHERS); //jeżeli plik istnieje, dane z pliku zostają przypisane do listy
            System.out.println("Odczytano nauczycieli z pliku"); //informacja dla użytkownika
        } else {
            listaNauczycieli = new ArrayList<>(); //jeżeli plik wcześniej nie istniał, tworzony jest obiekt listy
            System.out.println("Utworzono nową listę nauczycieli"); //informacja dla użytkownika
        }


        File fileUczniowie = new File(FILE_NAME_STUDENTS); //stworzenie obiektu pliku z uprzednio stworzoną nazwą
        if (fileUczniowie.exists()) { //sprawdzenie, czy lista została już utworzona
            listaUczniow = odczytListyUczniow(FILE_NAME_STUDENTS);  //jeżeli plik istnieje, dane z pliku zostają przypisane do listy
            System.out.println("Odczytano uczniów z pliku"); //informacja dla użytkownika
        } else {
            listaUczniow = new ArrayList<>(); //jeżeli plik wcześniej nie istniał, tworzony jest obiekt listy
            System.out.println("Utworzono nową listę uczniów"); //informacja dla użytkownika
        }


        Scanner scanner = new Scanner(System.in); // stworzenie obiektu scanner aby móc przyjmować treść od użytkownika

//        utworzenie głównej pętli programu w celu przyjmowania komend od użytkownika
//        oraz zwracania informacji

//        Na początku program zada pytania aby określić co użytkownik chce zrobić:

            System.out.println("\nProgram zarządzania szkołą\nAutor programu: Wiktor Łaziński\nNumer albumu: 122628\nNazwa szkoły: Społeczna Akademia Nauk\nPraca zaliczeniowa z przedmiotu: \"Podstawy programowania\"\nWykładowca: Andrzej Rychlik\n"); // Informacje o autorze programu

        while (loop) { // rozpoczęcie głównej pętli programu z wykorzystaniem uprzednio stworzonej zmiennej "loop"
            int indeksNauczyciela = -1; // stworzenie zmiennej potrzebnej do obsługi zapytań dotyczących listy nauczyciela
            int indeksUcznia = -1; // stworzenie zmiennej potrzebnej do obsługi zapytań dotyczących listy uczniów

//          poniżej znajduje się kod, który wypisuje informacje dla użytkownika będący zapytaniem o dalsze kroki - użytkownik poprzez wybranie odpowiedniej liczby dokonuje wyboru co dalej ma wykonać program

            System.out.println("Co chcesz zrobić, napisz cyfrę od 1 do 11:");
            System.out.println("1. Dodaj przedmiot:");
            System.out.println("2. Dodaj nauczyciela do listy:");
            System.out.println("3. Usuń nauczyciela z listy");
            System.out.println("4. Dodaj ucznia do listy");
            System.out.println("5. Usuń ucznia z listy");
            System.out.println("6. Wyświetl wszystkie przedmioty na liście");
            System.out.println("7. Wyświetl wszystkich nauczycieli z listy");
            System.out.println("8. Wyświetl wszystkich uczniów z listy");
            System.out.println("9. Wyczyść wszystko.");
            System.out.println("10. Organizacja zajęć");
            System.out.println("11. Wyjdź");


            String wybor = scanner.nextLine(); // zapisanie w zmiennej "wybór" informacji od użytkownika będący wyborem dalszej czynności


//            instrukcje warunkowe poniżej w zależności od wyboru użytkownika (cyfry od 1 do 11)
//            poprowadzą program dalej

            if (wybor.equals("1")) {  // instrukcja warunkowa, która sprawdza czy wybór użytkownika jest równy 1
                System.out.println("Podaj nazwę przedmiotu:"); //  jeżeli wybór użytkownika wynosił 1 to program pyta o nazwę przedniomu do dodania

                String nazwaPrzedmiotu = scanner.nextLine(); // definiuję zmienną nazwaPrzedmiotu i przypisuję do niej informację od użytkownika o nazwie przedmiotu

                System.out.println("Podaj opis przedmiotu:"); // program pyta o opis przedmiotu
                String opisPrzedmiotu = scanner.nextLine(); // definiuję zmienną opisPrzedmiotu i przypisuję do niej informację od użytkownika o przedmiocie

                Subject subject = new Subject(nazwaPrzedmiotu, opisPrzedmiotu); // na podstawie uprzednio pobranych informacji od użytkownika i przypisaniu ich do zmiennych tworzymy obiekt typu Subject
                listaPrzedmiotow.add(subject); // utworzony przedmiot dodano do listy przedmiotów

//                informacja zwrotna od programu dla użytkownika

                System.out.println("Przedmiot " + subject.getNazwa() + " dodany do listy przedmiotów"); // program informuje uzytkownika o dodaniu przedmiotu do listy przedmiotów


            } else if (wybor.equals("2")) { // sprawdzenie, czy użytkownik wybrał opcję nr 2

                boolean czyJestPrzedmiot = false; //  tworzona jest zmienna, która pomoże sprawdzić czy lista przedmiotów jest pusta
                System.out.println("Podaj nazwę przedmiotu nauczanego:"); // program wypisuje w konsloli prośbę o nazwę przedmiotu nauczanego przez nauczyciela

                String przedmiotNauczyciela = scanner.nextLine(); // przypisanie do zmiennej przedmiotNauczyciela nazwę przedmiotu podaną przez użytkownika


                assert listaPrzedmiotow != null;
                for (Subject przedmiotCzyJest : listaPrzedmiotow) { // pętla for-each sprawdzająca listę obiektów Subject, w której umieszczono warunek poniżej
                    if (przedmiotCzyJest.getNazwa().equals(przedmiotNauczyciela)) { // warunek sprawdzający czy obiekt Subject podany przez użytkownika znajduje się na liście
                        czyJestPrzedmiot = true; // jeśli podany przez użytkownika przedmiot znajduje się na liście do zmiennej czyJestPrzedmiot program przypisuje wartość true
                        przedmiotDoNauczania = listaPrzedmiotow.indexOf(przedmiotCzyJest); // jeśli podany przez użytkownika przedmiot znajduje się na liście do zmiennej przedmiotDoNauczania przypisywany jest indeks z listy obiektów Subject
                    }
                }



                if (czyJestPrzedmiot) {  // w zależności od tego czy przedmiot znajduje się na liście program pozwala dodać nauczyciela
                    System.out.println("Podaj imię nauczyciela:"); // jeśli warunek wyżej pozwoli program zada użytkownikowi pytanie o imię nauczyciela
                    String nameOfTeacher = scanner.nextLine();  // i przypisze imie do zadeklarowanej zmiennej nameOfTeacher

                    System.out.println("Podaj nazwisko nauczyciela:");  // program pyta o nazwisko nauczyciela
                    String lastNameOfTeacher = scanner.nextLine(); //  i przypisuje nazwisko do zadeklarowanej zmiennej lastNameOfTeacher

                    System.out.println("Podaj datę urodzenia nauczyciela (dd-mm-rrrr):");  //  program zadaje mytanie o datę urodzin nauczyciela
                    String dateOfBirthTeacher = scanner.nextLine();  // i przypisuje datę urodzin do zadeklarowanej zmiennej dateOfBirthTeacher

                    Teacher teacher = new Teacher(nameOfTeacher, lastNameOfTeacher, dateOfBirthTeacher, listaPrzedmiotow.get(przedmiotDoNauczania));  // na podstawie danych od użytkownika powyżej program tworzy obiekt nauczyciel

                    assert listaNauczycieli != null;
                    listaNauczycieli.add(teacher);  //  program dodaje stworzony obiekt Teacher do listy obiektów typu Teacher
                    System.out.println("Nauczyciel: " + teacher.getName() + " został dodany do listy.");  // Wyświetlony zostaje komunikat o dodaniu nauczyciela do listy

                } else {


                    System.out.println("Nie ma takiego przedmiotu. Proszę dodaj najpierw przedmiot."); // Jeśli lista przedmiotów jest pusta program nie pozwoli na stworzenie obiektu Teacher i wyświetli komunikat
                }

            } else if (wybor.equals("3")) {  // sprawdzenie, czy użytkownik wybrał opcję nr 3
                System.out.println("Podaj imię nauczyciela do usunięcia:");  // program pyta o imię nauczyciela do usunięcia z listy
                String nameTeacherToDelete = scanner.nextLine();  // informacja od użytkownika zapisywana jest do zadeklarowanej zmiennej nameTeacherToDelete

                System.out.println("Podaj nazwisko nauczyciela do usunięcia:");  // program pyta o nazwisko nauczyciela do usunięcia z listy
                String lastNameTecherToDelete = scanner.nextLine();  // jak wyżej informacja zapisywana jest do zadeklarowanej w tym miejscu zmiennej lastNameTeacherToDelete

//                na podstawie danych od użytkownika powyżej program usuwa nauczyciela z listy:

                assert listaNauczycieli != null; // zabezpieczenie, przed potencjalnym nullem zwracanym przez listę
                for (Teacher teacher : listaNauczycieli) { //iteracja po całej liście nauczycieli
                    if (teacher.getName().equals(nameTeacherToDelete) && teacher.getLastName().equals(lastNameTecherToDelete)) {  //poszukiwanie obiektu Nauczyciel do usunięcia
//                        uzyskuję indeks nauczyciela do usunięcia
                        nauczycielDoUsuniecia = listaNauczycieli.indexOf(teacher);  //znalezienie indeksu nauczyciela do usunięcia
                    }
                }
//                na podstawie uzyskanego indeksu w liście program usuwa odpowiedniego nauczyciela:

                if (nauczycielDoUsuniecia >= 0) {  // sprawdzanie, czy indeks został przypisany
                    Teacher teacher = listaNauczycieli.get(nauczycielDoUsuniecia); //usunięcie nauczyciela z listy
                    listaNauczycieli.remove(teacher);
                    nauczycielDoUsuniecia = -1; //ponowne ustawienie wartości zmiennej na -1
                    System.out.println("Nauczyciel " + teacher.getName() + " " + teacher.getLastName() + " został usunięty z listy"); //informacja dla użytkownika
                } else {

//                    jeżeli program nie znajdzie nauczyciela na liście wyświetla odpowiedni komunikat

                    System.out.println("Nie ma takiego nauczyciela na liście."); //informacja dla użytkownika
                }
            } else if (wybor.equals("4")) {

//                program prosi o odpowiednie dane w celu stworzenia obiektu uczeń => poniżej zbierane są dane do zapełnienia konstruktora obiektu Student

                System.out.println("Podaj imię ucznia:"); //informacja dla użytkownika
                String studentName = scanner.nextLine();

                System.out.println("Podaj nazwisko ucznia:"); //informacja dla użytkownika
                String studentLastName = scanner.nextLine();

                System.out.println("Podaj datę urodzenia (dd-mm-rrrr):"); //informacja dla użytkownika
                String studentDateOfBirth = scanner.nextLine();

                System.out.println("Podaj klasę ucznia:"); //informacja dla użytkownika
                String studentClass = scanner.nextLine();

//                na podstawie podanych wyżej danych program tworzy obiekt uczeń za pomocą konstruktora

                Student student = new Student(studentName, studentLastName, studentDateOfBirth, studentClass); //stworzenie obiektu Student na podstawie danych otrzymanych od użytkownika
                assert listaUczniow != null; //zabezpieczenie przed null zwracanym przez listę
                listaUczniow.add(student); //dodanie obiektu Student do listy uczniów
                System.out.println("Uczeń " + student.getName() + " " + student.getLastName() + " został dodany do listy"); //informacja dla użytkownika

            } else if (wybor.equals("5")) {

//                Program oczekuje od użytkownika danych w celu usunięcia obiektu uczeń z listy:

                System.out.println("Podaj imię ucznia do usunięcia:"); //informacja dla użytkownika
                String nameStudentToDelete = scanner.nextLine();

                System.out.println("Podaj nazwisko ucznia do usunięcia:"); //informacja dla użytkownika
                String lastNameStudentToDelete = scanner.nextLine();

//              Na podstawie danych program iteruje po liście w celu uzyskania nr indeksu odpowiedniego ucznia na liście:

                assert listaUczniow != null;
                for (Student student : listaUczniow) {  //iteracja po liście uczniów
                    if (student.getName().equals(nameStudentToDelete) && student.getLastName().equals(lastNameStudentToDelete)) {  //poszukiwanie obiektu Student do usunięcia

//                        Program usuwa obiekt uczeń z listy na podstawie indeksu uzyskanego wyżej (wykorzystuję zmienną zadeklarowaną wcześniej):

                        uczenDoUsuniecia = listaUczniow.indexOf(student);  //przypisanie indeksu szukanego obiektu do usunięcia do zmiennej uczenDoUsuniecia
                    }
                }
                if (uczenDoUsuniecia >= 0) { //sprawdzeie, czy znaleziono obiekt
                    Student student = listaUczniow.get(uczenDoUsuniecia);  //przypisanie obiektu uczen do tymczasowej zmiennej
                    listaUczniow.remove(student);  //usunięcie Obiektu uczeń z listy
                    uczenDoUsuniecia = -1; //ponowne ustawnienie zmiennej na -1
                    System.out.println("Uczeń " + student.getName() + " " + student.getLastName() + " został usunięty z listy."); //informacja dla użytkownika
                } else {
                    System.out.println("Nie ma takiego ucznia na liście"); //informacja dla użytkownika
                }

//                Poniżej program iteruje po liście przedmiotów wypisując iformacje o nazwie i opisie każdego przedmiotu:

            } else if (wybor.equals("6")) {
                assert listaPrzedmiotow != null; //zabezpieczenie przed null zwracanym przez listę
                for (Subject subject : listaPrzedmiotow) {
                    System.out.println("Przedmiot: " + subject.getNazwa()); //informacja dla użytkownika
                    System.out.println("Opis przedmiotu: " + subject.getOpis()); //informacja dla użytkownika
                    System.out.println();
                }

//                program iteruje po liście nauczycieli wypisując informacje o nauczycielach z listy:

            }else if (wybor.equals("7")) {
                assert listaNauczycieli != null;  //zabezpieczenie przed nullem zwracanym przez listę
                for (Teacher teacher : listaNauczycieli) {
                    System.out.println("Nauczyciel:"); //informacja dla użytkownika
                    teacher.infoAboutPerson();
                    System.out.println("Nauczany przedmiot: " + teacher.getSubject().getNazwa()); //informacja dla użytkownika
                    System.out.println();
                }

//                program iteruje po liście uczniów wypisując informacje o każdym obiekcie na liście:

            } else if (wybor.equals("8")) {
                assert listaUczniow != null;  //zabezpieczenie przed nullem zwracanym przez listę
                for (Student student : listaUczniow) {
                    System.out.println("Uczeń:"); //informacja dla użytkownika
                    student.infoAboutPerson();
                    System.out.println("Klasa: " + student.getGroupClass()); //informacja dla użytkownika
                    System.out.println();
                }



            } else if (wybor.equals("9")) {

                assert listaPrzedmiotow != null; //zabezpieczenie przed nullem zwracanym przez listę
                listaPrzedmiotow.clear(); // wyczyszczenie listy
                assert listaNauczycieli != null; //zabezpieczenie przed nullem zwracanym przez listę
                listaNauczycieli.clear(); // wyczyszczenie listy
                assert listaUczniow != null; //zabezpieczenie przed nullem zwracanym przez listę
                listaUczniow.clear(); // wyczyszczenie listy
                System.out.println("Wyczyszczono wszystkie listy"); //informacja dla użytkownika


        } else if (wybor.equals("10")) { //po tym wyborze program pokazuje listy uczniów, nauczycieli i przedmiotów
                assert listaPrzedmiotow != null;
                if(!listaPrzedmiotow.isEmpty()) {
                    System.out.println("Nauczane przedmioty:"); //informacja dla użytkownika
                    for (Subject subject : listaPrzedmiotow) {
                        System.out.println("Przedmiot: " + subject.getNazwa()); //informacja dla użytkownika
                        System.out.println("Opis przedmiotu: " + subject.getOpis()); //informacja dla użytkownika
                        System.out.println();
                    }
                }


                assert listaNauczycieli != null;

                if (!listaNauczycieli.isEmpty()){
                    System.out.println("-----------------------------------------");
                    System.out.println("Nauczyciele:"); //informacja dla użytkownika
                    for (Teacher teacher : listaNauczycieli) {
                        System.out.println("Nauczyciel:"); //informacja dla użytkownika
                        teacher.infoAboutPerson();
                        System.out.println("Nauczany przedmiot: " + teacher.getSubject().getNazwa()); //informacja dla użytkownika
                        System.out.println();
                    }
                }

                assert listaUczniow != null;

                if (!listaUczniow.isEmpty()) {
                    System.out.println("-----------------------------------------");
                    System.out.println("Uczniowie:"); //informacja dla użytkownika
                    for (Student student : listaUczniow) {
                        System.out.println("Uczeń:");
                        student.infoAboutPerson();
                        System.out.println("Klasa: " + student.getGroupClass());
                        System.out.println();
                    }
                }



            } else if (wybor.equals("11")) {

//                wybranie tej liczby powoduje wyjście z programu

                loop = false;
            }


        }


        zapiszListePrzedmiotow(FILE_NAME_SUBJECTS, listaPrzedmiotow); //metoda zapisująca listę przedmiotów do pliku
        zapiszListeNauczycieli(FILE_NAME_TEACHERS,listaNauczycieli); //metoda zapisująca listę nauczycieli do pliku
        zapiszListeUczniow(FILE_NAME_STUDENTS, listaUczniow); //metoda zapisująca listę uczniów do pliku

    }
    public static void zapiszListePrzedmiotow(String nazwaPliku, List<Subject> listaPrzedmiotow) {  //metoda zapisująca listę do pliku
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) { // łapanie wyjątku za pomocą try i tworzenie obiektu pozwalającego na zapis pliku
            oos.writeObject(listaPrzedmiotow); //wywołanie metody na obiekcie zapisującą plik
            System.out.println("Lista przedmiotów została zapisana do pliku: " + nazwaPliku);
        } catch (IOException e) { //przedstawianie wyjątku i informacja o błędzie
            System.out.println("Nie zapisano listy przedmiotów");
            e.printStackTrace();
        }
    }
    public static List<Subject> odczytListyPrzedmiotow(String nazwaPLiku) { //metoda odczytująca listę obiektów z pliku
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nazwaPLiku))) { //stworzenie obiektu pozwalającego odczytać plik
            return (List<Subject>) ois.readObject(); //wywołanie metody na obiekcie odczytującej listę obiektów
        } catch (IOException | ClassNotFoundException e) { //łapanie wyjątku i informacja o problemie dla użytkownika
            e.printStackTrace();
            System.out.println("Nie odczytano pliku przedmiotów");
            return null;
        }
    }

//    poniższe metody działają identycznie jak opisane powyżej, z tą różnicą, że obsługują listy innych obiektów
    public static void zapiszListeNauczycieli(String nazwaPliku, List<Teacher> listaPrzedmiotow) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            oos.writeObject(listaPrzedmiotow);
            System.out.println("Lista nauczycieli została zapisana do pliku: " + nazwaPliku);
        } catch (IOException e) {
            System.out.println("Nie zapisano listy nauczycieli");
            e.printStackTrace();
        }
    }
    public static List<Teacher> odczytListyNauczycieli(String nazwaPLiku) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nazwaPLiku))) {
            return (List<Teacher>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie odczytano pliku nauczycieli");
            return null;
        }
    }

    public static void zapiszListeUczniow(String nazwaPliku, List<Student> listaUczniow) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            oos.writeObject(listaUczniow);
            System.out.println("Lista uczniów została zapisana do pliku: " + nazwaPliku);
        } catch (IOException e) {
            System.out.println("Nie udało się zapisać listy uczniów");
            e.printStackTrace();
        }
    }
    public static List<Student> odczytListyUczniow(String nazwaPLiku) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nazwaPLiku))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie odczytano pliku uczniów");
            return null;
        }
    }
}