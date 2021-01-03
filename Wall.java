import femto.mode.HiRes16Color;

class Wall {
    // wall dimentions: 32x32
    Background background = new Background();
    
    void draw(HiRes16Color screen){
        for(int x = 0; x < 220; x+=32){
            for(int y = 0; y < 176; y+=32){
                background.draw(screen, x, y);
            }
        }
    }
}