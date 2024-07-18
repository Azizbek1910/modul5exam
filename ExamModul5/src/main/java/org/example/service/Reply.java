package org.example.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Reply {
    public ReplyKeyboardMarkup replyMaker(String[][] buttons) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        markup.setKeyboard(keyboardRows);
        for (String[] button : buttons) {
            KeyboardRow row = new KeyboardRow();
            keyboardRows.add(row);
            for (String s : button) {
                if (s.equals("contact")) {
                    row.add(KeyboardButton.builder().text(s).requestContact(true).build());
                } else
                    row.add(s);
            }
        }
        return markup;
    }

}
