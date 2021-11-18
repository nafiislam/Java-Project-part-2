package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ByPlayerController {
    public Button submit;
    private Main main;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField playerText;

    @FXML
    private Label playerLabel;

    public void setMain(Main main) {
        this.main = main;
    }

    public void submit(ActionEvent actionEvent) {
        String playerName = playerText.getText();
        Player s =Search.searchByName(playerName,main.getPlayerList());
        if(s!=null) {
            List<Player> tempPlayerList = new ArrayList<>();
            tempPlayerList.add(s);
            try {
                main.showResultPage(tempPlayerList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            main.showAlertByPlayer();
            try {
                main.showSearchPlayersPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void reset() {
        playerText.setText(null);
    }
}




