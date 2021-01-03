import femto.mode.HiRes16Color;
import femto.Game;
import femto.State;
import femto.input.Button;
import femto.palette.Psygnosia;
import femto.font.TIC80;

class Main extends State {

    // the screenmode we want to draw with
    HiRes16Color screen; 
    
    Wall wall;
    Player player;

    // start the game using Main as the initial state
    // and TIC80 as the menu's font
    public static void main(String[] args){
        Game.run( TIC80.font(), new Main() );
    }
    
    // Avoid allocation in a State's constructor.
    // Allocate on init instead.
    void init(){
        screen = new HiRes16Color(Psygnosia.palette(), TIC80.font());
        wall = new Wall();
        player = new Player();
    }
    
    // Might help in certain situations
    void shutdown(){
        screen = null;
    }
    
    // update is called by femto.Game every frame
    void update(){
        // clear the screen with the first color from the palette
        screen.clear(0);
        
        player.update();
        
        
        
        wall.draw(screen);
        player.draw(screen);
        
        // Update the screen with everything that was drawn
        screen.flush();
    }
}
