package com.zs.book.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.zs.book.base.BaseFragment;
import com.zs.book.test.R;
import com.zs.book.xlistview.XListView;


public class NewsTextFragment extends BaseFragment {

	private XListView xlv_news;
	private int newPage = 1;

	@Override
	protected void init() {
		xlv_news = (XListView) layout.findViewById(R.id.xlv_budejie);
		xlv_news.setPullRefreshEnable(true);
		xlv_news.setPullLoadEnable(true);
		setPicToList();
		xlv_news.setXListViewListener(xlv);
	}

	private boolean loadOrRefresh = false;

	private void setPicToList() {
//		ShowDataUtils.getNews(WebDataUtils.getNEWS(newPage),
//				new AsyncCallBack<List<ContentlistNewsBean>>() {
//					@Override
//					public void onSuccess(List<ContentlistNewsBean> t) {
//						System.out.println("-------����������-");
//						if (loadOrRefresh) {
//							newsAdapter.addListAtLast(t);
//						} else {
//							newsAdapter.clearAll();
//							newsAdapter.setList(t);
//						}
//						stopXListView();
//					}
//
//					@Override
//					public void onFailed(String msg) {
//						tooast(msg);
//						stopXListView();
//					}
//				});
	}

	private void getListToView() {
		newPage++;
		setPicToList();
	}

	private XListView.IXListViewListener xlv = new XListView.IXListViewListener() {
		@Override
		public void onRefresh() {
			newPage = 0;
			loadOrRefresh = false;
			getListToView();
		}

		@Override
		public void onLoadMore() {
			loadOrRefresh = true;
			getListToView();
		}

	};
	private void stopXListView() {
		xlv_news.stopRefresh();
		xlv_news.stopLoadMore();
	}


	@Override
	protected int getLayout() {
		return R.layout.fragment_budejie;
	}

}
