package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Mana_Potion extends Entity{

	GamePanel gp;
	
	public OBJ_Mana_Potion(GamePanel gp) {
		super(gp);
		this.gp = gp;
		value = 1;
		type = type_consumable;
		name = "Mana Potion";
		down1 = setup("/objects/mana_potion", gp.tileSize, gp.tileSize);
		description = "[Mana Potion]\nGives you max mana!";
		price = 25;
	}
	public void use(Entity entity) {
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "You drink the " + name + "!\n"
				+ "You have full Mana!";
		gp.player.mana = gp.player.maxMana; 		
		gp.playSE(2);
		// TODO Auto-generated constructor stub
	}
	
	


}
