package course_project.services.reading_writing_files;

import course_project.packages.logger.Logging;
import course_project.services.validition.Validator;

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
                Logging.EXECUTION_LOG(new Date(),"Start reading file " + fileEntry.getName() + "\n");
                Validator.path = String.valueOf(fileEntry);
                Validator.validationNameDocuments(fileEntry.getName());
            }
        }
    }
    public static  void readingWritingFiles(File path){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            Validator.validationNameDocuments(String.valueOf(path));
            String line = reader.readLine();
            while (line != null) {
                //TODO сделать валидатор под задачу
                System.out.println(line);
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
