package com.mygdx.game;

public class Select {
	GameScreen scrn;
	KidMovement data;
	float xc,yc;
	boolean scrnOne,scrnTwo,teddy,helpOne = false;
	float r,g,b = 0;
	float p,t,c = 1;
	
	public void create(){
		data = new KidMovement();
		
		xc = 100;
		yc = 100;

		scrnOne = true;
		}
	
	//Function checks if character can interact with their enviornment based on their x,ty position when select key is pressed.
	public void sel(float xc, float yc, boolean swtch){
		
		if(scrnOne == true){
			if(swtch == true){
				//if interaction is valid, boolean changes which could either be game screen change or an interaction.
				if(xc>=150 && xc<=250 && yc>=150 && yc<=250){
					scrnTwo = true;
					scrnOne = false;
					p = 22/255f;
					t = 150/255f;
					c = 33/255f;
					r = 200/255f;
					g = 25/255f;
					b = 100/255f;
				}
			}
			else{
				if(xc>=300 && xc<=350 && yc>=150 && yc<=250){
					scrnTwo = true;
					scrnOne = false;
					p = 22/255f;
					t = 150/255f;
					c = 33/255f;
					r = 200/255f;
					g = 25/255f;
					b = 100/255f;
				}
			}
		}

	}
	

}
