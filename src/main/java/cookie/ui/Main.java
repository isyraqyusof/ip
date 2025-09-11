package cookie.ui;

import java.io.IOException;

import cookie.Cookie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Cookie using FXML.
 */
public class Main extends Application {

    private Cookie cookie = new Cookie("data/cookie.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            fxmlLoader.<MainWindow>getController().setCookie(cookie);  // inject the Cookie instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
