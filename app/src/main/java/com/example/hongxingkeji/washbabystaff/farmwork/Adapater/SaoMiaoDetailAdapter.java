package com.example.hongxingkeji.washbabystaff.farmwork.Adapater;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hongxingkeji.washbabystaff.R;
import com.example.hongxingkeji.washbabystaff.ui.Activity.WriteBzActivity;
import com.example.hongxingkeji.washbabystaff.ui.Bean.TestBean.SaoMiaoDetailBean;
import com.example.hongxingkeji.washbabystaff.ui.View.ChangePricePop;
import com.example.hongxingkeji.washbabystaff.ui.View.MyDialog;
import com.uuzuche.lib_zxing.activity.CaptureActivity;

import java.util.List;

/**
 * 扫描界面列表适配器
 * Created by Administrator on 2016/9/27.
 */
public class SaoMiaoDetailAdapter extends BaseAdapter implements View.OnClickListener,MyDialog.DeleteItem,ChangePricePop.GetPrice{
    private Activity context;

    private List<String> imgUri;

    private WriteBzActivity writeBzActivity;

    private SMDetailReAdapter smDetailReAdapter;

    private String beizhu;

    private Datachange datachange;

    public void setDatachange(Datachange datachange) {
        this.datachange = datachange;
    }

    private ChangePricePop pop;

    private int yisao,sum,sumprice;

    private int position;

    private boolean b=false;

    public void setBeizhu(String beizhu,int position) {
        this.beizhu = beizhu;
        this.position=position;
    }
    public void setImgUri(List<String> imgUri,int position) {
        this.imgUri = imgUri;
        this.position=position;
    }

    private List<SaoMiaoDetailBean> strings;

    public SaoMiaoDetailAdapter(Activity context) {
        this.context=context;
    }

    public void setStrings(List<SaoMiaoDetailBean> strings) {
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings==null?0:strings.size();
    }

    @Override
    public Object getItem(int i) {
        return strings==null?null:strings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null) {
            view=View.inflate(context, R.layout.item_saomiaolist,null);
            viewHolder=new ViewHolder();
            viewHolder.clothescode= (TextView) view.findViewById(R.id.weisaomiao);
            viewHolder.clothestype= (TextView) view.findViewById(R.id.clothertype);
            viewHolder.clothesprice= (TextView) view.findViewById(R.id.clotherprice);
            viewHolder.beizhu= (TextView) view.findViewById(R.id.beizhumsg);
            viewHolder.recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context,4,GridLayoutManager.VERTICAL,false);
            viewHolder.recyclerView.setLayoutManager(layoutManager);
            viewHolder.an1= (TextView) view.findViewById(R.id.writebz);//添加备注
            viewHolder.an2= (TextView) view.findViewById(R.id.saomiao);//扫描按钮
            viewHolder.an3= (TextView) view.findViewById(R.id.changeprice);//修改价格
            viewHolder.an4= (TextView) view.findViewById(R.id.delete);//删除
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
            }
         pop=new ChangePricePop(context);
        viewHolder.clothescode.setText(strings.get(i).code);
        //点击添加备注信息
            viewHolder.an1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,WriteBzActivity.class);
                    context.startActivityForResult(intent,i);
                }
            }
            );
        if(beizhu!=null&&i==position){
            strings.get(i).beizhu=beizhu;
        }
        if(imgUri!=null&&i==position){
            strings.get(i).imgUri=imgUri;
        }
        smDetailReAdapter=new SMDetailReAdapter(context,strings.get(i).imgUri);
        viewHolder.recyclerView.setAdapter(smDetailReAdapter);
        smDetailReAdapter.notifyDataSetChanged();
        viewHolder.beizhu.setText(strings.get(i).beizhu);

        notifyDataSetChanged();
        //扫描
            viewHolder.an2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CaptureActivity.class);
                    context.startActivityForResult(intent, 123);
                }
            });
        //改价
        viewHolder.an3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"dian",Toast.LENGTH_SHORT).show();
                pop.ShowPop(context,i);
                pop.setGetPrice(new ChangePricePop.GetPrice() {
                    @Override
                    public void getprice(String a,int x) {
                        Log.e("TAG",i+"   "+x);
                        if(a!=null&&i==x){
                            strings.get(x).price="￥"+a;
                            notifyDataSetChanged();
                        }
                    }
                });            }
        });

        viewHolder.clothesprice.setText(strings.get(i).price);
        //删除衣物操作
            viewHolder.an4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyDialog myDialog=new MyDialog(context,i,"确定删除此衣物?");
                    myDialog.show();
                   myDialog.setDeleteitem(new MyDialog.DeleteItem() {
                       @Override
                       public void delete(int x) {
                           strings.remove(x);
                           notifyDataSetChanged();
                       }
                   });
                }
            });
                    sum=this.getCount();

        return view;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void delete(int i) {

    }

    @Override
    public void getprice(String a,int x) {

    }

    public class ViewHolder{
        public TextView clothescode;
        public TextView clothestype;
        public TextView clothesprice;
        public TextView beizhu;
        public RecyclerView recyclerView;
        public TextView an1,an2,an3,an4;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        yisao=0;
        sum=0;
        sumprice=0;
        sum=strings.size();
        for (int i = 0; i <strings.size() ; i++) {
            if(strings.get(i).code!="未扫描"){
                yisao++;
                sumprice+=Integer.parseInt(strings.get(i).price.substring(1,strings.get(i).price.length()));
            }
        }
        datachange.footSum(sum,yisao,sumprice);
    }
    //回调数据给footView计算衣物的总数和价格
    public interface Datachange{
        void footSum(int sum,int yisao,int sumprice);
    }
}
