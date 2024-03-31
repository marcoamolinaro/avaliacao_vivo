package com.vivo.corrida.helper;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.vivo.corrida.dto.CorridaDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CSVHelper {
    public static String TYPE = "text/csv";
    //static String[] HEADERs = {"Hora","Super-Heroi","Nº Volta","Tempo Volta","Velocidade média da volta"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<CorridaDTO> csvToOrders() {
        List<CorridaDTO> corridas = new ArrayList<>();

        try {
            File file = new ClassPathResource("db/Corrida.csv").getFile();

            FileReader fileReader = new FileReader(file);

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).withSkipLines(1).build();

            List<String[]> allData = csvReader.readAll();

            SimpleDateFormat formatter =new SimpleDateFormat("HH:mm:ss.S");

            for (String[] row : allData) {
                List<String> l = Arrays.stream(row).toList();
                CorridaDTO corrida = new CorridaDTO();
                corrida.setHora(l.get(0));
                corrida.setCodigoSuperHeroi(l.get(1).substring(0,3));
                corrida.setNomeHeroi(l.get(1).substring(4));
                corrida.setNumeroVolta(Integer.parseInt(l.get(2)));
                Integer minutos = Integer.parseInt(l.get(3).substring(0,1));
                Integer segundos = Integer.parseInt(l.get(3).substring(2,4));
                Integer milisegundos = Integer.parseInt(l.get(3).substring(5,8));
                System.out.println("Minutos [" + minutos
                        + "] Segundos [" + segundos + "] Miliseg [" + milisegundos + "]");
                corrida.setTempoVolta(Utils.converterTempoParaMilisegundos(minutos, segundos, milisegundos));
                corrida.setVelocidadeVolta(Double.parseDouble((l.get(4)).replace(',','.')));
                corridas.add(corrida);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return corridas;
    }
}
