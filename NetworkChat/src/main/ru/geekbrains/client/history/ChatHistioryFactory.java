package ru.geekbrains.client.history;

public class ChatHistoryFactory {

    public static ChatHistory createChatHistory() {
        return new ChatHistoryTextFileImpl();
    }
}