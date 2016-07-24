package example.bot;

import org.telegram.telegrambots.api.objects.Message;
import ru.skuptsov.telegram.bot.platform.client.command.MessageResponse;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageHandler;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageMapping;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;

import java.util.function.Consumer;

/**
 * @author Sergey Kuptsov
 * @since 04/07/2016
 */
@MessageHandler
public class SimpleGreeting {

    @MessageMapping(text = "Привет")
    public MessageResponse sayHi(UpdateEvent updateEvent) {
        return MessageResponse
                .text("Привет!", updateEvent)
                .setCallback((Consumer<Message>) message -> System.out.println("Message sent"));
    }

    @MessageMapping(regexp = "(.*пока.*|.*до свиданья.*)")
    public MessageResponse sayGoodbye(UpdateEvent updateEvent) {
        return MessageResponse.text("До новых встреч", updateEvent);
    }
}