package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;
import object.OBJ_0101;
import object.OBJ_BrownFish;
import object.OBJ_GreenFish;
import object.OBJ_Heart;
import object.OBJ_Mana_Potion;
import object.OBJ_Potion_Red;
import object.OBJ_RedFish;
import object.OBJ_Speed_Potion;
import object.OBJ_coin;



public class NPC_fisherman extends Entity{
	public NPC_fisherman(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		
		direction = "right";
		speed = 0;
		
		getImage();
		setDialogue();
		setItems();
		
	}
	public void getImage() {
		
		
		up1 = setup("/npc/fisherman1", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/fisherman1", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/fisherman1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/fisherman1", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/fisherman2", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/fisherman2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/fisherman2", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/fisherman2", gp.tileSize, gp.tileSize);
		
		
		
		
}
	public void setDialogue() {

			
			dialogues[0] = "Lets see what I got ya!";
		
			dialogues[1] = "Owwwwahh come check me stock!";

			dialogues[2] = "Maybe a classic Brown Fish...\nIt gives ya the pep in the step!";
		
			dialogues[3] = "Here fishy fishy...\nHere fishy fishy...";
		
			dialogues[4] = "There was a time when I caught a wierd anomaly...\nAnd nobody believed me.";
			
		

//				dialogues[0] = "Lets see what I got ya!";
//				dialogues[1] = "Owwwwahh I gotta Green one!";
//				
//
//				dialogues[2] = "I gotta classic Brown Fish...\n Tastes Good!";
//				
//
//				dialogues[3] = "What the...";
				
				
	}
public void setItems() {
	inventory.clear();
	
	if(gp.fishCount == 0) {
		
		
	}
		
	else if(gp.fishCount == 1) {
		inventory.add(new OBJ_GreenFish(gp));
		
	}
	else if(gp.fishCount == 2) {
		inventory.add(new OBJ_BrownFish(gp));
		
	}
	else if(gp.fishCount == 3) {
		inventory.add(new OBJ_RedFish(gp));
		
	}

	else if(gp.fishCount == 4) {
		inventory.add(new OBJ_0101(gp));
		
	}
	
	
	
	

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
		//gp.playSE(11);
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
		gp.playSE(12);	
		FishRNG();
		
			
//			if(gp.mutterCount == 0) {
//				gp.playSE(12);
//				
//				gp.mutterCount++;
//				}
//				else if(gp.mutterCount == 1) {
//					gp.playSE(16);
//					gp.mutterCount++;
//				}
//				else if(gp.mutterCount == 2) {
//					gp.playSE(14);
//					gp.mutterCount = 0;
//				}
//				
	}
		
public void FishRNG() {
	
	gp.fishCount = 0;
	//random num generator 
			int i = new Random().nextInt(100)+1;
			
			//set the fish catch (whichfish)
			if(i < 20) {
				gp.fishCount = 2; //20%
			}
			if(i >= 20 && i < 46) {
				gp.fishCount = 1; //26%
			}
			if(i >= 46 && i < 72) {
				gp.fishCount = 2; //26%
			}
			if(i >= 76 && i < 94) {
				gp.fishCount = 3; //18%
			}
			if(i >= 94 && i < 100) {
				gp.fishCount = 4; //6%
			}
			
			setItems();			
}

		
		//this character specific stuff
		
}
	


