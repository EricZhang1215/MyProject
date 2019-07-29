package com.dxc.videoservice.Test;

import com.dxc.videoservice.service.ApiVideoCustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author He Biao
 * @date 2018-09-25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    ApiVideoCustomerService apiVideoCustomerService;

    @Test
    public void test(){
        apiVideoCustomerService.downloadVideoFile();
    }


}
