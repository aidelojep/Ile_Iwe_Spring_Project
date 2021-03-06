package com.ileiwe.service.event;

import com.ileiwe.service.mail.EmailService;
import com.ileiwe.service.mail.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.UUID;

@Component
@Slf4j
public class ApplicationEventListener {

    @Autowired
    EmailService emailService;

    @Autowired
    TemplateEngine templateEngine;

    //its a convention to use 'handle' to begin a method in naming
    @EventListener
    public void handleRegistrationCompleteEvent(OnRegistrationCompleteEvent event){
        this.confirmRegistration(event);
        log.info("Event triggered ");
    }
    //confirmation e-mail method
    private void confirmRegistration(OnRegistrationCompleteEvent event){

        String verificationToken = UUID.randomUUID().toString();
        Message message = Message.builder()
                .from("tboydv1@gmail.com").to(event.getAppUser().getEmail())
                .subject("Confirmation Email")
                .body(templateEngine.process("confirmation.html", new Context())).build();

        emailService.send(message);
    }
}
