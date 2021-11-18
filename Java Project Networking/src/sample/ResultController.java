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


public class ResultController {
    private Main main;
    private List<Player> desiredPlayerLIst;

    public void setDesiredPlayerLIst(List<Player> desiredPlayerLIst) {
        this.desiredPlayerLIst = desiredPlayerLIst;
    }

    @FXML
    private TableView<Player> tableView;

    @FXML
    private Button back;

    ObservableList<Player> data;
    private boolean init = true;


    private void initializeColumns() {
        TableColumn<Player, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(160);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Player, String> countryCol = new TableColumn<>("Country");
        countryCol.setMinWidth(120);
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<Player, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setMinWidth(80);
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Player, Double> heightCol = new TableColumn<>("Height");
        heightCol.setMinWidth(80);
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Player, String> clubCol = new TableColumn<>("Club");
        clubCol.setMinWidth(160);
        clubCol.setCellValueFactory(new PropertyValueFactory<>("club"));

        TableColumn<Player, String> positionCol = new TableColumn<>("Position");
        positionCol.setMinWidth(120);
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<Player, Integer> numberCol = new TableColumn<>("Number");
        numberCol.setMinWidth(80);
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Player, Double> salaryCol = new TableColumn<>("Salary");
        salaryCol.setMinWidth(120);
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableView.getColumns().addAll(nameCol, countryCol, ageCol, heightCol,clubCol,positionCol,numberCol,salaryCol);
    }

    public void load() {
        if (init) {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();
        //List<Player> tempPlayerList=main.getPlayerList();
        for(Player s:desiredPlayerLIst){
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
