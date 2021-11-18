package sample;
import java.util.List;

public class SearchClub {
    /*public static void searchClub(List<Player>playerList, List<Club>clubList, List<Country>countryList){
        Scanner scn = new Scanner(System.in);
        Club temp;
        double salary;
        List<Player> tempPlayerList;
        System.out.println("Club Searching Options:\n" +
                "(1) Player(s)with the maximum salary of a club\n" +
                "(2) Player(s)with the maximum age of a club\n" +
                "(3) Player(s)with the maximum height of a club\n" +
                "(4) Total yearly salary of a club\n" +
                "(5) Back to Main Menu");
        System.out.print("Input Option:");
        int d=scn.nextInt();
        scn.nextLine();
        if(d==1) {
            System.out.print("Input Club Name:");
            String nc=scn.nextLine();
            temp=searchByClub(nc,clubList);
            if(temp==null)
                System.out.println("No such club with this name");
            else {
                tempPlayerList=temp.showSalary();
                for(Player p:tempPlayerList)
                    p.show();
            }
            searchClub(playerList,clubList,countryList);
        }
        else if(d==2) {
            System.out.print("Input Club Name:");
            String nc=scn.nextLine();
            temp=searchByClub(nc,clubList);
            if(temp==null)
                System.out.println("No such club with this name");
            else {
                tempPlayerList=temp.showAge();
                for(Player p:tempPlayerList)
                    p.show();
            }
            searchClub(playerList,clubList,countryList);
        }
        else if(d==3) {
            System.out.print("Input Club Name:");
            String nc=scn.nextLine();
            temp=searchByClub(nc,clubList);
            if(temp==null){
                System.out.println("No such club with this name");
            }
            else {
                tempPlayerList=temp.showHeight();
                for(Player p:tempPlayerList)
                    p.show();
            }
            searchClub(playerList,clubList,countryList);
        }
        else if(d==4){
            System.out.print("Input Club Name:");
            String nc=scn.nextLine();
            temp=searchByClub(nc,clubList);
            if(temp==null)
                System.out.println("No such club with this name");
            else {
                salary = temp.showTotalSalary();
                System.out.printf("Total yearly salary is %10f\n",salary);
            }

            searchClub(playerList,clubList,countryList);
        }
        else if(d==5)
            Method.menu(playerList,clubList,countryList);
        else{
            System.out.println("Error:Inputs must be between 1-5");
            searchClub(playerList,clubList,countryList);
        }
    }*/
    public static Club searchByClub(String name, List<Club> clubList){
        for( Club c:clubList){
            if(c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }

}
