package org.maplibre.reactnative.events;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import android.view.View;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import org.maplibre.android.geometry.LatLng;

import org.maplibre.reactnative.events.constants.EventKeys;
import org.maplibre.reactnative.utils.GeoJSONUtils;

public class MapTouchStartEvent extends AbstractEvent {
    private LatLng mTouchedLatLng;
    private PointF mScreenPoint;

    public MapTouchStartEvent(View view, @NonNull LatLng latLng, @NonNull PointF screenPoint) {
        super(view, "touchstart");
        mTouchedLatLng = latLng;
        mScreenPoint = screenPoint;
    }

    @Override
    public String getKey() {
        return EventKeys.MAP_TOUCH_START;
    }

    @Override
    public WritableMap getPayload() {
        WritableMap properties = new WritableNativeMap();
        properties.putDouble("screenPointX", mScreenPoint.x);
        properties.putDouble("screenPointY", mScreenPoint.y);
        return GeoJSONUtils.toPointFeature(mTouchedLatLng, properties);
    }
}
