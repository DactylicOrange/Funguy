package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_BrownFish extends Entity{
	
	GamePanel gp;

	public OBJ_BrownFish(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub

		this.gp = gp;
		value = 2;
		type = type_consumable;
		name = "Brown Fish";
		down1 = setup("/objects/BrownFish", gp.tileSize, gp.tileSize);
		price = 10;
		description = "[Green Fish]\nRestores your mana\nby " + value + "...";
	}
	public void use(Entity entity) {
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "You ate the " + name + "!\n"
				+ "Your mana has been recovered by " + value + "!";
		entity.mana += value;
		
		gp.playSE(2);
		if(entity.mana > entity.maxMana) {
			entity.mana = entity.maxMana;
		}
	}
}
	
	


