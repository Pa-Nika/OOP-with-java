package ru.nsu.panova.lab5.client.client.entranceWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nsu.panova.lab5.client.client.Constants;
import ru.nsu.panova.lab5.client.client.loaders.InterfaceLoaders;
import ru.nsu.panova.lab5.client.client.Client;

public class LoaderEntranceWindow extends Application implements InterfaceLoaders {
    private final ModelEntranceWindow modelEntranceWindow = new ModelEntranceWindow();

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource(Constants.ENTRANCE_WINDOW_FXML));
        Scene scene = new Scene(fxmlLoader.load(), Constants.WIDTH_WINDOW, Constants.HEIGHT_WINDOW);

        ControllerEntranceWindow controllerEntranceWindow = fxmlLoader.getController();
        controllerEntranceWindow.setModelEntranceWindow(modelEntranceWindow);
        modelEntranceWindow.addObserver(controllerEntranceWindow);

        mainStage.setTitle(Constants.TITLE_NAME);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
