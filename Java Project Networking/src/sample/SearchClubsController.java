package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SearchClubsController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private Button maximumSalary;

    @FXML
    private Button maximumHeight;

    @FXML
    private Button maximumAge;

    @FXML
    private Button totalYearlySalary;

    @FXML
    private Button back;

    @FXML
    void back(ActionEvent actionEvent) {
        try {
            main.showMenuPage(main.getClubName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void maximumAge(ActionEvent actionEvent) {
        try {
            main.showByClub(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void maximumHeight(ActionEvent actionEvent) {
        try {
            main.showByClub(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void maximumSalary(ActionEvent event) {
        try {
            main.showByClub(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void totalYearlySalary(ActionEvent event) {
        try {
            main.showByClub(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
