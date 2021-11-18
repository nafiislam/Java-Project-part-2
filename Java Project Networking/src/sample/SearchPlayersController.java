package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SearchPlayersController {
    @FXML
    public Button byPlayerName;
    @FXML
    public Button byPosition;
    @FXML
    public Button byClubAndCountry;
    @FXML
    public Button countryWisePlayerCount;
    @FXML
    public Button bySalaryRange;
    @FXML
    public Button back;
    private Main main;

    void setMain(Main main) {
        this.main = main;

    }
    @FXML
    public void back(ActionEvent actionEvent) {
        try {
            main.showMenuPage(main.getClubName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void byPlayerName(ActionEvent actionEvent) {
        try {
            main.showByPlayerPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void byPosition(ActionEvent actionEvent) {
        try {
            main.showByPosition();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void byClubAndCountry(ActionEvent actionEvent) {
        try {
            main.showByClubCountryPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void countryWisePlayerCount(ActionEvent actionEvent) {
        try {
            main.showByCountryWisePlayerCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void bySalaryRange(ActionEvent actionEvent) {
        try {
            main.showBySalaryRange();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
