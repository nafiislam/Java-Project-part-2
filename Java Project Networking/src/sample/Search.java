package sample;
import java.util.ArrayList;
import java.util.List;

public class Search {
    /*public static void search(List<Player>playerList, List<Club>clubList, List<Country>countryList){
        Scanner scn = new Scanner(System.in);
        Player temp;
        List<Player> tempPlayerList=new ArrayList();
        System.out.println("Player Searching Options:\n" +
                "(1) By Player Name\n" +
                "(2) By Club and Country\n" +
                "(3) By Position\n" +
                "(4) By Salary Range\n" +
                "(5) Country-wise player count\n" +
                "(6) Back to Main Menu");
        System.out.print("Input Option:");
        int b = scn.nextInt();
        scn.nextLine();
        if (b == 1) {
            System.out.print("Input Player Name:");
            String n = scn.nextLine();
            temp=searchByName(n, playerList);
            if(temp==null)
                System.out.println("No such player with this name");
            else{
                temp.show();
            }
            search(playerList,clubList,countryList);
        }
        else if (b == 2) {
            System.out.print("Input Country Name:");
            String country = scn.nextLine();
            System.out.print("Input Club Name:");
            String club = scn.nextLine();
            tempPlayerList=searchByCountryClub(country, club, countryList);
            if(tempPlayerList.size()==0)
                System.out.println("No such player with this country and club");
            else{
                for(Player p:tempPlayerList)
                    p.show();
            }
            search(playerList,clubList,countryList);
        }
        else if (b == 3) {
            System.out.print("Input Position:");
            String position = scn.nextLine();
            tempPlayerList=searchByPosition(position, playerList);
            if(tempPlayerList.size()==0)
                System.out.println("No such player with this position");
            else{
                for(Player p:tempPlayerList)
                    p.show();
            }
            search(playerList,clubList,countryList);
        }
        else if (b == 4) {
            System.out.print("Input Salary low limit:");
            while(!scn.hasNextDouble()){
                System.out.println("Error:Input Salary low limit in double type");
                scn.next();
                System.out.print("Input Salary low limit:");
            }
            double low = scn.nextDouble();
            System.out.print("Input Salary high limit:");
            while(!scn.hasNextDouble()){
                System.out.println("Error:Input Salary high limit in double type");
                scn.next();
                System.out.print("Input Salary low limit:");
            }
            double high = scn.nextDouble();
            tempPlayerList=Search.searchBySalary(low, high, playerList);
            if(tempPlayerList.size()==0)
                System.out.println("No such player with this weekly salary range");
            else{
                for(Player p:tempPlayerList)
                    p.show();
            }
            search(playerList,clubList,countryList);
        }
        else if (b == 5) {
            boolean isC=false;
            for(Country c:countryList){
                System.out.println(c.getName()+ " has "+c.getPlayerCount()+ " players");
                isC=true;
            }
            if(!isC)
                System.out.println("No such country available");
            search(playerList,clubList,countryList);
        }
        else if (b == 6)
            Method.menu(playerList,clubList,countryList);
        else {
            System.out.println("Error:Inputs must be between 1-6");
            search(playerList,clubList,countryList);
        }
    }*/
    public static Player searchByName(String name, List<Player> playerList ){
        for(Player s:playerList){
            if(s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }
    public static List<Player> searchByCountryClub(String country, String club, List<Country> countryList){
        List<Player> tempPlayerList= new ArrayList();
        for(Country c:countryList){
            if(c.getName().equalsIgnoreCase(country)){
                if(club.equalsIgnoreCase("any")){
                    tempPlayerList=c.playerListFull();
                    return tempPlayerList;
                }
                else{
                    tempPlayerList=c.playerListPartial(club);
                    return tempPlayerList;
                }
            }
        }
        return tempPlayerList;
    }
    public static List<Player> searchByPosition(String position, List<Player>playerList){
        List<Player> tempPlayerList=new ArrayList();
        for(Player s:playerList){
            if(s.getPosition().equalsIgnoreCase(position)){
                tempPlayerList.add(s);
            }
        }
        return tempPlayerList;
    }
    public static List<Player> searchBySalary(double low, double high, List<Player> playerList){
        List<Player> tempPlayerList=new ArrayList();
        for(Player s:playerList){
            if(s.getSalary()>=low && s.getSalary()<=high){
                tempPlayerList.add(s);
            }
        }
        return tempPlayerList;

    }
}
