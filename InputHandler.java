import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class InputHandler implements KeyListener{
	boolean up,down,left,right;
	public void keyTyped(KeyEvent e)
	{

	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_W)
                {up=true;
                down=false;
                left=false;
                right=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_S)
                {up=false;
                down=true;
                left=false;
                right=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_A)
                {up=false;
                down=false;
                left=true;
                right=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_D)
                {up=false;
                down=false;
                left=false;
                right=true;
                }
	}
	public void keyReleased(KeyEvent e)
	{
	}
}
