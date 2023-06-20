package untitled.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import untitled.TaxiCallingApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { TaxiCallingApplication.class })
public class CucumberSpingConfiguration {}
