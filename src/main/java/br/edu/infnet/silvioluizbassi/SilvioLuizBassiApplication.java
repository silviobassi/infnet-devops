package br.edu.infnet.silvioluizbassi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SilvioLuizBassiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SilvioLuizBassiApplication.class, args);
    }

}
