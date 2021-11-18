package server;

import sample.BuyMarket;
import sample.Player;
import util.LoginDTO;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;
    public HashMap<String, String> userMap;
    public List<Player>playerList;
    public List<String> logged;
    private List<Player>marketPlayerList;
    public HashMap<String , NetworkUtil> clientMap;


    public ReadThreadServer(HashMap<String,NetworkUtil>clientMap,HashMap<String, String> map, List<Player>playerList,NetworkUtil networkUtil,List<String>logged,List<Player>marketPlayerList) {
        this.userMap = map;
        this.networkUtil = networkUtil;
        this.playerList=playerList;
        this.logged=logged;
        this.marketPlayerList=marketPlayerList;
        this.clientMap=clientMap;
        this.thr = new Thread(this);
        thr.start();
    }
    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        if(logged.contains(loginDTO.getUserName())){
                            networkUtil.write("Already logged");
                        }
                        else{
                            if(!userMap.containsKey(loginDTO.getUserName())){
                                networkUtil.write("Not Exist");
                            }
                            else{
                                String password = userMap.get(loginDTO.getUserName());
                                loginDTO.setStatus(loginDTO.getPassword().equals(password));
                                if(loginDTO.isStatus()){
                                    logged.add(loginDTO.getUserName());
                                    clientMap.put(loginDTO.getUserName(),networkUtil);
                                    BuyMarket object=new BuyMarket();
                                    object.setPlayerList(marketPlayerList);
                                    networkUtil.write(object);

                                }
                                networkUtil.write(loginDTO);
                            }
                        }
                    }
                    else if(o instanceof String){
                        String clubName=(String) o;
                        if(clubName.equals("Remove")){
                            String name=(String) networkUtil.read();
                            logged.remove(name);
                            //networkUtil.write("ThreadStop");
                            //System.out.println("success");
                            for(String s:clientMap.keySet()){
                                if(s.equalsIgnoreCase(clubName)){
                                    clientMap.remove(s);
                                    break;
                                }
                            }
                        }
                        else if(clubName.equals("List")){
                            networkUtil.write("List");
                            networkUtil.write(marketPlayerList);
                        }
                        else if(clubName.equals("ThreadStop")){
                            networkUtil.write("ThreadStop");
                        }
                        else{
                            List<Player>tempPlayerList=new ArrayList<>();
                            for(Player p:playerList){
                                if(p.getClub().equalsIgnoreCase(clubName)){
                                    tempPlayerList.add(p);
                                }
                            }
                            networkUtil.write(tempPlayerList);
                        }
                    }
                    else if(o instanceof Player){
                        Player p=(Player) o;
                        String club=(String) networkUtil.read();
                        String command=(String) networkUtil.read();
                        if(command.equals("Sell")){
                            boolean isPresent=false;
                            for(Player s:marketPlayerList){
                                if(s.getName().equals(p.getName())){
                                    isPresent=true;
                                }
                            }
                            if(!isPresent){
                                marketPlayerList.add(p);
                                //System.out.println(p.getPrice());
                                BuyMarket object=new BuyMarket();
                                object.setPlayerList(marketPlayerList);
                                for(String s:clientMap.keySet()){
                                    clientMap.get(s).write(object);
                                }
                                //System.out.println(marketPlayerList.size());

                            }
                            else {
                                networkUtil.write("Wrong sell");
                            }
                        }
                        else if(command.equals("Buy")){
                            if(p.getClub().equalsIgnoreCase(club)){
                                networkUtil.write("Wrong buy");
                            }
                            else{
                                String previousClub=p.getClub();
                                String newClub=club;
                                p.setClub(newClub);
                                for(Player pl: playerList){
                                    if(pl.getName().equalsIgnoreCase(p.getName())){
                                        playerList.remove(pl);
                                        playerList.add(p);
                                        break;
                                    }
                                }
                                for(Player pl:marketPlayerList){
                                    if(pl.getName().equalsIgnoreCase(p.getName())){
                                        marketPlayerList.remove(pl);
                                        break;
                                    }
                                }
                                for(String s:clientMap.keySet()){
                                    if(s.equalsIgnoreCase(previousClub)){
                                        clientMap.get(s).write(p);
                                        clientMap.get(s).write("Remove");
                                        //System.out.println("send remove");
                                    }
                                    else if(s.equalsIgnoreCase(newClub)){
                                        clientMap.get(s).write(p);
                                        clientMap.get(s).write("Add");
                                        //System.out.println("send add");
                                    }
                                }
                                BuyMarket object=new BuyMarket();
                                object.setPlayerList(marketPlayerList);
                                for(String s:clientMap.keySet()){
                                    clientMap.get(s).write(object);
                                }
                            }
                        }
                        else{

                        }
                    }
                    else if(o instanceof BuyMarket){
                        BuyMarket obj=new BuyMarket();
                        obj.setPlayerList(marketPlayerList);
                        System.out.println(obj.getPlayerList().size());
                        networkUtil.write(obj);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



