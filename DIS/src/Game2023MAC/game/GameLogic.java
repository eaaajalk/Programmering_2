package Game2023MAC.game;

import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {
public static List<Player> players = new ArrayList<Player>();
public static List<Treasure> treasures = new ArrayList<>();
	public static Player me;
	public static void makePlayers(Player player) {
		me = player;
		players.add(me);
	}
	
	public static pair getRandomFreePosition()
	// finds a random new position which is not wall 
	// and not occupied by other players 
	{
		int x = 1;
		int y = 1;
		boolean foundfreepos = false;
		while  (!foundfreepos) {
			Random r = new Random();
			x = Math.abs(r.nextInt()%18) +1;
			y = Math.abs(r.nextInt()%18) +1;
			if (Generel.board[y].charAt(x)==' ') // er det gulv ?
			{
				foundfreepos = true;
				for (Player p: players) {
					if (p.getXpos()==x && p.getYpos()==y) //pladsen optaget af en anden 
						foundfreepos = false;
				}
			}
		}
		pair p = new pair(x,y);
		return p;
	}

	
	public synchronized static void updatePlayer(int delta_x, int delta_y, String direction) {
		me.direction = direction;
		int x = me.getXpos(),y = me.getYpos();
		if (Generel.board[y+delta_y].charAt(x+delta_x)=='w') {
			me.addPoints(-1);
		} 
		else {
			// collision detection
			Player p = getPlayerAt(x+delta_x,y+delta_y);
			if (p!=null) {
              me.addPoints(50);
              //update the other player
              p.addPoints(-50);
              pair pa = getRandomFreePosition();
              p.setLocation(pa);
              pair oldpos = new pair(x+delta_x,y+delta_y);
              Gui.movePlayerOnScreen(oldpos,pa,p.direction);
			} else 
				me.addPoints(1);
			pair oldpos = me.getLocation();
			pair newpos = new pair(x+delta_x,y+delta_y); 
			Gui.movePlayerOnScreen(oldpos,newpos,direction);
			me.setLocation(newpos);
		}
	}
	
	public static Player getPlayerAt(int x, int y) {
		for (Player p : players) {
			if (p.getXpos()==x && p.getYpos()==y) {
				return p;
			}
		}
		return null;
	}

	public static Player getMe() {
		return me;
	}


}
