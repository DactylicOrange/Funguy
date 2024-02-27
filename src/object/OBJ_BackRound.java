package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_BackRound extends Entity{
	GamePanel gp;

	public OBJ_BackRound(GamePanel gp) {
		super(gp);
		this.gp = gp;
		type = type_pickupOnly;
		name = "BackRound";
		value = 2;
		down1 = setup("/backround/scanLine03", gp.screenWidth, gp.screenHeight);
		down2 = setup("/backround/scanfilter", gp.screenWidth, gp.screenHeight);
		up1 = setup("/backround/Invcrbck", gp.screenWidth, gp.screenHeight);
		up2 = setup("/backround/ScanLinev2", gp.screenWidth, gp.screenHeight);
		image = setup("/backround/VCRBACKROUND01", gp.screenWidth, gp.screenHeight);
	}
	public void use(Entity entity) {}

}
