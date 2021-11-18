package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;


public class MenuController {

    @FXML
    private Button searchPlayer;

    @FXML
    private Button searchClubs;

    @FXML
    private Button sell;

    @FXML
    private Button exit;

    @FXML
    private Label club;

    @FXML
    private Button buy;

    private Main main;

    void setMain(Main main) {
        this.main = main;
    }
    void setLabel(){
        club.setText(main.getClubName());
    }
    @FXML
    public void searchPlayer(ActionEvent actionEvent) {
        try {
            main.showSearchPlayersPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitMenu(ActionEvent actionEvent) {
        try {
            main.getNetworkUtil().write("Remove");
            main.getNetworkUtil().write(main.getClubName());
            //main.getNetworkUtil().write("ThreadStop");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchClubs(ActionEvent actionEvent) {
        try {
            main.showSearchClubsPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sell(ActionEvent actionEvent) {
        try {
            main.showSellPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buy(ActionEvent actionEvent) {
        try {
            /*try {
                //main.getNetworkUtil().write("List");
                //Thread.sleep(5000);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            main.showBuyPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
