/**
 * 
 */
package jabara.android.uchiwa4;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author jabaraster
 */
public class DrawView extends View {

    private final List<LineModel> lines = new ArrayList<LineModel>();

    /**
     * @param pContext
     * @param pAttributes
     */
    public DrawView(final Context pContext, final AttributeSet pAttributes) {
        super(pContext, pAttributes);
    }

    /**
     * @param pX
     * @param pY
     */
    public void addPointToCurrentLine(final float pX, final float pY) {
        getCurrentLine().addPoint(pX, pY);
    }

    /**
     * 
     */
    public void clearAllLines() {
        this.lines.clear();
    }

    /**
     * @param pX
     * @param pY
     */
    public void setStartPoint(final int pColor, final float pX, final float pY) {
        this.lines.add(new LineModel(pColor, pX, pY));
    }

    /**
     * @see android.view.View#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(final Canvas pCanvas) {
        super.onDraw(pCanvas);

        final Paint paint = new Paint();
        // paint.setARGB(255, 255, 0, 0);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);

        if (this.lines.isEmpty()) {
            return;
        }

        for (final LineModel line : this.lines) {
            paint.setColor(line.getColor());
            for (int i = 0; i < line.getPointCount() - 1; i++) {
                final PointF start = line.getPoint(i);
                final PointF end = line.getPoint(i + 1);
                pCanvas.drawLine(start.x, start.y, end.x, end.y, paint);
            }
        }
    }

    private LineModel getCurrentLine() {
        return this.lines.get(this.lines.size() - 1);
    }
}
