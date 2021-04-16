package gameobjects;

/**
 * Static methods that compare two GameObject which eachother.
 */

public class Collision {
    private static int offset = 8;

    /**
     * This method if one gameobject collides with an another.
     * @param go1
     * @param go2
     * @return true if the gameobject collides with it and false otherwise.
     */

    public static boolean collide(GameObject go1, GameObject go2) {
        return go1.getRectangle().intersects(go2.getRectangle().getBoundsInLocal());
    }

    /**
     * If the player collides with the right-side of an gameobject.
     * @param go1 The block that collide with something.
     * @param go2 The right-side of this block will be checked with go1.
     * @return true if it collides and false otherwise.
     */

    public static boolean rightCollide(GameObject go1, GameObject go2) {
        return go1.getRectangle().intersects(go2.getX()+go2.getWidth()-go2.getWidth()/4, go2.getY()+offset, go2.getWidth()/4, go2.getHeight()-offset);
    }

    /**
     * If the player collides with the left-side of an gameobject.
     * @param go1 The block that collide with something.
     * @param go2 The left-side of this block will be checked with go1.
     * @return true if it collides and false otherwise.
     */

    public static boolean leftCollide(GameObject go1, GameObject go2) {
        return go1.getRectangle().intersects(go2.getX(), go2.getY()+offset, go2.getWidth()/4, go2.getHeight()-offset);
    }

    /**
     * If the player collides with the top-side of an gameobject.
     * @param go1 The block that collide with something.
     * @param go2 The top-side of this block will be checked with go1.
     * @return true if it collides and false otherwise.
     */

    public static boolean topCollide(GameObject go1, GameObject go2) {
        return go1.getRectangle().intersects(go2.getX()+offset, go2.getY(), go2.getWidth()-offset-1, go2.getHeight()/4);
    }

    /**
     * Gives which side the block the gameobject collides with.
     * @param go1 The block that collide with something.
     * @param go2 The unknown side of this block will be checked with go1.
     * @return 1 if it collides with top, 2 with right, 3 with bottom, 4 left and 0 if it does not collide anywhere.
     */

    public static int getCollisionSide(GameObject go1, GameObject go2) {

        if(rightCollide(go1, go2)) return 2;

        if(topCollide(go1, go2)) return 1;

        if(leftCollide(go1, go2)) return 4;
        return 0;
    }



}
