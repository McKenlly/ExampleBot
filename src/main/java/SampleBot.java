import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;


public class SampleBot extends TelegramLongPollingBot {
    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getText());
        /*
        String message = update.getMessage().getText();
        //sendMsg(update.getMessage().getChatId().toString(), message);
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        String s = "Ты пидор, братишка";
        sendMessage.setText(s);
        */
    }

    /**
     * Метод для настройки сообщения и его отправки.
     *
     * @param chatId id чата
     * @param s      Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(Level.SEVERE, "Exception: ", e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     *
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        // TODO
        return "MysorBot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "464028994:AAEr5oA4cQ4SNaUq6Ks8lCe9zHB9dSAuYCc";
    }
}
