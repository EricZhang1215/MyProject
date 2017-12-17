package com.zqs.helloworld;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 在这里我们使用@RestController （等于 @Controller 和 @ResponseBody）
@RestController
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "hello2-2016";
    }

    /**
     * Spring Boot默认使用的json解析框架是jackson
     * @return
     */
    @RequestMapping("/getDemo")
    public Demo getDemo() {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("张三");
        demo.setCreateTime(new Date());
        demo.setRemarks("这是备注信息");
        return demo;
    }

    //    @Data
    //    static class Result {
    //        private final int left;
    //        private final int right;
    //        private final long answer;
    //    }
    //
    //    // SQL sample
    //    @RequestMapping("calc")
    //    Result calc(@RequestParam int left, @RequestParam int right) {
    //        MapSqlParameterSource source = new MapSqlParameterSource()
    //                .addValue("left", left)
    //                .addValue("right", right);
    //        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
    //                (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
    //    }
}
