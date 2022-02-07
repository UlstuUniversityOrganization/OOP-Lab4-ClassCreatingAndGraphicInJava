import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import  java.lang.Math;


public class MyPanel1 extends JPanel 
{
	private float PI = 3.14159265359f;
	private float posX1 = 150;
	private float posY1 = 75;
	private float posX2 = 250;
	private float posY2 = 175;
	
	public void setHousePos(float posX1, float posY1, float posX2, float posY2) {
		this.posX1 = posX1;
		this.posY1 = posY1;
		
		this.posX2 = posX2;
		this.posY2 = posY2;
	}
	
	public void drawTriangle(Graphics g, float v1X, float v1Y, float v2X, float v2Y, float v3X, float v3Y) {
		
		g.drawLine((int)v1X, (int)v1Y, (int)v2X, (int)v2Y);
		g.drawLine((int)v2X, (int)v2Y, (int)v3X, (int)v3Y);
		g.drawLine((int)v3X, (int)v3Y, (int)v1X, (int)v1Y);
	}
	
	public void drawHouse(Graphics g, float posX1, float posY1, float posX2, float posY2)
	{
		float quadWidth = java.lang.Math.abs(posX2 - posX1);
		float quadHeight =  java.lang.Math.abs(posY2 - posY1);
		float roofSize = quadHeight * 0.5f;
		float corniceSize = quadWidth * 0.2f;

		// House quad
		g.drawRect((int)posX1, (int)posY1, (int)quadWidth, (int)quadHeight);
		
		// Roof
		drawTriangle(g, posX1 - corniceSize, posY1, posX1 + quadWidth * 0.5f, posY1 - roofSize, posX2 + corniceSize, posY1);
		
		// Chimney

		// Left
		g.drawLine((int)(posX1 + quadWidth * 0.75f), (int)(posY1 - quadHeight * 0.33f), (int)(posX1 + quadWidth * 0.75f), 
				(int)(posY1 - quadHeight * 0.7f));
		
		// Up
		g.drawLine((int)(posX1 + quadWidth * 0.75f), (int)(posY1 - quadHeight * 0.7f), (int)(posX1 + quadWidth * 0.85f), 
				(int)(posY1 - quadHeight * 0.7f));
		
		// Right
		g.drawLine((int)(posX1 + quadWidth * 0.85f), (int)(posY1 - quadHeight * 0.25f), (int)(posX1 + quadWidth * 0.85f), 
				(int)(posY1 - quadHeight * 0.7f));
		
		// Window
		float windowPosX = posX1 + quadWidth * 0.1f;
		float windowPosY = posY1 + quadHeight * 0.3f;
		float windowWidth = quadWidth * 0.35f;
		float windowHeight = quadHeight * 0.35f;
		g.drawRect((int)windowPosX, (int)windowPosY, (int)windowWidth, (int)windowHeight);
		
		// Horizontal window line
		g.drawLine((int)windowPosX, (int)(windowPosY + windowHeight * 0.5f), (int)(windowPosX + windowWidth * 0.5f), 
				(int)(windowPosY + windowHeight * 0.5f));
		
		// Vertical window line
		g.drawLine((int)(windowPosX + windowWidth * 0.5f), (int)windowPosY, (int)(windowPosX + windowWidth * 0.5f), 
				(int)(windowPosY + windowHeight));
		
		// Door
		float doorPosX = posX1 + quadWidth * 0.55f;
		float doorPosY = posY1 + quadHeight * 0.4f;
		float doorWidth = quadWidth * 0.35f;
		float doorHeight = quadHeight * 0.6f;
		g.drawRect((int)doorPosX, (int)doorPosY, (int)doorWidth, (int)doorHeight);
		
		// Door handle
		g.drawLine((int)(doorPosX + doorWidth * 0.7f), (int)(doorPosY + doorHeight * 0.55f), (int)(doorPosX + doorWidth * 0.9f), (int)(doorPosY + doorHeight * 0.55f));		
	}
	
	public void drawPattern(Graphics g)
	{
		int accuracy = 10000;
		float posX = 200;
		float posY = 85;
		float minorRadius = 60;
		float majorRadius = 80;

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
		drawHouse(g, posX1, posY1, posX2, posY2);
		drawPattern(g);
	}
}
