package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Heart;
import object.OBJ_Mana_Potion;
import object.OBJ_Potion_Red;
import object.OBJ_Speed_Potion;
import object.OBJ_coin;

public class MON_Ghost extends Entity{
	
	GamePanel gp;

	public MON_Ghost(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		name = "Ghost";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 10;
		life = maxLife;
		attack = 5;
		defense = 0;
		exp = 3;
		
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		//just using down 1 and 2 for all directions
		up1 = setup("/monster/ghost_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/ghost_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/ghost_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/ghost_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/ghost_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/ghost_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/ghost_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/ghost_right_2", gp.tileSize, gp.tileSize);
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
	public void damageReaction() {
		actionLockCounter = 0;
		if(gp.player.direction == "right") {
			direction = "left";
		}
		else if(gp.player.direction == "left") {
			direction = "right";
		}
		else {
			direction = gp.player.direction;
		}
	}
	public void checkDrop() {
		
		//random num generator drop
		int i = new Random().nextInt(100)+1;
		
		//set the monster drop
		if(i < 40) {
			dropItem(new OBJ_coin(gp)); //40%
		}
		if(i >= 40 && i < 82) {
			dropItem(new OBJ_Heart(gp)); //42%
		}
		if(i >= 82 && i < 92) {
			dropItem(new OBJ_Potion_Red(gp)); //10%
		}
		if(i >= 92 && i < 98) {
			dropItem(new OBJ_Mana_Potion(gp)); //6%
		}
		//speed potion super rare but in future make it so max speed does not pass 7 or so that it only has a time effetc of 30 sec
		if(i >= 98 && i < 100) {
			dropItem(new OBJ_Speed_Potion(gp)); //2%
		}
		
	}

}

