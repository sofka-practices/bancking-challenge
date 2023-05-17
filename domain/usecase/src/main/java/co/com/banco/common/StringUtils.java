package co.com.banco.common;

import java.util.regex.Pattern;

public class StringUtils {

    private StringUtils() {
    }

    public static final String WHITESPACE = " ";

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern CELULAR_PATTERN = Pattern.compile("3\\d{9}");
    private static final Pattern NUMBER_LETTER_PATTERN = Pattern.compile("(?ui)[A-Z\\u00D1 \\d]*");
    private static final Pattern TIPO_DOCUMENTO_A_PATTERN = Pattern.compile("^[689]\\d{9}$");
    private static final Pattern TIPO_DOCUMENTO_C_PATTERN = Pattern.compile("^(\\d{3,8})(?!.)|([19]\\d{9})(?!.)$");
    private static final Pattern TIPO_DOCUMENTO_E_PATTERN = Pattern.compile("^[A-Z\\d]{1,11}(?!.)$");
    private static final Pattern TIPO_DOCUMENTO_F_PATTERN = Pattern.compile("^[a-zA-Z\\d.-]{1,16}$");
    private static final Pattern TIPO_DOCUMENTO_N_PATTERN = Pattern.compile("^[A-Z\\d]{3}\\d{7,8}(?!.)$");
    private static final Pattern TIPO_DOCUMENTO_P_PATTERN = TIPO_DOCUMENTO_E_PATTERN;
    private static final Pattern TIPO_DOCUMENTO_T_PATTERN = Pattern.compile("^\\d{10,14}$");
    private static final Pattern TIPO_DOCUMENTO_TE_PATTERN = Pattern.compile("^\\d{15}$");
    private static final Pattern TIPO_DOCUMENTO_TF_PATTERN = TIPO_DOCUMENTO_TE_PATTERN;
    private static final Pattern TIPO_DOCUMENTO_TS_PATTERN = Pattern.compile("^\\d{8,9}$");
    private static final Pattern TIPO_DOCUMENTO_TT_PATTERN = Pattern.compile("^\\d{5,9}$");
    private static final Pattern TIPO_DOCUMENTO_X_PATTERN = Pattern.compile("^[A-Z\\d]{1,18}(?!.)$");


    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isEmpty(String... strings) {
        boolean empty = false;
        for (String str : strings) {
            empty = empty || isEmpty(str);
        }
        return empty;
    }

    public static boolean isEmailFormat(String str) {
        return EMAIL_PATTERN.matcher(str).matches();
    }

    public static boolean isCelularFormat(String str) {
        return CELULAR_PATTERN.matcher(str).matches();
    }

    public static boolean isNumberFormat(String str) {
        return NUMBER_PATTERN.matcher(str).matches();
    }

    public static boolean isHasWhiteSpace(String str) {
        return !StringUtils.isEmpty(str) && str.contains(WHITESPACE);
    }

    public static boolean isLetterNumberFormat(String str) {
        return NUMBER_LETTER_PATTERN.matcher(str).matches();
    }

    public static boolean isSpace(String str) {
        return !StringUtils.isEmpty(str) && (str.startsWith(WHITESPACE) || str.endsWith(WHITESPACE));
    }

    public static boolean isNitFormat(String str) {
        return isNumberFormat(str) && TIPO_DOCUMENTO_A_PATTERN.matcher(str).matches();
    }

    public static boolean isCedulaFormat(String str) {
        return isNumberFormat(str) && TIPO_DOCUMENTO_C_PATTERN.matcher(str).matches();
    }

    public static boolean isCedulaExtranjeriaFormat(String str) {
        return isLetterNumberFormat(str) && TIPO_DOCUMENTO_E_PATTERN.matcher(str).matches();
    }

    public static boolean isIdFiscalExtranjerosFormat(String str) {
        return isLetterNumberFormat(str) && TIPO_DOCUMENTO_F_PATTERN.matcher(str).matches();
    }

    public static boolean isNuipFormat(String str) {
        return isLetterNumberFormat(str) && TIPO_DOCUMENTO_N_PATTERN.matcher(str).matches();
    }

    public static boolean isPasaporteFormat(String str) {
        return isLetterNumberFormat(str) && TIPO_DOCUMENTO_P_PATTERN.matcher(str).matches();
    }

    public static boolean isTarjetaIdentidadFormat(String str) {
        return isNumberFormat(str) && TIPO_DOCUMENTO_T_PATTERN.matcher(str).matches();
    }

    public static boolean isPermisoEspecialPermanenciaFormat(String str) {
        return isNumberFormat(str) && TIPO_DOCUMENTO_TE_PATTERN.matcher(str).matches();
    }

    public static boolean isPermisoEspecialFormacionPepffFormat(String str) {
        return isNumberFormat(str) && TIPO_DOCUMENTO_TF_PATTERN.matcher(str).matches();
    }

    public static boolean isSalvoconductoPermanenciaFormat(String str) {
        return isNumberFormat(str) && TIPO_DOCUMENTO_TS_PATTERN.matcher(str).matches();
    }

    public static boolean isPermisoProteccionTemporalFormat(String str) {
        return isNumberFormat(str) && TIPO_DOCUMENTO_TT_PATTERN.matcher(str).matches();
    }
    public static boolean isDocumentoIdentidadExtranjerosFormat(String str) {
        return isLetterNumberFormat(str) && TIPO_DOCUMENTO_X_PATTERN.matcher(str).matches();
    }
}