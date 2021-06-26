package by.wadikk.servicedelivery.util;


import by.wadikk.servicedelivery.service.UserService;
import by.wadikk.servicedelivery.service.impl.UserServiceImpl;

import java.io.IOException;

public class Runner {

    UserService userService = UserServiceImpl.getService();

    public void run() throws IOException {
        /*System.out.println("All users list");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.parseJsonListToFile(userService.getAllUsers(), "Json user");*/




    }

}
