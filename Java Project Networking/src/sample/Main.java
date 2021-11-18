package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    private NetworkUtil networkUtil;
    private String clubName;
    public List<Player> playerList;
    private List<Club>clubList;
    private  List<Country>countryList;
    private List<Player> marketPlayerList;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
    public List<Club> getClubList() {
        return clubList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public String getClubName() {
        return clubName;
    }

    public Stage getStage() {
        return stage;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public List<Player> getMarketPlayerList() {
        return marketPlayerList;
    }

    public void setMarketPlayerList(List<Player> marketPlayerList) {
        this.marketPlayerList = marketPlayerList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        marketPlayerList=new ArrayList<>();
        connectToServer();
        showLoginPage();
    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 668, 521));
        stage.show();
    }
    public void showMenuPage(String clubName) throws Exception {
        // XML Loading using FXMLLoader
        this.clubName=clubName;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MenuController controller = loader.getController();
        controller.setMain(this);
        controller.setLabel();

        // Set the primary stage
        stage.setTitle("Menu");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }
    public void showSearchPlayersPage() throws Exception {
        clubList = new ArrayList();
        countryList= new ArrayList();
        for(Player s: playerList){
            AdderCreation.clubListAdder(clubList,s);
        }
        for(Player s: playerList){
            AdderCreation.countryListAdder(countryList,s);
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchPlayers.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SearchPlayersController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search Players");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }
    public void showByPlayerPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("byPlayer.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByPlayerController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By Players");
        stage.setScene(new Scene(root, 600, 200));
        stage.show();
    }
    public void showResultPage(List<Player> tempPlayerList) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("result.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ResultController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);
        controller.setDesiredPlayerLIst(tempPlayerList);
        controller.load();
        // Set the primary stage
        stage.setTitle("Result");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }
    public void showResultClubPage(List<Player> tempPlayerList) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("resultClub.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ResultClubController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);
        controller.setDesiredPlayerLIst(tempPlayerList);
        controller.load();
        // Set the primary stage
        stage.setTitle("Result Club");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }
    public void showByPosition() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("byPosition.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByPositionController controller = loader.getController();
        controller.setMain(this);
        // Set the primary stage
        stage.setTitle("BY Position");
        stage.setScene(new Scene(root, 600, 300));
        stage.show();
    }
    public void showBySalaryRange() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("bySalaryRange.fxml"));
        Parent root = loader.load();
        // Loading the controller
        BySalaryRangeController controller = loader.getController();
        controller.setMain(this);
        // Set the primary stage
        stage.setTitle("BY Salary Range");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showByCountryWisePlayerCount() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("byCountryWisePlayerCount.fxml"));
        Parent root = loader.load();
        // Loading the controller
        ByCountryWisePlayerCountController controller = loader.getController();
        controller.setMain(this);
        controller.setDesiredCountryList(countryList);
        controller.load();
        // Set the primary stage
        stage.setTitle("By Country-Wise Player Count");
        stage.setScene(new Scene(root, 300, 600));
        stage.show();
    }
    public void showByClubCountryPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("byClubCountry.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByClubCountryController controller = loader.getController();
        controller.setMain(this);
        controller.setClubText();
        // Set the primary stage
        stage.setTitle("By Country");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showSearchClubsPage() throws Exception {
        clubList = new ArrayList();
        countryList= new ArrayList();
        for(Player s: playerList){
            AdderCreation.clubListAdder(clubList,s);
        }
        for(Player s: playerList){
            AdderCreation.countryListAdder(countryList,s);
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchClubs.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SearchClubsController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search Clubs");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }
    public void showByClub(int option) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("byClub.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ByClubController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);
        controller.setOption(option);
        controller.setClubText();

        // Set the primary stage
        stage.setTitle("Search By Club");
        stage.setScene(new Scene(root, 600, 200));
        stage.show();
    }
    public void showTotalSalaryPage(String salary, String clubName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("totalSalary.fxml"));
        Parent root = loader.load();

        // Loading the controller
        TotalSalaryController controller = loader.getController();
        controller.setMain(this);
        controller.init(salary,clubName);
        // Set the primary stage
        stage.setTitle("Total Salary");
        stage.setScene(new Scene(root, 532, 177));
        stage.show();
    }
    public void showSellPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sell.fxml"));
        Parent root = loader.load();
        // Loading the controller
        SellController controller = loader.getController();
        controller.setMain(this);
        controller.load();
        // Set the primary stage
        stage.setTitle("Sell Player List");
        stage.setScene(new Scene(root, 1000, 600));
        stage.show();
    }
    public void showBuyPage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("buy.fxml"));
        Parent root = loader.load();
        // Loading the controller
        BuyController controller = loader.getController();
        controller.setMain(this);
        controller.load();
        // Set the primary stage
        stage.setTitle("Buy Player List");
        stage.setScene(new Scene(root, 1000, 700));
        stage.show();
    }
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Input");
        alert.setHeaderText("The input you provided is not correct.");
        //alert.setContentText("The input you provided is not correct.");
        alert.showAndWait();
    }
    public void showAlertLogin() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }
    public void showAlertByPlayer() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No player");
        alert.setHeaderText("No such player with this name");
        alert.showAndWait();
    }
    public void showAlertByPosition() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No player");
        alert.setHeaderText("No such player with this position");
        alert.showAndWait();
    }
    public void showAlertBySalaryRange() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No player");
        alert.setHeaderText("No such player with this weekly salary range");
        alert.showAndWait();
    }
    public void showAlertByClubCountry() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No player");
        alert.setHeaderText("No such player with this country");
        alert.showAndWait();
    }
    public void showAlertByClub() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No club");
        alert.setHeaderText("No such club with this name");
        alert.showAndWait();
    }


    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }
}
