package mobile.util;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import org.apache.commons.lang3.StringUtils;

public class Util {

    private Util(){
        //Nothing TODO
    }

    /**
     * Obtener la fecha actual a partir de un formato especifico
     * @return la fecha formateada
     */
    public static String currentDateString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constant.FORMAT_DATE);
        return dtf.format(LocalDateTime.now());
    }

    /**
     * Obteniene caracter por caracter de una cadena de caracteres
     * @param value Cadena de caracteres
     * @return retorna un solo caracter de la cadena de caracteres
     */
    public static String getChartByChart(String value){
        String chart = "";
        for(int i = 0; i< value.length(); i++){
            chart = String.valueOf(value.charAt(i));
        }
        return chart;
    }

}
