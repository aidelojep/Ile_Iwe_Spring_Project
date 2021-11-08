package com.ileiwe.service.mail;

//EHIS API
// sandbox7986d9e08fa24e83a0c1538c3a114712.mailgun.org
// 4dd23a13ff716cd1c90681841f160c8a-10eedde5-c29196f6

//RABBI API
//API key: 5601c258c69753f660314351debeac25-20ebde82-60f30e57
//API base URL: https://api.mailgun.net/v3/sandbox490b2dfc26bc4c3f82c2873bafa06465.mailgun.org

public interface EmailService {

    public MailResponse send(Message message);
}
