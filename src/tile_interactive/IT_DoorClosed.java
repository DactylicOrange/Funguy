package tile_interactive;

import entity.Entity;
import main.GamePanel;

public class IT_DoorClosed extends InteractiveTile{

	public IT_DoorClosed(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		// TODO Auto-generated constructor stub
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setup("/tiles_interactive/doorclosed", gp.tileSize, gp.tileSize);
		destructable = false;
		life = 1;
	}
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		
		if(entity.currentKey.type == type_key) {
			isCorrectItem = true;
		}
		return isCorrectItem;
	}
public void playSe() {
		gp.playSE(3);
	}
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = new IT_DoorOpen(gp, worldX/gp.tileSize, worldY/gp.tileSize);
		return tile;
	}
}


