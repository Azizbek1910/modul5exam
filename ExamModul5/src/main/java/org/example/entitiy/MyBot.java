package org.example.entitiy;

import org.example.Utill;
import org.example.service.Reply;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        Reply reply = new Reply();
        SendMessage sendMessage = new SendMessage();
        String text = update.getMessage().getText();
        String message = update.getMessage().getText();
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        update.getMessage().getChatId().toString();

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        markup.setKeyboard(keyboardRows);

//        KeyboardRow row = new KeyboardRow();
//        KeyboardButton contact = new KeyboardButton();
//        markup.setOneTimeKeyboard(true);
//        UserService service;
//        row.add(contact);

        InlineKeyboardMarkup InlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();

        InlineKeyboardButton card = new InlineKeyboardButton();
        card.setText("Cards");

        InlineKeyboardButton add_card = new InlineKeyboardButton();
        card.setText("add card");
        row1.add(card);
        row1.add(add_card);

        InlineKeyboardButton transfer = new InlineKeyboardButton();
        card.setText("transfer");

        InlineKeyboardButton history = new InlineKeyboardButton();
        card.setText("history");
        row2.add(transfer);
        row2.add(history);

        InlineKeyboardButton deposite = new InlineKeyboardButton();
        card.setText("deposite");
        row3.add(deposite);
        List<List<InlineKeyboardButton>> keyboards = new ArrayList<>();
        InlineKeyboardMarkup.setKeyboard(keyboards);
        keyboards.add(row1);
        keyboards.add(row2);
        keyboards.add(row3);
        sendMessage.setReplyMarkup(InlineKeyboardMarkup);
        switch (text) {
            case "/start", "back" -> {
                sendMessage.setText("Assalomu aleykum botga hush kelibsiz");
                sendMessage.setReplyMarkup(reply.replyMaker(Utill.menu));
                sendMessage.setChatId(chatId);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    @Override
    public String getBotUsername() {
        return "t.me/modul5exambot.";
    }

    @Override
    public String getBotToken() {
        return "7319136272:AAHaPDvshXTc1NvH-e_fLueicse_yWgbk-Y";
    }
}
