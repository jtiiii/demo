package cn.funeralobjects.demo.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author FuneralObjects
 * Create date: 2020/5/14 2:38 PM
 */
@SpringBootApplication
@EnableJpaRepositories
public class JpaTestApplication {

    public static void main(String[] args){
        SpringApplication.run(JpaTestApplication.class, args);
    }

}
