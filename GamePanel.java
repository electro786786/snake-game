import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.*;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
public class GamePanel extends JPanel{
	ArrayList<Player> players;
	InputHandler input;
	ArrayList<OldPosition> oldpos;
	Apple apple;
	int max=3;
	int flag=1;
	int i=0;int score=0;
	String prev;
	GamePanel()
	{
		players=new ArrayList<>();
		players.add(new Player(200,100,50,50));
		players.add(new Player(150,100,50,50));
		players.add(new Player(100,100,50,50));
		apple=new Apple(350,350,35,35);
		oldpos=new ArrayList<>();
		oldpos.add(new OldPosition(players.get(0).x,players.get(0).y));
		oldpos.add(new OldPosition(players.get(1).x,players.get(1).y));
		oldpos.add(new OldPosition(players.get(2).x,players.get(2).y));
		input=new InputHandler();
		addKeyListener(input);
		setFocusable(true);
		Timer timer=new Timer(256,e->{
			if(flag==0)
				return;
			for(int j=0;j<max;j++)
			{
			oldpos.get(j).x=players.get(j).x;
			oldpos.get(j).y=players.get(j).y;
			}
			Rectangle appleRect=new Rectangle(apple.x,apple.y,apple.w,apple.h);
			if(input.right)
			{
					(players.get(0)).x+=50;	
			}

			if(input.left)
			{
                                        (players.get(0)).x-=50;
			}
			if(input.up)
                                 {
                                        (players.get(0)).y-=50;
                        }
                        if(input.down)
                                 {
					(players.get(0)).y+=50;    
                        }
			Rectangle headRect=new Rectangle(players.get(0).x,players.get(0).y,players.get(0).w,players.get(0).h);
			if(headRect.intersects(appleRect))
			{
                           apple.x=(int)(Math.random()*getWidth());
			   apple.y=(int)(Math.random()*getHeight());
			   players.add(new Player(players.get(max-1).x,players.get(max-1).y,50,50));
			   oldpos.add(new OldPosition(players.get(max).x,players.get(max).y));
					   max++;
			}
			if(players.get(0).x>getWidth())
				players.get(0).x=0;
			if(players.get(0).x<0)
                                players.get(0).x=getWidth()-50;
			if(players.get(0).y>getHeight())
                                players.get(0).y=0;
			if(players.get(0).y<0)
                                players.get(0).y=getHeight()-50;
			
			for(i=1;i<max;i++)
			{
				(players.get(i)).x=oldpos.get(i-1).x;
                          (players.get(i)).y=oldpos.get(i-1).y;
			Rectangle playRect=new Rectangle(players.get(i).x,players.get(i).y,players.get(i).w,players.get(i).h);
			
			if(headRect.intersects(playRect))
					flag=0;
			}	 
			
			if(i==max)
                                                i=0;
			score+=5*max;
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
		g.setColor(Color.RED);
		g.fillOval(apple.x,apple.y,apple.w,apple.h);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Score: "+score,20,30);
	
	}
}
