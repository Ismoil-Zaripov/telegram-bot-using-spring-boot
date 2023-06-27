package org.telegram.process;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.sender.MessageSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.telegram.constants.Constants.start;

@Component
@RequiredArgsConstructor
public class ProcessorImpl implements Processor {
    private final MessageSender sender;

    @Override
    public void process(Update update) {
        if (update.hasMessage()) {

            Message message = update.getMessage();

            if (message.hasText()) {
                switch (message.getText()){

                    case start -> startBot(message);
                }
            }

        }
    }

    private void startBot(Message message) {

        sender.sendMessage(
                SendMessage.builder()
                        .text("Hello world !!!")
                        .chatId(message.getChatId())
                        .build()
        );

    }
}
