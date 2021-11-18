package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class BySalaryRangeController {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private Label playerLabel;

    @FXML
    private TextField lowerLimit;

    @FXML
    private Button submit;

    @FXML
    private Label playerLabel1;

    @FXML
    private TextField higherLimit;
    @FXML
    void submit(ActionEvent event) {
        double low=0;
        double high= 0;
        try {
            low = Double.parseDouble(lowerLimit.getText());
            high = Double.parseDouble(higherLimit.getText());
            List<Player> tempPlayerList=Search.searchBySalary(low,high,main.getPlayerList());
            if(tempPlayerList.size()!=0) {
                try {
                    main.showResultPage(tempPlayerList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                main.showAlertBySalaryRange();
                try {
                    main.showSearchPlayersPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            main.showAlert();
            reset();

        }
    }

    private void reset() {
        lowerLimit.setText(null);
        higherLimit.setText(null);
    }


}
