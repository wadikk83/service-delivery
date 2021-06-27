package by.wadikk.servicedelivery;


import by.wadikk.servicedelivery.util.Runner;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        log.info("==========================================================================");
        log.info("Application is started at " +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        System.out.println("Start application");
        System.out.println("Preparing data");

        Runner runner = new Runner();
        runner.dataPreparation();
        runner.run();

        log.info("Application is finished at " +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        log.info("==========================================================================");
    }

}

