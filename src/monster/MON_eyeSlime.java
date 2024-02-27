package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Mana;
import object.OBJ_Potion_Red;
import object.OBJ_Rock;
import object.OBJ_Tear;
import object.OBJ_coin;

		

public class MON_eyeSlime extends Entity{
	GamePanel gp;

	public MON_eyeSlime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Eye Slime";
		defaultSpeed = 2;
		speed = defaultSpeed;
		maxLife = 6;
		life = maxLife;
		attack = 5;
		defense = 0;
		exp = 2;
		projectile = new OBJ_Tear(gp);
		
		
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
		up1 = setup("/monster/eyesocslime_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/eyesocslime_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/eyesocslime_up_1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/eyesocslime_up_2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/eyesocslime_up_1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/eyesocslime_up_2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/eyesocslime_up_1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/eyesocslime_up_2", gp.tileSize, gp.tileSize);
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
		int i = new Random().nextInt(100)+1;
		if(i > 99 && projectile.alive == false && shotAvailableCounter == 60) {
			projectile.set(worldX, worldY, direction, true, this);
			
			for(int ii = 0; ii < gp.projectile[1].length; ii++) {
				if(gp.projectile[gp.currentMap][ii] == null){
			        gp.projectile[gp.currentMap][ii] = projectile;
			        break;
			    }
			}
			shotAvailableCounter = 0;
		}

	}
	public void damageReaction() {
		actionLockCounter = 0;
		if(gp.player.direction == "up") {
			direction = "down";
		}
		else {
			direction = gp.player.direction;
		}
	}
	public void checkDrop() {
		int i = new Random().nextInt(100)+1;
		
		//set the monster drop
		if(i < 40) {
			dropItem(new OBJ_coin(gp));
		}
		if(i >= 40 && i < 92) {
			dropItem(new OBJ_Mana(gp));
		}
		if(i >= 92 && i < 100) {
			dropItem(new OBJ_Potion_Red(gp));
		}
		
	
	}
}
