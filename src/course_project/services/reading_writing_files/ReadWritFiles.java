package course_project.services.reading_writing_files;

import course_project.packages.logger.Logging;

import java.io.*;
import java.util.Date;

public class ReadWritFiles {
    public static void readingFolders(String myFolder) {
        File folder = new File(myFolder);
        listFilesForFolder(folder);
    }
    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                readingWritingFiles(fileEntry);
            }
        }
    }
    public static  void readingWritingFiles(File path){
        Logging.EXECUTION_LOG(new Date(),"Start reading file\n");
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = reader.readLine();
            while (line != null) {
                //TODO сделать валидатор под задачу
                System.out.println(line);
                //Validator.validationNameDocuments(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        } catch (IOException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        }
        Logging.EXECUTION_LOG(new Date(), "End of file reading\n");
    }
}
