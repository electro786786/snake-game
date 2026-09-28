import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.*;
import javax.swing.Timer;
public class GamePanel extends JPanel{
	ArrayList<Player> players;
	InputHandler input;
	ArrayList<OldPosition> oldpos;
	int max=3;
	int i=0;
	String prev;
	GamePanel()
	{
		players=new ArrayList<>();
		players.add(new Player(200,100,50,50));
		players.add(new Player(150,100,50,50));
		players.add(new Player(100,100,50,50));
		oldpos=new ArrayList<>();
		oldpos.add(new OldPosition(players.get(0).x,players.get(0).y));
		oldpos.add(new OldPosition(players.get(1).x,players.get(1).y));
		oldpos.add(new OldPosition(players.get(2).x,players.get(2).y));
		input=new InputHandler();
		addKeyListener(input);
		setFocusable(true);
		Timer timer=new Timer(128,e->{
			for(int j=0;j<max;j++)
			{
			oldpos.get(j).x=players.get(j).x;
			oldpos.get(j).y=players.get(j).y;
			}
			if(input.right)
			{	if(prev!="right")
				{ 
					i=0;
				}
					(players.get(0)).x+=50;
					
				
				prev="right";	
			}

			if(input.left)
			{if(prev!="left")i=0;
                               
                                        (players.get(0)).x-=50;
					prev="left";
			
			}
			if(input.up)
                                 {if(prev!="up")i=0;
                             
                                        (players.get(0)).y-=50;
                                      
					prev="up";
                        }
                        if(input.down)
                                 {
				if(prev!="down")
					
                                { i=0;
				}
					(players.get(0)).y+=50;
                                   
					 prev="down";
                                      
                        }
			for(i=1;i<max;i++)
			{
				(players.get(i)).x=oldpos.get(i-1).x;
                          (players.get(i)).y=oldpos.get(i-1).y;
			}
				 
			if(i==max)
                                                i=0;
			
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
