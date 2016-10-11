package com.example.hongxingkeji.washbabystaff.ui.Activity;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.farmwork.Base.BaseActivity;
import com.example.hongxingkeji.washbabystaff.ui.MyApplication;
import com.example.hongxingkeji.washbabystaff.ui.View.MyDialog;

public class MapActivity extends BaseActivity {

    public LocationClient mLocationClient;

    public BDLocationListener myListener = new MyLocationListener();

    private BaiduMap mBaiduMap;

    private MapView mapView=null;

    private MyDialog myDialog;

    private LinearLayout mapbottomll;

    private double longi,la;//经纬度

    private TextView start_sao,dismiss_list,call_phone;

    @Override
    public int getContentViewId() {
        return R.layout.activity_map;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        mapView=findViewByIdNoCast(R.id.bmapView);
        mapbottomll=findViewByIdNoCast(R.id.mapbottomll);
        findViewByIdNoCast(R.id.start_sao).setOnClickListener(this);
        findViewByIdNoCast(R.id.dismiss_list).setOnClickListener(this);
        mLocationClient = new LocationClient(MyApplication.getAppContext());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        initLocation();
        mLocationClient.start();


    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.start_sao:
                myDialog=new MyDialog(this,R.style.Dialog,"确定开始扫码?");
                myDialog.show();
            break;
            case R.id.dismiss_list:
                myDialog=new MyDialog(this,R.style.Dialog,"确定取消此订单?");
                myDialog.show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location != null) {
                longi=location.getLatitude();
                la=location.getLongitude();
                mBaiduMap=mapView.getMap();
                // 开启定位图层
                // 开启定位图层
                mBaiduMap.setMyLocationEnabled(true);
// 构造定位数据
                MyLocationData locData = new MyLocationData.Builder()
                        .accuracy(location.getRadius())
                        // 此处设置开发者获取到的方向信息，顺时针0-360
                        .direction(100).latitude(location.getLatitude())
                        .longitude(location.getLongitude()).build();
                Log.e("TAG",location.getLatitude()+"");
// 设置定位数据
                mBaiduMap.setMyLocationData(locData);
// 设置定位图层的配置（定位模式，是否允许方向信息，用户自定义定位图标）
                BitmapDescriptor mCurrentMarker = BitmapDescriptorFactory
                        .fromResource(R.drawable.clock);
                MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, mCurrentMarker);
                mBaiduMap.setMyLocationConfigeration(config);

//                //定义Maker坐标点
//                Log.e("TAG",longi+""+la);
//                LatLng point = new LatLng(la, longi);
//                //构建Marker图标
//                BitmapDescriptor bitmap = BitmapDescriptorFactory
//                        .fromResource(R.drawable.clock);
//                //构建MarkerOption，用于在地图上添加Marker
//                OverlayOptions option = new MarkerOptions()
//                        .position(point)
//                        .icon(bitmap);
//                //在地图上添加Marker，并显示
//                mBaiduMap.addOverlay(option);
            }
        }
    }
}
