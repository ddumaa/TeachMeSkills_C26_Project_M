package course_project.services.validition;

import course_project.packages.logger.Logging;
import course_project.packages.utils.Consts;
import course_project.services.currency_converter.CurrencyConverter;
import course_project.services.finding_number_in_string.NumberSearch;
import course_project.services.reading_writing_files.ReadWritFiles;

import java.util.Date;

public class Validator {
    public static double sumOrder = 0;
    public static double sumInvoice = 0;
    public static double sumBill = 0;

    //метод проверки формата файла и его года, вызов метода считывания файла
    // и получения возвращаемого значения и вызов метода записи в фаил
    public static void validationNameDocuments (String nameFile, String path) {
        Logging.EXECUTION_LOG(new Date(),"Document verification -> " + nameFile + "\n");
        if (nameFile.endsWith(Consts.fileExtension) && nameFile.contains("2023")) {
            Logging.EXECUTION_LOG(new Date(),"The document has been verified -> " + nameFile + "\n");
            if(nameFile.toLowerCase().contains("order")){
                double a = ReadWritFiles.readingFiles(path);
                sumOrder += a;
            } else if (nameFile.toLowerCase().contains("invoice")){
                double a = ReadWritFiles.readingFiles(path);
                sumInvoice += a;
            } else if (nameFile.toLowerCase().contains("bill")){
                double a = ReadWritFiles.readingFiles(path);
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
            ReadWritFiles.writingFiles("- total turnover for the year: " + Consts.TWO_CHARACTERS_AFTER_DOT(sumOrder + sumInvoice + sumBill),
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

    //поиск строки с суммой, вызов метода получения числа из строки, вызов конвертации
    public static double searchLineWithOrder (String line){
        if (line.toLowerCase().contains("total")){
            Logging.EXECUTION_LOG(new Date(),"Line with amount found\n");
            if (line.toUpperCase().contains("EURO")){
                Logging.EXECUTION_LOG(new Date(),"EURO currency\n");
                double euro = NumberSearch.searchAmount(line);
                return CurrencyConverter.convertCurrency("EURO", euro);
            } else if (line.toUpperCase().contains("GBR")) {
                Logging.EXECUTION_LOG(new Date(),"GBR currency\n");
                double gbr = NumberSearch.searchAmount(line);
                return CurrencyConverter.convertCurrency("GBR", gbr);
            } else {
                Logging.EXECUTION_LOG(new Date(),"USD currency\n");
                return NumberSearch.searchAmount(line);
            }
        }
        return 0;
    }
}
