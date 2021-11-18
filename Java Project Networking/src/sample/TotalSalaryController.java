package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TotalSalaryController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private Label club;

    @FXML
    private Label salary;
    public void init(String Salary,String clubName){
        salary.setText(Salary);
        club.setText(clubName);
    }
    @FXML
    void back(ActionEvent actionEvent) {
        try {
            main.showSearchClubsPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
