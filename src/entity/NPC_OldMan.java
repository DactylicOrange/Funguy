package entity;



import java.awt.Rectangle;
import java.util.Random;
import object.OBJ_coin;
import main.GamePanel;



public class NPC_OldMan extends Entity{
	public NPC_OldMan(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		getImage();
		setDialogue();
	}
	public void getImage() {
		
		
		up1 = setup("/npc/wise_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/wise_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/wise_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/wise_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/wise_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/wise_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/wise_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/wise_right_2", gp.tileSize, gp.tileSize);
		
		
		
}
	public void setDialogue() {
		
		
		dialogues[0] = "Another traveler...";
		dialogues[1] = "The forrest gives me the creeps...";
		dialogues[2] = "I wanna grow this beard till\n it touches my toes!!";
		dialogues[3] = "So you are a funguy... \nat least thats what i've heard.";
		dialogues[4] = "On the search for treasure? \nGood luck!";
		dialogues[5] = "Today is a gift. \nThat is why it is called the present.";
		dialogues[6] = "I used to be a great socerer... \nNow im just a decrepit old fart.";
		dialogues[7] = "My advice: collect coins and powerups. \nThey are hidden throughout the map!";
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
		
		//can get rid of below only temperary (messy code)
		if(gp.mutterCount == 0) {
		gp.playSE(11);
		gp.mutterCount++;
		}
		else if(gp.mutterCount == 1) {
			gp.playSE(12);
			gp.mutterCount++;
		}
		else if(gp.mutterCount == 2) {
			gp.playSE(14);
			gp.mutterCount = 0;
		}
		
		//TO HERE
		
		//this character specific stuff
		
		}
	}
	

		
	
