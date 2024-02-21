package ir.dte.boodgedaftar;

import ir.dte.boodgedaftar.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class BoodgeDaftarApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoodgeDaftarApplication.class, args);
    }

}
