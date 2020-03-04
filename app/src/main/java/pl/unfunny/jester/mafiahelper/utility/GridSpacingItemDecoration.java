package pl.unfunny.jester.mafiahelper.utility;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int freeSpace;

    public GridSpacingItemDecoration(int spanCount, int freeSpace) {
        this.spanCount = spanCount;
        this.freeSpace = freeSpace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column
        int divide = freeSpace / (spanCount + 1);

        outRect.left = divide - column * divide / spanCount;
        outRect.right = (column + 1) * divide / spanCount;
    }
}
