package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_0101;
import object.OBJ_Axe;
import object.OBJ_Heart;
import object.OBJ_Mana;
import object.OBJ_PoisonSpit;
import object.OBJ_Potion_Red;
import object.OBJ_coin;

public class MON_error extends Entity{
	GamePanel gp;
	public MON_error(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		name = "Error";
		defaultSpeed = 6;
		speed = defaultSpeed;
		maxLife = 10;
		life = maxLife;
		attack = 5;
		defense = 2;
		exp = 2;
		projectile = new OBJ_PoisonSpit(gp);
		
		
		solidArea.x = 1;
		solidArea.y = 1;
		solidArea.width = gp.tileSize * 6;
		solidArea.height = gp.tileSize * 4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		//just using down 1 and 2 for all directions
		up1 = setup("/monster/ErrorEntity 2", gp.tileSize * 6, gp.tileSize * 4);
		up2 = setup("/monster/ErrorEntity 2", gp.tileSize * 6, gp.tileSize * 4);
		down1 = setup("/monster/ErrorEntity 2", gp.tileSize * 6, gp.tileSize * 4);
		down2 = setup("/monster/ErrorEntity 2", gp.tileSize * 6, gp.tileSize * 4);
		left1 = setup("/monster/ErrorEntity 2", gp.tileSize * 6, gp.tileSize * 4);
		left2 = setup("/monster/ErrorEntity 2", gp.tileSize * 6, gp.tileSize * 4);
		right1 = setup("/monster/ErrorEntity 2", gp.tileSize * 6, gp.tileSize * 4);
		right2 = setup("/monster/ErrorEntity 2", gp.tileSize * 6, gp.tileSize * 4);
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
		gp.gameState = gp.dialogueState;


			direction = gp.player.direction;
			
			if(gp.currentMap == 4) {
				gp.eHandler.EnterStructure(0, 23, 25);gp.playMusic(6);
				
			}
		
	}
	public void checkDrop() {
		int i = new Random().nextInt(100)+1;
		//set the monster drop
		if(i < 100) {
			dropItem(new OBJ_0101(gp));
		}

		
		
	
	}
		
	}


