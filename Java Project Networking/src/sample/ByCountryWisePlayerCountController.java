package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class ByCountryWisePlayerCountController {
    private Main main;
    private List<Country> desiredCountryList;

    public void setDesiredCountryList(List<Country> desiredCountryList) {
        this.desiredCountryList = desiredCountryList;
    }

    @FXML
    private TableView<Country> tableView;

    @FXML
    private Button back;

    ObservableList<Country> data;
    private boolean init = true;


    private void initializeColumns() {
        TableColumn<Country, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Country, Integer> playerCountCol = new TableColumn<>("Player Count");
        playerCountCol.setMinWidth(150);
        playerCountCol.setCellValueFactory(new PropertyValueFactory<>("playerCount"));

        tableView.getColumns().addAll(nameCol,playerCountCol);
    }

    public void load() {
        if (init) {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();
        //List<Player> tempPlayerList=main.getPlayerList();
        for(Country s:desiredCountryList){
            data.add(s);
        }

        tableView.setEditable(true);
        tableView.setItems(data);
    }
    @FXML
    void back(ActionEvent actionEvent) {
        try {
            main.showSearchPlayersPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
