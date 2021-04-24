package com.ahd;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 // write by Ahmed Rahman Hassani
 */
@SpringBootApplication
public class Main  extends Application {

    static ConfigurableApplicationContext context;



    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(fxmlLoader.load()));
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        System.out.print(primaryScreenBounds.getWidth());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        stage.show();
    }

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(Main.class);
        Font.loadFont(Main.class.getResource("/font/PottaOne.ttf").toExternalForm(),13);
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }


}
