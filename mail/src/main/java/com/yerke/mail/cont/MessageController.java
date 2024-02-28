package com.yerke.mail.cont;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.yerke.mail.utils.RequestLogger;

@RestController
public class MessageController {

    @GetMapping("/")
    public String hello() {
        return "Тестовое сообщение!";
    }

    @PostMapping("/")
    public String processRequest(@RequestBody String request) {
        // Сохранение запроса в файл
        RequestLogger.logRequest(request);

        // Дополнительная обработка запроса, если необходимо
        return "Request received and logged successfully.";
    }
}


