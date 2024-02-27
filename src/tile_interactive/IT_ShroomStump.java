package tile_interactive;

import entity.Entity;
import main.GamePanel;

public class IT_ShroomStump extends InteractiveTile{

	GamePanel gp;

	public IT_ShroomStump(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		// TODO Auto-generated constructor stub
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		down1 = setup("/tiles_interactive/shroomstump", gp.tileSize, gp.tileSize);
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 0;
		solidArea.height = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}

}
