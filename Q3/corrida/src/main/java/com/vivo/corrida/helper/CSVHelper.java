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
                corrida.setHora(formatter.parse(l.get(0)));
                corrida.setNomeHeroi(l.get(1));
                corrida.setNumeroVolta(Integer.parseInt(l.get(2)));
                corrida.setTempoVolta(formatter.parse("00:0" + l.get(3)));
                corrida.setVelocidadeVolta(Double.parseDouble((l.get(4)).replace(',','.')));
                corridas.add(corrida);
            }

            /**
            long tempoVolta = 0;
            int contador = 0;
            for (CorridaDTO corridaDTO : corridas) {
                contador++;
                System.out.println("Linha " + contador);
                System.out.println("Hora: " + formatter.format(corridaDTO.getHora()));
                System.out.println("Super-Heroi " + corridaDTO.getNomeHeroi());
                System.out.println("Nº Volta" + corridaDTO.getNumeroVolta());
                System.out.println("Tempo Volta " + formatter.format(corridaDTO.getTempoVolta()));

                if ("038–Superman".equals(corridaDTO.getNomeHeroi())) {
                    tempoVolta += corridaDTO.getTempoVolta().getTime();
                }

                System.out.println("Velocidade " + corridaDTO.getVelocidadeVolta());
                System.out.println("-----------------------------------------------");
            }

            System.out.println("---------------------------");

            Date tempoTotalDate = new Date();
            tempoTotalDate.setTime(tempoVolta);
            System.out.println("Tempo totoal " + formatter.format(tempoTotalDate));
            **/
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return corridas;
    }
}
