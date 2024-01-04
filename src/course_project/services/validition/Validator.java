package course_project.services.validition;

import course_project.packages.logger.Logging;
import course_project.packages.utils.Consts;
import course_project.packages.utils.Variables;
import course_project.services.actions_with_files.ReadFiles;

import java.util.Date;

public class Validator {
    // Метод проверки формата файла и фильтр на год документа,
    // определение типа документа,
    // получение суммы и запись суммы.
    // Пермещение невалидных документов.
    public static void validationNameDocuments (String nameFile, String path) {
        Logging.EXECUTION_LOG(new Date(),"Document verification -> " + nameFile + "\n");
        if (nameFile.endsWith(Consts.fileExtension) && nameFile.contains("2023")) {
            Logging.EXECUTION_LOG(new Date(),"The document has been verified -> " + nameFile + "\n");
            if(nameFile.toLowerCase().contains("order")){
                Variables.setSumOrder(Variables.getSumOrder() + ReadFiles.readingFiles(path));
            } else if (nameFile.toLowerCase().contains("invoice")){
                Variables.setSumInvoice(Variables.getSumInvoice() + ReadFiles.readingFiles(path));
            } else if (nameFile.toLowerCase().contains("bill")){
                Variables.setSumBill(Variables.getSumBill() + ReadFiles.readingFiles(path));
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
            /*WritFiles.writingFiles("- total turnover for the year: " + Consts.TWO_CHARACTERS_AFTER_DOT(sumOrder + sumInvoice + sumBill),
                    "- total turnover for all invoices: "+ Consts.TWO_CHARACTERS_AFTER_DOT(sumInvoice),
                    "- total turnover for all orders: " + Consts.TWO_CHARACTERS_AFTER_DOT(sumOrder),
                    "- total turnover for all orders: " + Consts.TWO_CHARACTERS_AFTER_DOT(sumBill));*/
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
