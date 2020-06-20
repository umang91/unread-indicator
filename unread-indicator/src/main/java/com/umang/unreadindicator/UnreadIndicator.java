package com.umang.unreadindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Umang Chamaria
 * Date: 19/06/20
 */
public class UnreadIndicator extends View {

  private int color;
  private Path path = new Path();
  private Paint paint = new Paint();

  public UnreadIndicator(Context context) {
    this(context, null);
  }

  public UnreadIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);
    getXmlAttrs(context, attrs);
  }

  public UnreadIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    getXmlAttrs(context, attrs);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawPath(configurePath(path, (float)getWidth()), configurePaint(paint));
  }

  private Paint configurePaint(Paint paint) {
  paint.setColor(color);
  paint.setAntiAlias(true);
  return paint;
  }

  private Path configurePath(Path path, float sideLength){
    path.lineTo(sideLength, 0);
    path.lineTo(sideLength, sideLength);
    path.lineTo(0f, 0f);
    return path;
  }

  private void getXmlAttrs(Context context, AttributeSet attrs) {
    TypedArray a =
        context.getTheme().obtainStyledAttributes(attrs, R.styleable.UnreadIndicator, 0, 0);
    try {
      color =
          a.getInteger(R.styleable.UnreadIndicator_indicatorColor, Color.rgb(0x61, 0x61, 0x61));
    } finally {
      a.recycle();
    }
  }

  public void setColor(int color){
    this.color = color;
  }
}
