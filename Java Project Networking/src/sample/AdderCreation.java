package sample;

import javafx.scene.control.Alert;

import java.util.List;

public class AdderCreation {
    public static void playerCreation(Player pl,String line){
        String[] tokens1 =line.split(",");
        pl.setName(tokens1[0]);
        pl.setCountry(tokens1[1]);
        pl.setAge((Integer.parseInt(tokens1[2])));
        pl.setHeight(Double.parseDouble(tokens1[3]));
        pl.setClub(tokens1[4]);
        pl.setPosition(tokens1[5]);
        pl.setNumber(Integer.parseInt(tokens1[6]));
        pl.setSalary(Double.parseDouble(tokens1[7]));
    }
    public static void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!!");
        alert.setHeaderText("Club is not available");
        alert.showAndWait();
    }
    public static boolean clubListAdder(List<Club> clubList, Player pl){
        boolean isClubPresent=false;
        for (Club c:clubList){
            if(c.getName().equalsIgnoreCase(pl.getClub())){
                isClubPresent=true;
                c.addPlayer(pl);
                return true;
            }
        }
        if(!isClubPresent){
            Club c2=new Club();
            c2.setName(pl.getClub());
            c2.addPlayer(pl);
            clubList.add(c2);
            return true;
        }
        return false;
    }

    public static void countryListAdder(List<Country> countryList,Player s){
        Country co=new Country();
        co.setName(s.getCountry());
        co.addPlayer(s);
        boolean isCountry=false;
        for(int i=0;i<countryList.size();i++){
            if(s.getCountry().equalsIgnoreCase(countryList.get(i).getName())){
                countryList.get(i).addPlayer(s);
                isCountry=true;
                break;
            }
        }
        if(!isCountry){
            countryList.add(co);
        }
    }
}
