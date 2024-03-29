package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Pengu extends Entity {

	
	public NPC_Pengu(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 0;
		// TODO Auto-generated constructor stub
		getImage();
	}
	
public void getImage() {
	
	
	up1 = setup("/npc/penguswim_1", gp.tileSize, gp.tileSize);
	up2 = setup("/npc/penguswim_2", gp.tileSize, gp.tileSize);
	down1 = setup("/npc/penguswim_1", gp.tileSize, gp.tileSize);
	down2 = setup("/npc/penguswim_2", gp.tileSize, gp.tileSize);
	left1 = setup("/npc/penguswim_1", gp.tileSize, gp.tileSize);
	left2 = setup("/npc/penguswim_2", gp.tileSize, gp.tileSize);
	right1 = setup("/npc/penguswim_1", gp.tileSize, gp.tileSize);
	right2 = setup("/npc/penguswim_2", gp.tileSize, gp.tileSize);
	
	
	
}

public void setAction() {
	
	actionLockCounter ++;
	
	if(actionLockCounter == 120) {
		Random random = new Random();
		int i = random.nextInt(100)+1;//pickup a number 1 to 100
		
		if(i <=50) {
			direction = "up";
		}
		if(i > 50 && i <= 100) {
			direction = "down";
		}
					
		actionLockCounter = 0; 
	}


}
public void speak() {
	super.speak();
	
	}

}
