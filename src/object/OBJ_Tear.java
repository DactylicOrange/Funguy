package object;

import java.awt.Color;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Tear extends Projectile{
	
	GamePanel gp;


	public OBJ_Tear(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Tear";
		speed = 7;
		maxLife = 80;
		life = maxLife;
		attack = 2;
		useCost = 1;
		alive = false;
		getImage();
		// TODO Auto-generated constructor stub
	}
	public void getImage(){
		up1 = setup("/projectile/tear_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/projectile/tear_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/projectile/tear_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/projectile/tear_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/projectile/tear_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/projectile/tear_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/projectile/tear_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/projectile/tear_right_2", gp.tileSize, gp.tileSize);
		
		//been working below but can be changed
	//	solidArea.x = 10;
	//	solidArea.y = 32;
	//	solidArea.width = 3;
	//	solidArea.height = 3;
	//	solidAreaDefaultX = solidArea.x;
	//	solidAreaDefaultY = solidArea.y;
	}
	public boolean haveResource(Entity user) {
		boolean haveResource = false;
		if(user.ammo >= useCost) {
			haveResource = true;
		}
		return haveResource;
	}
	public void subtractResource(Entity user) {
		user.ammo -= useCost;
	}
	public Color getParticleColor() {
		Color color = new Color (77, 213, 240);
		return color;
	}
	public int getParticleSize() {
		int size = 7;
		return size;
	}
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}
 

}