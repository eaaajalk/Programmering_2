import org.json.JSONObject;

public class main {

    public static void main(String[] args) {

        String player1 = "{ navn : 'Lars', retning : 'w', score : '2000',  position : {x:'2', y:'4'} }";
        JSONObject jo = new JSONObject(player1);
        String navn = jo.getString("navn");
        String retning = jo.getString("retning");
        int score = jo.getInt("score");
        JSONObject jo1 = jo.getJSONObject("position");
        int x = jo1.getInt("x");
        int y = jo1.getInt("y");


        System.out.println(navn + " " + retning+ " " + score + " " + x + " " + y);


    }
}
