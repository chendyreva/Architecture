package ru.geekbrains.client.Behavioral patterns;

public class Chain {

    public static void main(String[] args) {
	MessagePrinter messagePrinter = new Chatbot1();
    Chatbot2 chatbot2 = new Chatbot2();
	messagePrinter.setNextMessagePrinter(chatbot2);
	chatbot2.setNextMessagePrinter(new Chatbot3());
	messagePrinter.print("Hello! How are you?");
    }
}

abstract class MessagePrinter {
    MessagePrinter nextMessagePrinter;

    void setNextMessagePrinter(MessagePrinter messagePrinter) {
        nextMessagePrinter = messagePrinter;
    }

    void print(String message) {
        printMessage(message);
        if (nextMessagePrinter != null) {
            nextMessagePrinter.print(message);
        }
    }
    abstract void printMessage(String message);
}

class Chatbot1 extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("Chat bot 1: " + message);
    }
}

class Chatbot2 extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("Chat bot 2: " + message);
    }
}

class Chatbot3 extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("Chat bot 3: " + message);
    }
}