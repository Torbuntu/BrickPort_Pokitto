import femto.mode.HiRes16Color;
import femto.input.Button;

class Player {
    Paddle paddle;
    int x, y;
    
    Player(){
        paddle = new Paddle();
        reset();
    }
    
    void update(){
        if(Button.Left.isPressed()){
            if(x > 1) x-=2;
        }
        
        if(Button.Right.isPressed()){
            if(x < 218-paddle.width())x+=2;
        }
    }
    
    void draw(HiRes16Color screen){
        paddle.draw(screen, x, y);
    }
    
    // Simple bounding box collision method
    boolean collides(float x2, float y2, float w2, float h2){
        return (x < x2 + w2 && x + paddle.width() > x2 && y < y2 + h2 && y + paddle.height() > y2);
    }
    
    void reset(){
        // Center on screen
        x = 110-paddle.width()/2;
        // Height less 10
        y = 166; 
    }
}