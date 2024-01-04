package course_project.services.actions_with_files;

import course_project.packages.logger.Logging;
import course_project.packages.utils.Consts;
import course_project.packages.utils.Variables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class WritFiles {
    //метод записи в фаил statistics
    public static void writingFiles (){
        try {
            String message = "- total turnover for the year: " + Consts.TWO_CHARACTERS_AFTER_DOT(Variables.getSumOrder() + Variables.getSumBill() + Variables.getSumInvoice()) + "\n" +
                    "- total turnover for all invoices: "+ Consts.TWO_CHARACTERS_AFTER_DOT(Variables.getSumInvoice()) + "\n" +
                    "- total turnover for all orders: " + Consts.TWO_CHARACTERS_AFTER_DOT(Variables.getSumOrder()) + "\n" +
                    "- total turnover for all checks: " + Consts.TWO_CHARACTERS_AFTER_DOT(Variables.getSumBill());
            Files.write(Paths.get(Consts.STATISTIC_WRIT_PATH), message.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        }
    }
}
