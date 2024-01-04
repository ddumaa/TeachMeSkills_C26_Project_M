package course_project.services.validition;

import course_project.packages.logger.Logging;
import course_project.packages.utils.Consts;
import course_project.services.actions_with_files.WritFiles;
import course_project.services.currency_converter.CurrencyConverter;
import course_project.services.finding_number_in_string.NumberSearch;
import course_project.services.actions_with_files.ReadFiles;

import java.util.Date;

public class Validator {
    public static double sumOrder = 0;
    public static double sumInvoice = 0;
    public static double sumBill = 0;

    // Метод проверки формата файла и фильтр на год документа,
    // вызов метода считывания файла,
    // получения возвращаемого значения и вызов метода записи в фаил.
    // Пермещение невалидных документов.
    public static void validationNameDocuments (String nameFile, String path) {
        Logging.EXECUTION_LOG(new Date(),"Document verification -> " + nameFile + "\n");
        if (nameFile.endsWith(Consts.fileExtension) && nameFile.contains("2023")) {
            Logging.EXECUTION_LOG(new Date(),"The document has been verified -> " + nameFile + "\n");
            if(nameFile.toLowerCase().contains("order")){
                double a = ReadFiles.readingFiles(path);
                sumOrder += a;
            } else if (nameFile.toLowerCase().contains("invoice")){
                double a = ReadFiles.readingFiles(path);
                sumInvoice += a;
            } else if (nameFile.toLowerCase().contains("bill")){
                double a = ReadFiles.readingFiles(path);
                sumBill += a;
            } else {
                Logging.EXECUTION_LOG(new Date(),"Invalid file -> " + nameFile + "\n");
                //невалидные файлы перемещаются - удалить комментирование метода перед испольхованием (закоментированно что-бы не пермещать каждый раз файлы)
            /*File sourceFile = new File(path);
            File destinationFolder = new File(Consts.DESTINATION_FOLDER);

            try {
                Path sourcePath = sourceFile.toPath();
                Path destinationPath = new File(destinationFolder, sourceFile.getName()).toPath();
                Files.move(sourcePath, destinationPath);
            } catch (IOException e) {
                Logging.ERROR_LOG(new Date(),"Error moving file" + nameFile + "\n");
            }*/
            }
            WritFiles.writingFiles("- total turnover for the year: " + Consts.TWO_CHARACTERS_AFTER_DOT(sumOrder + sumInvoice + sumBill),
                    "- total turnover for all invoices: "+ Consts.TWO_CHARACTERS_AFTER_DOT(sumInvoice),
                    "- total turnover for all orders: " + Consts.TWO_CHARACTERS_AFTER_DOT(sumOrder),
                    "- total turnover for all orders: " + Consts.TWO_CHARACTERS_AFTER_DOT(sumBill));
        } else {
            Logging.EXECUTION_LOG(new Date(),"Invalid file -> " + nameFile + "\n");
            //невалидные файлы перемещаются - удалить комментирование метода перед испольхованием (закоментированно что-бы не пермещать каждый раз файлы)
            /*File sourceFile = new File(path);
            File destinationFolder = new File(Consts.DESTINATION_FOLDER);

            try {
                Path sourcePath = sourceFile.toPath();
                Path destinationPath = new File(destinationFolder, sourceFile.getName()).toPath();
                Files.move(sourcePath, destinationPath);
            } catch (IOException e) {
                Logging.ERROR_LOG(new Date(),"Error moving file" + nameFile + "\n");
            }*/
        }
    }


}
