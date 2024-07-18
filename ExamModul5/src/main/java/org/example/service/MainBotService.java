package org.example.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MainBotService {
    public void service(Update update) {
        String s = update.getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage();
        String text = update.getMessage().getText();
        String chatId = update.getMessage().getChatId().toString();
        switch (text) {
            case "cards" -> {
                sendMessage.setText("sizning kartalaringiz");
                sendMessage.setChatId(s);
            }
        }

    }
}
