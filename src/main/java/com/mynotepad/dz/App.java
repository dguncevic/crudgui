package com.mynotepad.dz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.mynotepad.dz.*;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    public static void main(String[] args) {
        App.launch();

    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(App.class.getResource("main.fxml"));
        scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();

    }
}
