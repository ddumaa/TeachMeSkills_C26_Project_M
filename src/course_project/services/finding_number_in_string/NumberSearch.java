package course_project.services.finding_number_in_string;

import course_project.packages.logger.Logging;

import java.util.Date;

/**
 * Метод поиска и возврата суммы в строке
 */
public class NumberSearch {

    public static double searchAmount (String line){
        StringBuilder number = new StringBuilder();
        boolean decimalPointFound = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c) || c == ',' || (c == '.' && !decimalPointFound)) {
                if (c != ',' && c != '.') {
                    number.append(c);
                } else if (c == '.') {
                    number.append(c);
                    decimalPointFound = true;
                }
            } else {
                if (number.length() > 0) {
                    String numStr = number.toString().replace(",", "");
                    double num = Double.parseDouble(numStr);
                    Logging.EXECUTION_LOG(new Date(),"check amount\n");
                    return num; // найдя одно число, завершаем поиск
                }
            }
        }
        // Проверяем, не закончилась ли строка
        if (number.length() > 0) {
            String numStr = number.toString().replace(",", "");
            double num = Double.parseDouble(numStr);
            Logging.EXECUTION_LOG(new Date(),"check amount\n");
            return num;
        }
        return 0;
    }
}
