package kolokwium1.gr1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args){

        // przykladowe wywolanie

        final List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("publisherName", "Kraków", "Kamil Nowak", "Tytul", 2));
        bookList.add(new Book("qwerty", "Kraków", "Jan Kowalski", "Tytul2", 2));
        bookList.add(new Book("wydawca", "Kraków", "Kuba Kudas", "Tytul3", 2));

        saveToFile(bookList, "C:\\test", "zapis.bin");
    }

    private static void saveToFile(final List<Book> bookList, final String location, final String fileName){
        final File dir = new File(location);
        if (!dir.exists()){
            System.out.println("Podana lokalizacja nie istnieje");
            return;
        }
        if (!dir.isDirectory()){
            System.out.println("Podana lokalizacja nie jest katalogiem");
            return;
        }
        final File file = new File(dir, fileName);
        try{
            final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

            for (Book book : bookList) {
                oos.writeObject(book);
            }

            oos.close();

            System.out.println("Obiekty zostaly zapisane.");

        }catch (IOException e){
            System.out.println("Wystapil blad podczas zapisu.");
            e.printStackTrace();
        }
    }

}
