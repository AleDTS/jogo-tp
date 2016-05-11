
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GameRun extends GameBase {
	public static int MAX_BOMBS = 5;
	public static int TOP_BOUND = 0;
	public static int BOTTOM_BOUND = 600;
	public static int LEFT_BOUND = 0;
	public static int RIGHT_BOUND = 600;
	int cont_bombs = 0;
	int visible_bombs = 0;
	Bomber bomber = new Bomber();
	Background bg = new Background();
	Bomb[] bomb = new Bomb[MAX_BOMBS];
	//ArrayList<Bomb> bomb_mem = new ArrayList<Bomb>(MAX_BOMBS);
	//ArrayList<Bomb> bomb = new ArrayList<Bomb>();

	public void init(){
		for (Bomb i: bomb)
			i = new Bomb();
		addKeys(key);
	}

	public void paint(Graphics g){
		bg.draw(g);
		if (cont_bombs > 0)
		for (Bomb i: bomb)
			i.draw(g);
		bomber.draw(g);
	}
	
	Keys key = new Keys(){
		void up(){
			bomber.moveUp(TOP_BOUND);
		}
	    void down(){
	    	bomber.moveDown(BOTTOM_BOUND);
	    }
	    void right(){
	    	bomber.moveRight(RIGHT_BOUND);
	    }
	    void left(){
	    	bomber.moveLeft(LEFT_BOUND);
	    }
	    void action(){
	    	if (bomber.dropBomb(bomb[cont_bombs]))
	    		cont_bombs++;
	    }
	    void tests(){
	    	//System.out.println(bomber.posX + " "+ bomber.posY);
	    	//bomber.reset();
	    	//bomber.colided(bomber.bomb, Bomb.qte);
	    }
	};

	public static void main(String[] args) {
		GameBase run = new GameRun();
		new Start(run, "Teste");
	}
}