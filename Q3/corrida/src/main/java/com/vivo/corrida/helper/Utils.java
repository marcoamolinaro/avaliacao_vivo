package com.vivo.corrida.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static long converterTempoParaMilisegundos(int minutos, int segundos, int milissegundos) {
        // Calcula os milissegundos para minutos, segundos e milissegundos
        long milissegundosMinutos = minutos * 60 * 1000; // 1 minuto = 60 segundos = 60 * 1000 milissegundos
        long milissegundosSegundos = segundos * 1000; // 1 segundo = 1000 milissegundos

        // Soma os milissegundos de horas, minutos, segundos e milissegundos para obter o total
        long totalMilissegundos = milissegundosMinutos + milissegundosSegundos + milissegundos;

        return totalMilissegundos;
    }

    public static String converterMilissegundosParaHora(long milissegundos) {
        // Cria um objeto Date a partir dos milissegundos
        Date date = new Date(milissegundos);

        // Formata a data para o formato desejado "MM:SS.SSS"
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss.SSS");
        String formattedDate = formatter.format(date);

        return formattedDate;
    }

}
