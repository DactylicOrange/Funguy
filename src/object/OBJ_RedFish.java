package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_RedFish extends Entity{
	GamePanel gp;

	public OBJ_RedFish(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		this.gp = gp;
		value = 1;
		type = type_consumable;
		name = "Red Fish";
		down1 = setup("/objects/RedFish", gp.tileSize, gp.tileSize);
		price = 25;
		description = "[Red Fish]\nTemporarily speed up! ";
	}
	public void use(Entity entity) {
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "You ate the " + name + "!\n"
				+ "Your now super fast!";
		entity.speed += value;
		
		gp.playSE(2);
		if(entity.speed > 6) {
			entity.speed = 6;
		}
	}
	
}


