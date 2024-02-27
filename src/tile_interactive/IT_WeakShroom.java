package tile_interactive;

import java.awt.Color;

import entity.Entity;
import main.GamePanel;

public class IT_WeakShroom extends InteractiveTile{
	
	GamePanel gp;

	public IT_WeakShroom(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		// TODO Auto-generated constructor stub
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setup("/tiles_interactive/Weakmushroom", gp.tileSize, gp.tileSize);
		destructable = true;
		life = 3;
	}
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		
		if(entity.currentWeapon.type == type_axe) {
			isCorrectItem = true;
		}
		return isCorrectItem;
	}
public void playSe() {
		gp.playSE(18);
	}
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = new IT_ShroomStump(gp, worldX/gp.tileSize, worldY/gp.tileSize);
		return tile;
	}
	public Color getParticleColor() {
		Color color = new Color (124, 125, 103);
		return color;
	}
	public int getParticleSize() {
		int size = 6;
		return size;
	}
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}
	

}
