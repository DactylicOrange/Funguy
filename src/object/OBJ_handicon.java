package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_handicon extends Entity{
	GamePanel gp;

	public OBJ_handicon(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		
		this.gp = gp;
		type = type_pickupOnly;
		name = "HandIcon";
		value = 2;
		down1 = setup("/icons/handimage", gp.tileSize-6, gp.tileSize-6);
		image = setup("/icons/handimage", gp.tileSize-6, gp.tileSize-6);
	}

}
