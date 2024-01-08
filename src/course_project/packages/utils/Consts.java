package course_project.packages.utils;

/**
 * Storing constants
 */
public interface Consts {

    //Paths to logs
    //String EXECUTION_LOG_FILE = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\loggi\\execution_log\\execution_log.txt";
    String EXECUTION_LOG_FILE = "D:\\Course_project\\execution_log.txt";

    //String ERROR_LOG_FILE = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\loggi\\error_log\\error_log.txt";
    String ERROR_LOG_FILE = "D:\\Course_project\\error_log.txt";

    //Paths to invalid files to move
    //String INCORRECT_FILE_EXTENSION_PATH = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\invalid_documents\\incorrect_file_extension";
    String INCORRECT_FILE_EXTENSION_PATH = "D:\\Course_project\\incorrect_file_extension.txt";

    //String INVALID_FILE_NAME_PATH = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\invalid_documents\\invalid_file_name";
    String INVALID_FILE_NAME_PATH = "D:\\Course_project\\invalid_file_name.txt";

    //Path to statistics record
    //String STATISTIC_WRIT_PATH = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\statistics\\Statistics.txt";
    String STATISTIC_WRIT_PATH = "D:\\Course_project\\Statistics.txt";

    //Read file extension
    String fileExtension = ".txt";

    //Method of storing two characters after a period
    static double TWO_CHARACTERS_AFTER_DOT(double value){
        return Math.round(value * 100.0) / 100.0;
    }

}
