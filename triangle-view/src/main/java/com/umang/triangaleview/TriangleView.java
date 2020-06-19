package com.umang.triangaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/**
 * @author Umang Chamaria
 * Date: 19/06/20
 */
public class TriangleView extends View {

  private int color;
  private Path path = new Path();
  private Paint paint = new Paint();

  public TriangleView(Context context) {
    this(context, null);
  }

  public TriangleView(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
    getXmlAttrs(context, attrs);
  }

  public TriangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        context.getTheme().obtainStyledAttributes(attrs, R.styleable.TriangleView, 0, 0);
    try {
      color =
          a.getInteger(R.styleable.TriangleView_triangleColor, Color.rgb(0x61, 0x61, 0x61));
    } finally {
      a.recycle();
    }
  }

  public void setColor(int color){
    this.color = color;
  }
}
