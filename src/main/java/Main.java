import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Service s = new Service();

    boolean programDziala = true;

    while (programDziala) {
      System.out.println("Wybierz opcję:");
      System.out.println("1. Wyświetl zapisane dane studentów");
      System.out.println("2. Dodaj nowego studenta");
      System.out.println("0. Wyjdź z programu");

      int wybor = scanner.nextInt();

      try {
        switch (wybor) {
          case 1:
            System.out.println("Zapisane dane studentów:");
            for (Student student : s.getStudents()) {
              System.out.println(student.ToString());
            }
            break;
          case 2:
            System.out.println("Podaj imię nowego studenta:");
            String imie = scanner.next();
            System.out.println("Podaj nazwisko nowego studenta:");
            String nazwisko = scanner.next();
            System.out.println("Podaj numer albumu nowego studenta:");
            int numerAlbumu = scanner.nextInt();
            System.out.println("Podaj wiek nowego studenta:");
            int wiek = scanner.nextInt();
            s.addStudent(new Student(imie, nazwisko, numerAlbumu, wiek));
            System.out.println("Nowy student został dodany.");
            break;
          case 0:
            System.out.println("Program zostanie zamknięty.");
            programDziala = false;
            break;
          default:
            System.out.println("Niepoprawny wybór. Wybierz ponownie.");
        }
      } catch (IOException e) {
        System.out.println("Wystąpił błąd podczas operacji na pliku.");
      }
    }
    scanner.close();
  }
}