package course_project.packages.utils;

/**
 *   Leave no more than two characters after the period.
 */
public class RemoveExtraZeros {
    public static double TWO_CHARACTERS_AFTER_DOT(double value){
        return Math.round(value * 100.0) / 100.0;
    }
}
