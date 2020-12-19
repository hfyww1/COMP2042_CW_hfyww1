package p4_group_8_repo;

import javafx.scene.image.ImageView;
import java.util.ArrayList;

/**
* This class is used to set a constant style for the actors in frogger
* @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
* @since   2020-12-18
*/
public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){	//this looks very similar to line 42
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    /**
    * Manage input is removed as it is unused and unnecessary
    * @author  Wan Hanna Monisha binti Wan Nurnizam
    */
    public abstract void act(long now);
    

}
