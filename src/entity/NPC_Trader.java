package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;
import object.OBJ_0101;
import object.OBJ_Axe;
import object.OBJ_Key;
import object.OBJ_Mana_Potion;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import object.OBJ_Speed_Potion;
import object.OBJ_Sword_Normal;

public class NPC_Trader extends Entity{

	public NPC_Trader(GamePanel gp) {
		super(gp);
		
		
		direction = "down";
		speed = 0;
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		getImage();
		setDialogue();
		setItems();
	}
public void getImage() {
		
		
//		up1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
//		up2 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
//		down1 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
//		down2 = setup("/npc/merchant_down_4", gp.tileSize, gp.tileSize);
//		left1 = setup("/npc/merchant_down_5", gp.tileSize, gp.tileSize);
//		left2 = setup("/npc/merchant_down_5", gp.tileSize, gp.tileSize);
//		right1 = setup("/npc/merchant_down_5", gp.tileSize, gp.tileSize);
//		right2 = setup("/npc/merchant_down_5", gp.tileSize, gp.tileSize);
	up1 = setup("/npc/trader_down_2", gp.tileSize, gp.tileSize);
	up2 = setup("/npc/trader_down_2", gp.tileSize, gp.tileSize);
	down1 = setup("/npc/trader_down_2", gp.tileSize, gp.tileSize);
	down2 = setup("/npc/trader_down_2", gp.tileSize, gp.tileSize);
	left1 = setup("/npc/trader_down_1", gp.tileSize, gp.tileSize);
	left2 = setup("/npc/trader_down_1", gp.tileSize, gp.tileSize);
	right1 = setup("/npc/trader_down_1", gp.tileSize, gp.tileSize);
	right2 = setup("/npc/trader_down_1", gp.tileSize, gp.tileSize);
		
		
		
}
	public void setDialogue() {
		
		
		dialogues[0] = "*Cough* ... What can I do for ya? \n Would you like to trade or sumthin'?\n I have some useful items n' nicknacks yanno!";

	}
	public void setItems() {
		
		inventory.add(new OBJ_Potion_Red(gp));
		inventory.add(new OBJ_Mana_Potion(gp));
		inventory.add(new OBJ_Speed_Potion(gp));
		inventory.add(new OBJ_Axe(gp));
		inventory.add(new OBJ_Shield_Blue(gp));
		inventory.add(new OBJ_Key(gp));
		inventory.add(new OBJ_Sword_Normal(gp));
		inventory.add(new OBJ_0101(gp));
		
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
	gp.gameState = gp.tradeState;
	gp.ui.npc = this;
	gp.playSE(12);
}


	
}
