package sample;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private List<Player> players;
    private int playerCount;
    Country(){
        players= new ArrayList();
        playerCount=0;
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
        players.add(p);
    }
    public List<Player> playerListFull(){
        return players;
    }
    public List<Player> playerListPartial(String club) {
        List<Player> tempPlayerList= new ArrayList();
        for (int i = 0; i < playerCount; i++) {
            if (players.get(i).getClub().equalsIgnoreCase(club)) {
                tempPlayerList.add(players.get(i));
            }
        }
        return tempPlayerList;

    }
}
