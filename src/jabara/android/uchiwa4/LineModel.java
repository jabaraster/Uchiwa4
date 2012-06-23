/**
 * 
 */
package jabara.android.uchiwa4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.PointF;

/**
 * @author jabaraster
 */
public class LineModel implements Serializable {
    private static final long  serialVersionUID = -7773418709905920441L;

    private final int          color;
    private final List<PointF> points           = new ArrayList<PointF>();

    /**
     * @param pColor
     * @param pX
     * @param pY
     */
    public LineModel(final int pColor, final float pX, final float pY) {
        this.color = pColor;
        this.points.add(new PointF(pX, pY));
    }

    /**
     * @param pX
     * @param pY
     */
    public void addPoint(final float pX, final float pY) {
        this.points.add(new PointF(pX, pY));
    }

    /**
     * @return the color
     */
    public int getColor() {
        return this.color;
    }

    /**
     * @return
     */
    public int getPointCount() {
        return this.points.size();
    }

    /**
     * @return the points
     */
    public List<PointF> getPoints() {
        return this.points;
    }

    /**
     * @param pIndex
     * @return
     */
    public PointF getPoint(int pIndex) {
        return this.points.get(pIndex);
    }

}
