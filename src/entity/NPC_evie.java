package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_evie extends Entity{
	public NPC_evie(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();
	}
	public void getImage() {
		
		
		up1 = setup("/npc/evie_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/evie_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/evie_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/evie_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/evie_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/evie_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/evie_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/evie_right_2", gp.tileSize, gp.tileSize);
		
		
		
}
	public void setDialogue() {
		
		
		dialogues[0] = "Hi im EVIE!"+ "";
		dialogues[1] = "My favorite color is purple!";
		dialogues[1] = "Woody is so hot";

	}
	
	public void setAction() {
		
		actionLockCounter ++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100)+1;//pickup a number 1 to 100
			
			if(i <=25) {
				direction = "up";
			}
			if(i > 25 && i <= 50) {
				direction = "down";
			}
			if(i > 50 && i <=75) {
				direction = "left";
			}
			if(i > 75 && i <=100) {
				direction = "right";
			}
						
			actionLockCounter = 0; 
		}


	}
	public void speak() {
		super.speak();
		gp.playSE(3);
		
		}
	}
	


