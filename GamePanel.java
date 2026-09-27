import javax.swing.JPanel;
import java.awt.Graphics;
public class GamePanel extends JPanel{
	GamePanel()
	{
	}
	protected void paintComponent(Graphics g)
	{
		g.fillRect(100,100,50,50);
	}
}
