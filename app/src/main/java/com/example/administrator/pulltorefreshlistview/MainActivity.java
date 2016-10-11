package com.example.administrator.pulltorefreshlistview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pulltorefreshlistview.view.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PullToRefreshListView mListView;
    private List<Bean> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (PullToRefreshListView) findViewById(R.id.lv_container);

        initData();
        mListView.setAdapter(new MyAdapter());
        //实现回调方法
        mListView.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO: 2016-10-11 实现刷新数据功能
                gerDataFromServer();
                Toast.makeText(getApplicationContext(), "数据加载了", Toast.LENGTH_SHORT).show();

                //加载完隐藏
                mListView.onRefreshComplete(true);
            }

            @Override
            public void onLpadMore() {

                // TODO: 2016-10-11 实现加载跟多功能
                //判断是否有下一页数据
//                if (yes) {
//                    getMoreDataFromServer();
//                } else {
//                    Toast.makeText(getApplicationContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
//                    // 没有数据时也要收起控件
//                    mListView.onRefreshComplete(true);
//                }
            }
        });
    }

    private void initData() {
        datalist = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Bean bean = new Bean("新闻110", "开始的风景都说了骄傲的快捷付款了", "2016-5-20", "154634");
            datalist.add(bean);
        }

    }

    /**
     * 从服务器刷新数据
     */
    private void gerDataFromServer() {
        //利用第三方网络请求数据
//        if (成功) {//请求成功
//
//            //收起下拉刷新控件
//            mListView.onRefreshComplete(true);
//        } else {
//            //请求失败
//            mListView.onRefreshComplete(false);
//        }
    }

    /**
     * 加载下一页数据
     */
    public void getMoreDataFromServer() {
        //利用第三方网络请求数据
//        if (成功) {//请求成功
//
//            //收起下拉刷新控件
//            mListView.onRefreshComplete(true);
//        } else {
//            //请求失败
//            mListView.onRefreshComplete(false);
//        }
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return datalist.size();
        }

        @Override
        public Bean getItem(int position) {
            return datalist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView text = new TextView(getApplicationContext());
            Bean item = getItem(position);
            text.setTextColor(Color.RED);
            text.setText(item.getText());

            return text;
        }
    }

}
