import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class House extends JPanel 
{
	private float posX1 = 145;
	private float posY1 = 75;
	private float posX2 = 235;
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
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);	
		drawHouse(g, posX1, posY1, posX2, posY2);
	}
}
