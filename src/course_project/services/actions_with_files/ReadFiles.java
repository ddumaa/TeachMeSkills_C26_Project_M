package course_project.services.actions_with_files;

import course_project.packages.logger.Logging;
import course_project.services.validition.ValidatingStringToNumber;

import java.io.*;
import java.util.Date;

public class ReadFiles {
    //метод считывает строки в файле и отправляет их на проверку, возвращется число
    public static double readingFiles(String path){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            double sum = 0;
            String line = reader.readLine();
            Logging.EXECUTION_LOG(new Date(),"Start reading file -> " + path + "\n");
            while (line != null) {
                sum = ValidatingStringToNumber.checkingLineForAmountAndCurrency(line);
                line = reader.readLine();
            }
            Logging.EXECUTION_LOG(new Date(), "End of file reading\n");
            return sum;
        } catch (FileNotFoundException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        } catch (IOException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        }
        return 0;
    }
}