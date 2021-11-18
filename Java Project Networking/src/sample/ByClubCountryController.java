package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class ByClubCountryController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private Label playerLabel;

    @FXML
    private TextField countryText;

    @FXML
    private Button submit;

    @FXML
    private Label playerLabel1;

    @FXML
    private TextField clubText;

    @FXML
    void submit(ActionEvent actionEvent) {
        //String clubName = clubText.getText();
        String countryName = countryText.getText();
        List<Player> tempPlayerList=Search.searchByCountryClub(countryName, main.getClubName(),main.getCountryList());
         if(tempPlayerList.size()!=0) {
             try {
                 main.showResultPage(tempPlayerList);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
         else{
             main.showAlertByClubCountry();
             try {
                 main.showSearchPlayersPage();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
    }
    public void setClubText(){
        clubText.setText(main.getClubName());
    }
    private void reset() {
        clubText.setText(null);
        countryText.setText(null);
    }

}
