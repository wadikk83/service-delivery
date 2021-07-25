package by.wadikk.service;


import by.wadikk.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@SpringBootApplication(scanBasePackages = "by.wadikk")
@Slf4j
public class StarterClass implements InitializingBean {

    @Autowired
    private UserService userService;

    public static void main(String[] args) throws IllegalAccessException, JAXBException, InstantiationException {
        log.info("==========================================================================");
        log.info("Application is started at " +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));

        SpringApplication.run(StarterClass.class, args);

        log.info("Application is finished at " +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        log.info("==========================================================================");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /*System.out.println("Create new user with login->admin, password->admin, first name-> admin");
        userService.addNewUser("admin", "admin", "admin");*/
    }
}
