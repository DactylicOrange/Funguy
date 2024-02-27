package buildings;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperStructure {

	public BufferedImage bimage;
	public String bname;
	public boolean collision = false;
	public int worldX, worldY;
	
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX; 
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		//map data stored in array above
	if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
			
			g2.drawImage(bimage, screenX, screenY, gp.tileSize*4,gp.tileSize*4, null);
	}
  }
}