import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import  java.lang.Math;


public class Pattern extends JPanel 
{
	private float PI = 3.14159265359f;
	int accuracy = 10000;
	float posX = 200;
	float posY = 100;
	float minorRadius = 60;
	float majorRadius = 80;
	

	public void drawPattern(Graphics g, int accuracy, float posX, float posY, float minorRadius, float majorRadius)
	{
		for(float i = 0; i < accuracy; i++)
		{
			//float dynamicRadius = (float)((minorRadius + (Math.sin((i * 5) / accuracy * 2.0f * PI) * (majorRadius - minorRadius))) + Math.cos(((i + 40) * 15) / accuracy * 2.0f * PI) * 10);
			//float dynamicRadius = (float)((minorRadius + (Math.sin((i * 5) / accuracy * 2.0f * PI) * (majorRadius - minorRadius))) + Math.cos(((i + 40) * 15) / accuracy * 2.0f * PI) * 3);
			
			Color color = new Color((int) (Math.sin(((i / accuracy))) * 150), (int) (Math.cos((i / accuracy)) * 170),  255);
			g.setColor(color);
			float dynamicRadius = (float)((minorRadius + (Math.sin((i * 3) / accuracy * 2.0f * PI) * (majorRadius - minorRadius))) + 
					Math.cos(((i + 40) * 15) / accuracy * 2.0f * PI) * 7);
			
			float posX2 = (float) (posX + (Math.cos((i / accuracy) * 2.0f * PI)) * dynamicRadius);
			float posY2 = (float) (posY + (Math.sin((i / accuracy) * 2.0f * PI)) * dynamicRadius);
			g.drawLine((int)(posX), (int)posY, (int)posX2, (int)posY2);
		}	
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);	
		drawPattern(g, accuracy, posX, posY, minorRadius, majorRadius);
	}
}
