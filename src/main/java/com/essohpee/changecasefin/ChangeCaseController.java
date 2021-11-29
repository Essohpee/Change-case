package com.essohpee.changecasefin;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeCaseController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private TextField UpperField;
    @FXML
    private TextField LowerField;
    @FXML
    private TextField inputField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public boolean isMaximized(Event event) {
        Stage s = ((Stage) (((Node) (event.getSource())).getScene().getWindow()));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        return s.getWidth() == bounds.getWidth() && s.getHeight() == bounds.getHeight();
    }

    @FXML
    public void RootMousePressed(Event event) {
        MouseEvent e = (MouseEvent) event;
        xOffset = e.getSceneX();
        yOffset = e.getSceneY();
    }

    @FXML
    public void RootMouseDragged(Event event) {
        if (isMaximized(event)) {
            return;
        }
        MouseEvent e = (MouseEvent) event;
        ((Stage) (((Node) (event.getSource())).getScene().getWindow())).setX(e.getScreenX() - xOffset);
        ((Stage) (((Node) (event.getSource())).getScene().getWindow())).setY(e.getScreenY() - yOffset);
    }

    @FXML
    private void keyPressedAction(KeyEvent event) {
        UpperField.setText(inputField.getText().toUpperCase());
        LowerField.setText(inputField.getText().toLowerCase());
    }
}