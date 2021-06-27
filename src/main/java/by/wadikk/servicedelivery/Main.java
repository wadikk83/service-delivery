package by.wadikk.servicedelivery;


import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.util.Runner;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@Slf4j
public class Main {


    public static void main(String[] args) throws IOException {
        log.info("Application is started at " +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        System.out.println("Start application");

        System.out.println("Hello");


        Runner runner = new Runner();

        runner.run();


        log.info("Application is finished at " +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        log.info("==========================================================================");
    }


}

