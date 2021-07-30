package by.wadikk.service;


import by.wadikk.service.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBException;


@SpringBootApplication(scanBasePackages = "by.wadikk")
public class StarterClass implements InitializingBean {

    @Autowired
    private UserService userService;

    public static void main(String[] args) throws IllegalAccessException, JAXBException, InstantiationException {
        SpringApplication.run(StarterClass.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /*System.out.println("Create new user with login->admin, password->admin, first name-> admin");
        userService.addNewUser("admin", "admin", "admin");*/
    }
}
