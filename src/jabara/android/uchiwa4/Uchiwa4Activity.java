package jabara.android.uchiwa4;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

public class Uchiwa4Activity extends Activity {

    private int color = Color.RED;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.blue).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View pV) {
                Uchiwa4Activity.this.color = Color.BLUE;
            }
        });
        findViewById(R.id.green).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View pV) {
                Uchiwa4Activity.this.color = Color.GREEN;
            }
        });
        findViewById(R.id.red).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View pV) {
                Uchiwa4Activity.this.color = Color.RED;
            }
        });

        findViewById(R.id.clearer).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View pV) {
                getDrawView().clearAllLines();
                getDrawView().invalidate();
            }
        });
    }

    /**
     * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean onTouchEvent(final MotionEvent pEvent) {
        final PointF convertedPoint = getLocationOnView(getDrawView(), pEvent.getX(), pEvent.getY());
        switch (pEvent.getAction()) {
        case MotionEvent.ACTION_DOWN:
            getDrawView().setStartPoint(this.color, convertedPoint.x, convertedPoint.y);
            break;
        case MotionEvent.ACTION_MOVE:
            getDrawView().addPointToCurrentLine(convertedPoint.x, convertedPoint.y);
            getDrawView().invalidate();
            break;
        case MotionEvent.ACTION_UP:
            break;
        default:
            break;
        }
        return true;
    }

    private DrawView getDrawView() {
        return (DrawView) findViewById(R.id.drawView);
    }

    private static PointF getLocationOnView(final View pView, final float pX, final float pY) {
        final int[] viewLocation = new int[2];
        pView.getLocationInWindow(viewLocation);
        return new PointF(pX - viewLocation[0], pY - viewLocation[1]);
    }
}