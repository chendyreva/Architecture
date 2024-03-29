package ru.geekbrains.client.javafx.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import ru.geekbrains.client.AuthException;
import ru.geekbrains.client.MessageReciever;
import ru.geekbrains.client.Network;
import ru.geekbrains.client.TextMessage;
import ru.geekbrains.client.history.ChatHistory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class Controller implements Initializable, MessageReciever {

    @FXML
    public TextField tfMessage;

    @FXML
    public ListView<TextMessage> lvMessages;

    @FXML
    public Button btSendMessage;

    @FXML
    public TextField loginField;

    @FXML
    public PasswordField passField;

    @FXML
    public HBox authPanel;

    @FXML
    public HBox msgPanel;

    @FXML
    public ListView<String> lvUserList;

    Stage primaryStage;

    private ObservableList<TextMessage> messageList;

    private ObservableList<String> userList;

    private Network network;
    private ChatHistory chatHistory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messageList = FXCollections.observableArrayList();

        lvMessages.setItems(messageList);
        lvMessages.setCellFactory(new Callback<ListView<TextMessage>, ListCell<TextMessage>>() {
            @Override
            public ListCell<TextMessage> call(ListView<TextMessage> param) {
                return new MessageCellController();
            }
        });

        userList = FXCollections.observableArrayList();
        userList.addAll("ivan", "petr", "julia"); // пока фиксированный список
        lvUserList.setItems(userList);

        network = new Network("localhost", 7777, this);
        authPanel.setVisible(true);
        msgPanel.setVisible(false);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void onSendMessageClicked() {
        String text = tfMessage.getText();
        if (text != null && !text.isEmpty()) {
            String userTo = lvUserList.getSelectionModel().getSelectedItem();
            TextMessage msg = new TextMessage(network.getLogin(), userTo, text);
            messageList.add(msg);
            tfMessage.clear();
            tfMessage.requestFocus();

            network.sendTextMessage(msg);
        }
    }

    public void sendAuth() {
        try {
            network.authorize(loginField.getText(), passField.getText());
        } catch (AuthException ex) {
            ex.printStackTrace();
            showModalAlert("Сетевой чат",
                    "Авторизация",
                    "Ошибка авторизации",
                    Alert.AlertType.ERROR);
            return;
        } catch (IOException ex) {
            ex.printStackTrace();
            showModalAlert("Сетевой чат",
                    "Авторизация",
                    "Ошибка сети",
                    Alert.AlertType.ERROR);
            return;
        }
        authPanel.setVisible(false);
        msgPanel.setVisible(true);
    }

    @Override
    public void submitMessage(TextMessage msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                messageList.add(msg);
            }
        });
    }

    @Override
    public void userConnected(String login) {

    }

    @Override
    public void userDisconnected(String login) {

    }

    @Override
    public void updateUserList(Set<String> users) {

    }

    public void closeNetworkConnection() {
        network.close();
    }

    private static void showModalAlert(String title, String header, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }
}