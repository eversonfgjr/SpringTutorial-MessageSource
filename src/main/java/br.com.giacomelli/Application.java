package br.com.giacomelli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;

@ComponentScan(basePackages = "com.zetcode")
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private MessageSource messageSource;

    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(Application.class);

        var app = ctx.getBean(Application.class);
        app.run();

        ctx.close();
    }

    public void run() {

        logger.info("Translated messages:");
        logger.info("{}", messageSource.getMessage("l1",
                null, Locale.GERMAN));
        logger.info("{}", messageSource.getMessage("l1",
                null, Locale.ENGLISH));

        logger.info("Translated parameterized messages:");
        logger.info("{}", messageSource.getMessage("l2",
                new Object[] {"Paul Smith"}, Locale.GERMAN));
        logger.info("{}", messageSource.getMessage("l2",
                new Object[] {"Paul Smith"}, Locale.ENGLISH));
    }
}