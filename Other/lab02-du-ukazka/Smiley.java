/**
 * @author Ondřej Šlosárek
 */
public class Smiley {
    private Ellipse eli1;
	private Ellipse eli2;
	private Ellipse eli3;
	private Ellipse eli4;
	private Rectangle rect1;
    
    public Smiley(){
    	eli1 = new Ellipse(50,50,150,150);
    	eli2 = new Ellipse(90,75,20,20,MyColor.RED);
    	eli3 = new Ellipse(140,75,20,20,MyColor.RED);
    	eli4 = new Ellipse(85,130,80,40,MyColor.RED);
    	rect1 = new Rectangle(85,130,80,20,MyColor.BLUE);
    }
    
    public Smiley(int x, int y){
    	eli1 = new Ellipse(x,y,150,150);
    	eli2 = new Ellipse(x+40,y+25,20,20,MyColor.RED);
    	eli3 = new Ellipse(x+90,y+25,20,20,MyColor.RED);
    	eli4 = new Ellipse(x+35,y+80,80,40,MyColor.RED);
    	rect1 = new Rectangle(x+35,y+80,80,20,MyColor.BLUE);
    	
    }
    
    public void moveRight(int x){
   	 	eli1.moveRight(x);
   	 	eli2.moveRight(x);
   	 	eli3.moveRight(x);
   	 	eli4.moveRight(x);
   	 	rect1.moveRight(x);
   	 	eli1.moveRight(0);
	 	eli2.moveRight(0);
	 	eli3.moveRight(0);
	 	eli4.moveRight(0);
	 	rect1.moveRight(0);
    }
    
    public void moveDown(int y){
    	eli1.moveDown(y);
    	eli2.moveDown(y);
      	eli3.moveDown(y);
      	eli4.moveDown(y);
      	rect1.moveDown(y);
      	eli1.moveDown(0);
    	eli2.moveDown(0);
      	eli3.moveDown(0);
      	eli4.moveDown(0);
      	rect1.moveDown(0);
    }
    
    public void setPosition(int x, int y){
   	 	this.eli1.setPosition(x,y);
   	 	this.eli2.setPosition(x+40,y+25);
   	 	this.eli3.setPosition(x+90,y+25);
   	 	this.eli4.setPosition(x+35,y+80);
   	 	this.rect1.setPosition(x+35,y+80);
   	 	eli1.moveDown(0);
   	 	eli2.moveDown(0);
   	 	eli3.moveDown(0);
   	 	eli4.moveDown(0);
   	 	rect1.moveDown(0);
    }
    
    public int getX(){
   	 	return this.eli1.getX();
    }
    
    public int getY(){
   	 	return this.eli1.getY();
    }

}