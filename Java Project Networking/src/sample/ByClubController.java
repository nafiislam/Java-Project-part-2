package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.List;

public class ByClubController {
    private Main main;
    private int option;

    public void setOption(int option) {
        this.option = option;
    }
    public void setClubText(){
        clubText.setText(main.getClubName());
    }

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private TextField clubText;

    @FXML
    private Label playerLabel;

    @FXML
    private Button submit;

    @FXML
    void submit(ActionEvent actionEvent) {
        String clubName=clubText.getText();
        Club c=SearchClub.searchByClub(clubName,main.getClubList());
        if(c==null){
            main.showAlertByClub();
            try {
                main.showSearchClubsPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            List<Player>tempPlayerList;
            if(option==1){
                tempPlayerList=c.showSalary();
                try {
                    main.showResultClubPage(tempPlayerList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(option==2){
                tempPlayerList=c.showAge();
                try {
                    main.showResultClubPage(tempPlayerList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(option==3){
                tempPlayerList=c.showHeight();
                try {
                    main.showResultClubPage(tempPlayerList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(option==4){
                double d = c.showTotalSalary();
                //String salary= Double.toString(d);
                //String salary= d+"";
                String pattern = "##########.##";
                DecimalFormat decimalFormat = new DecimalFormat(pattern);

                String salary=decimalFormat.format(d);
                try {
                    main.showTotalSalaryPage(salary,c.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }


    }
}
