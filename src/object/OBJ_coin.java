package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_coin extends Entity{

 GamePanel gp;
	
	public OBJ_coin(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = "coin";
		value = 1;
		down1 = setup("/objects/funToken", gp.tileSize, gp.tileSize);
	}
	public void use(Entity entity) {
		
		gp.playSE(1);
		gp.ui.addMessage("$FUN +" + value);
		gp.player.coin += value;

		}
	
}
