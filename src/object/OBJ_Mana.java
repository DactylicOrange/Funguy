package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Mana extends Entity{

	GamePanel gp;
	
	public OBJ_Mana(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = "Mana";
		value = 1;
		down1 = setup("/objects/mana_drop_item", gp.tileSize, gp.tileSize);
		image = setup("/objects/mana", gp.tileSize, gp.tileSize);
		image2 = setup("/objects/mana_blank", gp.tileSize, gp.tileSize);
	}
public void use(Entity entity) {
		
		gp.playSE(2);
		gp.ui.addMessage("Mana +" + value);
		entity.mana += value;
		
		//for some reson putting it in player class did not override the oevr max life/mana condition and set it back to normal
		if(entity.mana > entity.maxMana) {
			entity.mana = entity.maxMana;
		}
		
		
	}

}
