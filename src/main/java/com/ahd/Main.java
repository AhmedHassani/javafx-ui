package com.ahd;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(Main.class);
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }


}
