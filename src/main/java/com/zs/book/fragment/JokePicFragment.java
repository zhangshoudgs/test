package com.zs.book.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zs.book.base.BaseFragment;
import com.zs.book.test.R;
import com.zs.book.xlistview.XListView;

import java.util.List;

public class JokePicFragment extends BaseFragment {

	private int newPage = 1;
	private XListView xlv_joke;

	@Override
	protected void init() {
		xlv_joke = (XListView) layout.findViewById(R.id.xlv_budejie);
		xlv_joke.setPullRefreshEnable(true);
		xlv_joke.setPullLoadEnable(true);
		setPicToList();
		xlv_joke.setXListViewListener(xlv);
	}
	private boolean loadOrRefresh = false;
	private void setPicToList() {
//		ShowDataUtils.getJokePic(WebDataUtils.getJOKE_PIC(newPage),
//				new AsyncCallBack<List<ContentlistJokeBean>>() {
//					@Override
//					public void onSuccess(List<ContentlistJokeBean> t) {
//						if (loadOrRefresh) {
//							jokeAdapter.addListAtLast(t);
//						} else {
//							jokeAdapter.addList(t);
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
	}


	@Override
	protected int getLayout() {
		return R.layout.fragment_budejie;
	}

}
