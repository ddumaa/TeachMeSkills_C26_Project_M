package course_project.packages.utils;

public interface Consts {
    //путь до файлов Дмитрий, ноутбук
    //можно делать свой путь и закоментировать неиспользованные пути
    //Пути к логам
    String EXECUTION_LOG_FILE = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\loggi\\execution_log\\execution_log.txt";
    String ERROR_LOG_FILE = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\loggi\\error_log\\error_log.txt";

    //пути к невалидным файлам для перемещения
    String INCORRECT_FILE_EXTENSION_PATH = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\invalid_documents\\incorrect_file_extension";
    String INVALID_FILE_NAME_PATH = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\invalid_documents\\invalid_file_name";


    //путь к записи статистики
    String STATISTIC_WRIT_PATH = "C:\\Users\\Guest\\IdeaProjects\\TeachMeSkills_C26_Project_M\\src\\course_project\\documents\\statistics\\Statistics.txt";

    //расширение читаемых файлов
    String fileExtension = ".txt";

    static double TWO_CHARACTERS_AFTER_DOT(double value){
        return Math.round(value * 100.0) / 100.0;
    }
}
