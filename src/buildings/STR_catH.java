package buildings;

import javax.imageio.ImageIO;

import java.io.IOException;

public class STR_catH extends SuperStructure{
	
	public STR_catH() {
		bname = "CatH";
		
		try {
			bimage = ImageIO.read(getClass().getResourceAsStream("/building/catH.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
				
			
	}

}
