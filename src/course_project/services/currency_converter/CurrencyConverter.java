package course_project.services.currency_converter;

import course_project.packages.logger.Logging;

import java.util.Date;

/**
 * Конвертер валют
 */
public class CurrencyConverter {
    public static double convertCurrency(String currency, double value){
        switch (currency){
            case "EURO": value *= 0.95;
                Logging.EXECUTION_LOG(new Date(),"Convert EURO to USD\n");
                break;
            case "GBR": value *= 1.26;
                Logging.EXECUTION_LOG(new Date(),"Convert GBR to USD\n");
                break;
        }
        return value;
    }
}
