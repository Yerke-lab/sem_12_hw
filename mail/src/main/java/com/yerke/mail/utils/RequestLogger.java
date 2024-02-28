package com.yerke.mail.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class RequestLogger {

    private static final String LOG_FILE_PATH = "requests.log";

    public static void logRequest(String request) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.println("Request received at " + LocalDateTime.now() + ":");
            writer.println(request);
            writer.println(); // Добавляем пустую строку для разделения между запросами
        } catch (IOException e) {
            // Обработка ошибок, если не удается записать в файл
            e.printStackTrace();
        }
    }
}