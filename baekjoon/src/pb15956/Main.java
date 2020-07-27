package pb15956;

import java.util.*;

class Bucket{
    HashMap<String, Integer> map = new HashMap<>();
    String minStr;

    public void addString(String str){
        map.put(str, str.length());
    }

    public Set<String> getKeys(){
        return map.keySet();
    }

    public String getLowest(){
        Iterator itr = map.entrySet().iterator();
        int min = Integer.MAX_VALUE;

        while(itr.hasNext()){
            Map.Entry mapElement = (Map.Entry)itr.next();
            String key = (String)mapElement.getKey();
            int val = (int)mapElement.getValue();

            if(min > val){
                min = val;
                minStr = key;
            }
        }
        return minStr;
    }
}

public class Main {
    String input;
    ArrayList<String> equationList = new ArrayList<>();
    ArrayList<Bucket> bucketList = new ArrayList<>();

    public static void main(String[] args){
        Main myMain = new Main();
        myMain.initialize();
        myMain.solve();
    }

    private void initialize(){
        Scanner scan = new Scanner(System.in);
        input = scan.next();
//        System.out.println(input);

        for(String s : input.split("&&")){
            equationList.add(s);
        }

        // Print equationList
        System.out.println(equationList);
    }

    private void solve(){
        // Update bucketList
        for(int i=0;i<equationList.size();i++){
            String eq = equationList.get(i);
            String[] strs = eq.contains("==")? eq.split("==") : eq.split("!=");
            updateBucketList(strs);
        }

        // Print bucketList
        System.out.println("bucketList size : "+bucketList.size());
        for(int i=0;i<bucketList.size();i++){
            System.out.println(bucketList.get(i).getKeys());
        }

        // Update equation
        for(int i=0;i<equationList.size();i++){
            String eq = equationList.get(i);
            String[] strs = eq.contains("==")? eq.split("==") : eq.split("!=");

        }
    }

    private void updateBucketList(String[] strs){
        for(int i=0;i<bucketList.size();i++){
            Bucket b = bucketList.get(i);
            Set<String> keys = b.getKeys();


            if(keys.contains(strs[0]) || keys.contains(strs[1])){
                b.addString(strs[0]);
                b.addString(strs[1]);
                return;
            }

        }
        Bucket b = new Bucket();
        b.addString(strs[0]);
        b.addString(strs[1]);
        bucketList.add(b);
    }
}
