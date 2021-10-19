package kolokwium1.gr2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(final String... args){

        // przykladowe wywolanie

        copy("C:\\test", "C:\\targetTest", "x");

    }

    private static void copy(String sourceLocation, String targetLocation, String text){

        File sourceDir = new File(sourceLocation);
        if (!sourceDir.exists()){
            System.out.println("Podana lokalizacja nie istnieje");
            return;
        }

        if (!sourceDir.isDirectory()){
            sourceDir = sourceDir.getParentFile();
        }

        File targetDir = new File(targetLocation);
        if (!targetDir.exists()){
            System.out.println("Podana lokalizacja docelowa nie istnieje.");
            return;
        }
        if (!targetDir.isDirectory()){
            targetDir = targetDir.getParentFile();
        }

        final File[] filesToMove = sourceDir.listFiles((dir, name) -> name.contains(text));

        for (File file : filesToMove) {
            final File targetFile = new File(targetDir, file.getName());
            if (targetFile.exists()){
                System.out.println("Plik: " + file.getName() + " istnieje juz w docelowej lokalizacji.");
                continue;
            }
            try{
                Files.move(file.toPath(), targetFile.toPath());
            }catch (IOException e){
                System.out.println("Blad podczas przenoszenia pliku: " + file.getName());
                e.printStackTrace();
            }
        }
    }

}
