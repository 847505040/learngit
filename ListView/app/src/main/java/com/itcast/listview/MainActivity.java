package com.itcast.listview;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ListView mListView;
    //商城名称和价格数据集合
    private  String[] titles = {"桌子","苹果","蛋糕","线衣","猕猴桃",
            "围巾"};
    private String[] prices = {"1800块","10块/kg","300元","350"+"元","10元",
            "280元"};
    //图片数据集合
    private  int[] icons = {R.drawable.table,R.drawable.apple,R.drawable.cake,R.drawable.wireclothes,
    R.drawable.kiwifruit,R.drawable.scarf};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv);//初始化LIstview控件
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter((ListAdapter) mAdapter);
    }
    class MyBaseAdapter extends BaseAdapter{
      @Override
        public  int getCount(){
          return titles.length;
      }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
          ViewHolder holder = null;
          if (convertView == null){
              convertView = View.inflate(MainActivity.this,R.layout.list_item,null);
              holder = new ViewHolder();
              holder.title = (TextView) convertView.findViewById(R.id.title);
              holder.price = (TextView) convertView.findViewById(R.id.price);
              holder.iv = (ImageView) convertView.findViewById(R.id.iv);
              convertView.setTag(holder);
          }else{
              holder = (ViewHolder) convertView.getTag();
          }
          holder.title.setText(titles[position]);
          holder.price.setText(prices[position]);
          holder.iv.setBackgroundResource(icons[position]);
            return convertView;
        }
    }
}

class  ViewHolder{
    TextView title,price;
    ImageView iv;
}