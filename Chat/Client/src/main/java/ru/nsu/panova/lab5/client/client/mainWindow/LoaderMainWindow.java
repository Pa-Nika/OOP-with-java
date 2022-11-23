package ru.nsu.panova.lab5.client.client.mainWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.panova.lab5.client.client.Constants;
import ru.nsu.panova.lab5.client.client.loaders.InterfaceLoaders;
import ru.nsu.panova.lab5.client.client.Client;

import java.net.Socket;

public class LoaderMainWindow extends Application implements InterfaceLoaders {
    private final ModelMainWindow menuModel = new ModelMainWindow();
    private Socket clientSocket;
    private String userName;

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource(Constants.MAIN_WINDOW_FXML));
        Scene scene = new Scene(fxmlLoader.load(), Constants.WIDTH_WINDOW, Constants.HEIGHT_WINDOW);

        ControllerMainWindow controllerMainWindow = fxmlLoader.getController();
        menuModel.setClientSocketAndUserName(this.clientSocket, this.userName);
        menuModel.addObserver(controllerMainWindow);
        controllerMainWindow.setModelMainWindow(menuModel);

        mainStage.setTitle(Constants.TITLE_NAME);
        mainStage.setScene(scene);
        mainStage.show();

        mainStage.setOnCloseRequest(we -> menuModel.sendNotificationLogout());
    }


    public static void main(String[] args) {
        Application.launch();
    }

}
