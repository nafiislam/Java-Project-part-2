package server;

import sample.*;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;
    public List<Player> playerList;
    public List<Club>clubList;
    public List<Country>countryList;
    public List<Player>marketPlayerList;
    public List<String> logged;
    public HashMap<String , NetworkUtil> clientMap;

    Server() {
        userMap = new HashMap<>();
        userMap.put("Manchester United", "123");
        userMap.put("Manchester City", "123");
        userMap.put("Chelsea", "123");
        userMap.put("Liverpool", "123");
        userMap.put("Arsenal", "123");
        try {
            playerList = FileOperation.readFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clubList = new ArrayList();
        countryList= new ArrayList();
        logged=new ArrayList<>();
        marketPlayerList=new ArrayList<>();
        clientMap=new HashMap<>();
        for(Player s: playerList){
            AdderCreation.clubListAdder(clubList,s);
        }
        for(Player s: playerList){
            AdderCreation.countryListAdder(countryList,s);
        }
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(clientMap,userMap, playerList, networkUtil,logged,marketPlayerList);
    }

    public static void main(String[] args) {
        new Server();
    }
}
