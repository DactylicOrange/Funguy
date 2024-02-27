package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Axe extends Entity{

	public OBJ_Axe(GamePanel gp) {
		super(gp);
		
		
		type = type_axe;
		name = "Axe";
		down1 = setup("/objects/axe", gp.tileSize, gp.tileSize);
		attackArea.width = 32;
		attackArea.height = 32;
		attackValue = 2;
		price = 125;
		knockBackPower = 6;
		
		
		description = "[" + name + "]\nWoodCutter's Axe...";
	}
	
  

}
