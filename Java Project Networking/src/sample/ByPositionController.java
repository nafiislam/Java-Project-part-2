package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class ByPositionController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private Label playerLabel;

    @FXML
    private TextField positionText;

    @FXML
    private Button submit;

    @FXML
    void submit(ActionEvent actionEvent) {
        String position = positionText.getText();
        List<Player> tempPlayerList=Search.searchByPosition(position,main.getPlayerList());
        if(tempPlayerList.size()!=0) {
            try {
                main.showResultPage(tempPlayerList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            main.showAlertByPosition();
            try {
                main.showSearchPlayersPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
