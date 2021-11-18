package sample;

import java.util.ArrayList;
import java.util.List;

public class Club {
    String name;
    //private Player[] players;
    private List<Player> playerList;
    private int playerCount;
    Club(){
        playerList= new ArrayList<>();
        playerCount=0;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public String getName() {
        return name;
    }
    public int getPlayerCount() {
        return playerCount;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addPlayer(Player p){
        playerCount++;
        playerList.add(p);
    }
    public List<Player> showSalary(){
        double d=0;
        List<Player> tempPlayerList=new ArrayList();
        for(int i=0;i<playerCount;i++){
            if(playerList.get(i).getSalary()>d)
                d= playerList.get(i).getSalary();
        }
        for(int i=0;i<playerCount;i++){
            if(playerList.get(i).getSalary()==d)
                tempPlayerList.add(playerList.get(i));
        }
        return tempPlayerList;
    }
    public List<Player> showAge(){
        int d=0;
        List<Player> tempPlayerList=new ArrayList();
        for(int i=0;i<playerCount;i++){
            if(playerList.get(i).getAge()>d) {
                d = playerList.get(i).getAge();
            }
        }
        for(int i=0;i<playerCount;i++){
            if(playerList.get(i).getAge()==d)
                tempPlayerList.add(playerList.get(i));
        }
        return tempPlayerList;
    }
    public List<Player> showHeight(){
        double d=0;
        List<Player> tempPlayerList=new ArrayList();
        for(int i=0;i<playerCount;i++){
            if(playerList.get(i).getHeight()>d)
                d= playerList.get(i).getHeight();
        }
        for(int i=0;i<playerCount;i++){
            if(playerList.get(i).getHeight()==d)
                tempPlayerList.add(playerList.get(i));
        }
        return tempPlayerList;
    }
    public double showTotalSalary(){
        double d=0;
        for(int i=0;i<playerCount;i++){
            d+= playerList.get(i).getSalary()*52;
        }
        return d;
    }

}
