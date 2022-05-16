package com.xiecode.drug;

import com.xiecode.drug.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrugApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {

    }


}
