import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.*;
import javax.swing.Timer;
public class GamePanel extends JPanel{
	ArrayList<Player> players;
	InputHandler input;
	GamePanel()
	{
		players=new ArrayList<>();
		players.add(new Player(200,100,50,50));
		players.add(new Player(150,100,50,50));
		players.add(new Player(100,100,50,50));
		input=new InputHandler();
		addKeyListener(input);
		setFocusable(true);
		Timer timer=new Timer(32,e->{
			for(Player player:players){
			if(input.right)
				player.x+=2;
			if(input.left)
				player.x-=2;
			if(input.up)
                                player.y-=2;
                        if(input.down)
                                player.y+=2;
			}
			repaint();
		});
		timer.start();
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
