import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.*;
public class GamePanel extends JPanel{
	ArrayList<Player> players;
	GamePanel()
	{
		players=new ArrayList<>();
		players.add(new Player(100,100,50,50));
		players.add(new Player(150,100,50,50));
		players.add(new Player(200,100,50,50));
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Player player:players)
		{
		g.fillRect(player.x,player.y,player.w,player.h);
		}
	}
}
