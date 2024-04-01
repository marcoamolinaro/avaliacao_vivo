package com.vivo.corrida.helper;

import com.vivo.corrida.entity.Corrida;
import com.vivo.corrida.model.ResultadoCorridaResponse;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Utils {
    public static long converterTempoParaMilisegundos(int horas, int minutos, int segundos, int milissegundos) {
        // Calcula os milissegundos para minutos, segundos e milissegundos
        long totalMillis = horas * 3600000L; // 1 hora = 3600000 milissegundos
        totalMillis += minutos * 60000L; // 1 minuto = 60000 milissegundos
        totalMillis += segundos * 1000L; // 1 segundo = 1000 milissegundos
        totalMillis += milissegundos; // Milissegundos

        return totalMillis;
    }

    public static String converterMilissegundosParaHora(long milissegundos) {
        // Cria um objeto Date a partir dos milissegundos
        Date date = new Date(milissegundos);

        // Formata a data para o formato desejado "mm:mm.SSS"
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss.SSS");
        String formattedDate = formatter.format(date);

        return formattedDate;
    }

    public static Integer melhorVoltaCorrida(List<Corrida> corridaList) {
        Integer melhorVolta = 0;
        Corrida corrida = corridaList.stream()
                .min(Comparator.comparingLong(Corrida::getTempoVolta))
                .orElse(null);
        if (corrida != null) {
            melhorVolta = corrida.getNumeroVolta();
        }

        return melhorVolta;
    }
}
