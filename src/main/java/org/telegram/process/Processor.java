package org.telegram.process;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Processor {
    void process(Update update);
}