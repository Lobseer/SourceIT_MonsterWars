package impl.service;

import java.awt.*;
import java.util.Random;

/**
 * Class description
 *
 * @author lobseer
 * @version 31.12.2016
 */

public class Vector2Int implements Cloneable{
    public int x;
    public int y;

    public static final Vector2Int ZERO = new Vector2Int(0, 0);
    public static final Vector2Int RIGHT = new Vector2Int(1, 0);
    public static final Vector2Int LEFT = new Vector2Int(-1, 0);
    public static final Vector2Int UP = new Vector2Int(0, 1);
    public static final Vector2Int DOWN = new Vector2Int(0, -1);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2Int() {this(0, 0);}

    public Vector2Int(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Vector2Int(Vector2Int vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public Vector2Int(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public float getLength() {
        return (float)Math.sqrt(x*x + y*y);
    }

    public Vector2Int normalize(){
        float nx = x/getLength();
        float ny = y/getLength();
        if(nx==0 && ny==0) {
            return this;
        } else if(Math.abs(nx) >= Math.abs(ny)*1.5f) {
            x = nx>0?1:-1;
            y = 0;
        } else if(Math.abs(ny) >= Math.abs(nx)*1.5f) {
            y = ny>0?1:-1;
            x = 0;
        } else {
            x = nx>0?1:-1;
            y = ny>0?1:-1;
        }
        return this;
    }

    public void revert() {
        x = -x;
        y = -y;
    }

    public Vector2Int add(Vector2Int vector) {
        if(vector!=null) {
            return new Vector2Int(this.x+vector.x, this.y+vector.y);
        }
        return this;
    }

    public Vector2Int subtract(Vector2Int vector) {
        if(vector!=null) {
            return new Vector2Int(this.x-vector.x, this.y-vector.y);
        }
        return this;
    }

    public Vector2Int multiply(float multiplier) {
        return new Vector2Int(Math.round(this.x * multiplier), Math.round(this.y * multiplier));
    }

    public static Vector2Int getRandomDirection() {
        Random rnd = new Random();
        switch (rnd.nextInt(4)) {
            case 0: return RIGHT;
            case 1: return LEFT;
            case 2: return UP;
            case 3: return DOWN;
            //case 4: return UP.add(RIGHT);
            //case 5: return UP.add(LEFT);
            //case 6: return DOWN.add(RIGHT);
            //case 7: return DOWN.add(LEFT);
            default: return ZERO;
        }
    }

    public static Vector2Int getDirection(Vector2Int from, Vector2Int to) {
        int x, y;
        x = Math.round((float)to.x - from.x);
        y = Math.round((float)to.y - from.y);
        return new Vector2Int(x, y);
    }

    public static int getDistance(Vector2Int from, Vector2Int to) {
        int x, y;
        x = to.x - from.x;
        y = to.y - from.y;
        int range = (int)Math.round(Math.sqrt(x*x + y*y));
        return range;
    }

    public static int getArrayDistance(Vector2Int from, Vector2Int to) {
        int x, y;
        x = Math.abs(to.x - from.x);
        y = Math.abs(to.y - from.y);
        return x > y?x:y;
    }

    @Override
    public Vector2Int clone() {
        return new Vector2Int(x, y);
    }

    @Override
    public String toString() {
        return String.format("Vector2Int[%1s, %2s]",x, y);
    }
}
