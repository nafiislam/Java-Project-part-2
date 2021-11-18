package sample;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import util.LoginDTO;

import java.io.IOException;
import java.util.List;
import java.util.SplittableRandom;

public class ReadThread implements Runnable {
    private final Thread thr;
    private final Main main;

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        // the following is necessary to update JavaFX UI components from user created threads
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (loginDTO.isStatus()) {
                                    try {
                                        main.getNetworkUtil().write(loginDTO.getUserName());
                                        main.showMenuPage(loginDTO.getUserName());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    main.showAlertLogin();
                                }

                            }
                        });
                    }
                    else if (o instanceof List) {
                        List<Player> playerList= (List) o;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    main.setPlayerList(playerList);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    else if (o instanceof Player) {
                        Player p= (Player) o;
                        String command=(String) main.getNetworkUtil().read();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if(command.equalsIgnoreCase("Remove")){
                                        for(Player pl: main.getPlayerList()){
                                            if(pl.getName().equalsIgnoreCase(p.getName())){
                                                main.getPlayerList().remove(pl);
                                                //System.out.println("removed");
                                                break;
                                            }
                                        }
                                    }
                                    else if(command.equalsIgnoreCase("Add")){
                                        main.getPlayerList().add(p);
                                        //System.out.println("added");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    else if (o instanceof BuyMarket) {
                        BuyMarket obj= (BuyMarket) o;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    main.setMarketPlayerList(obj.getPlayerList());
                                    if(main.getStage().getTitle().equalsIgnoreCase("Buy Player List")){
                                        main.showBuyPage();
                                    }
                                    else if(main.getStage().getTitle().equalsIgnoreCase("Sell Player List")){
                                        main.showSellPage();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    else if (o instanceof String) {
                        String temp= (String) o;
                        if(temp.equals("Not Exist")){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        showAlert();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        else if(temp.equals("Already logged")){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        showAlert2();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        else if(temp.equals("Wrong sell")){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        showAlert3();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        else if(temp.equals("Wrong buy")){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        showAlert4();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        else if(temp.equals("ThreadStop")){
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getNetworkUtil().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void showAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!!");
        alert.setHeaderText("No such club exists");
        alert.showAndWait();
    }
    public void showAlert2(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!!");
        alert.setHeaderText("Already logged");
        alert.showAndWait();
    }
    public void showAlert3(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!!");
        alert.setHeaderText("Already in the market");
        alert.showAndWait();
    }
    public void showAlert4(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!!");
        alert.setHeaderText("You cannot buy your own player");
        alert.showAndWait();
    }
}



