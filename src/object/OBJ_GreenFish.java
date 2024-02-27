package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_GreenFish extends Entity{
	
	GamePanel gp;

	public OBJ_GreenFish(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		
		this.gp = gp;
		value = 4;
		type = type_consumable;
		name = "Green Fish";
		down1 = setup("/objects/GreenFish", gp.tileSize, gp.tileSize);
		price = 10;
		description = "[Green Fish]\nRestores your health\nby " + value + "...";
	}
	public void use(Entity entity) {
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "You ate the " + name + "!\n"
				+ "Your life has been recovered by " + value + ".";
		entity.life += value;
		
		gp.playSE(2);
		if(entity.life > entity.maxLife) {
			entity.life = entity.maxLife;
		}
	}
}


	


