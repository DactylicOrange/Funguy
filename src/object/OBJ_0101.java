package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_0101 extends Entity{
	GamePanel gp;

	public OBJ_0101(GamePanel gp) {
		super(gp);
		this.gp = gp;
		value = 5;
		type = type_consumable;
		name = "0101";
		down1 = setup("/objects/0101", gp.tileSize, gp.tileSize);
		description = "[Error er err]\noops...\nDon't hurt 404 ):";
		price = 404;
		
	}
	public void use(Entity entity) {

		entity.life = entity.maxLife;
		entity.mana = entity.maxMana;
		gp.playSE(2);

		
		
		gp.eHandler.EnterStructure(4, 25, 25);gp.playMusic(8);
		
		
		
	}

}
