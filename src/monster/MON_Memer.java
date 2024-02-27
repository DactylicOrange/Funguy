package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_0101;
import object.OBJ_PoisonSpit;

public class MON_Memer extends Entity{
	
	GamePanel gp;

	public MON_Memer(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		name = "Memer";
		speed = 4;
		maxLife = 10;
		life = maxLife;
		attack = 5;
		defense = 0;
		exp = 2;
		projectile = new OBJ_PoisonSpit(gp);
		
		
		
		solidArea.x = 1;
		solidArea.y = 1;
		solidArea.width = gp.tileSize * 2;
		solidArea.height = gp.tileSize * 2;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		//just using down 1 and 2 for all directions
		up1 = setup("/monster/meme00", gp.tileSize * 2, gp.tileSize * 2);
		up2 = setup("/monster/meme00", gp.tileSize * 2, gp.tileSize * 2);
		down1 = setup("/monster/meme00", gp.tileSize * 2, gp.tileSize * 2);
		down2 = setup("/monster/meme00", gp.tileSize * 2, gp.tileSize * 2);
		left1 = setup("/monster/meme00", gp.tileSize * 2, gp.tileSize * 2);
		left2 = setup("/monster/meme00", gp.tileSize * 2, gp.tileSize * 2);
		right1 = setup("/monster/meme00", gp.tileSize * 2, gp.tileSize * 2);
		right2 = setup("/monster/meme00", gp.tileSize * 2, gp.tileSize * 2);
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
		
		gp.playSE(28);
		actionLockCounter = 0;


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
