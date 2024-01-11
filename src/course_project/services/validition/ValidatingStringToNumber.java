package course_project.services.validition;

import course_project.packages.logger.Logging;
import course_project.services.currency_converter.CurrencyConverter;
import course_project.services.finding_number_in_string.NumberSearch;

import java.util.Date;

/**
 *    Checking whether the line contains the amount and its currency,
 *    calling a method for getting a number from a string,
 *    call conversion,
 *    return value.
 */
public class ValidatingStringToNumber {

    public static double checkingLineForAmountAndCurrency (String line){
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
