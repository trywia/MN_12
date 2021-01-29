package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

public class AnimationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pnBackground;

    @FXML
    private ChoiceBox<?> cbBox;

    @FXML
    void initialize() {
        assert pnBackground != null : "fx:id=\"pnBackground\" was not injected: check your FXML file 'animation.fxml'.";
        assert cbBox != null : "fx:id=\"cbBox\" was not injected: check your FXML file 'animation.fxml'.";
    }
}