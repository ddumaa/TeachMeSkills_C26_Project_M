package course_project.packages.utils;

public class RemoveExtraZeros {
    //Оставляем не более двух знаков после точки.
    public static double TWO_CHARACTERS_AFTER_DOT(double value){
        return Math.round(value * 100.0) / 100.0;
    }
}
