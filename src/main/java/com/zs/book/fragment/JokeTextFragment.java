package com.zs.book.fragment;

import android.content.Intent;

import com.zs.book.base.BaseFragment;
import com.zs.book.R;
import com.zs.book.xlistview.XListView;

public class JokeTextFragment extends BaseFragment {

	private XListView xlv_joke;
	private int newPage = 1;

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
//		ShowDataUtils.getJokePic(WebDataUtils.getJOKE_TEXT(newPage),
//				new AsyncCallBack<List<ContentlistJokeBean>>() {
//					@Override
//					public void onSuccess(List<ContentlistJokeBean> t) {
//						System.out.println("-------����������-");
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
		xlv_joke.stopRefresh();
		xlv_joke.stopLoadMore();
	}


	private void shareApplication(String content) {
		Intent intent = new Intent();
		// intent.ACTION_SEND;
		intent.setAction("android.intent.action.SEND");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, content);
		startActivity(intent);
	}

	@Override
	protected int getLayout() {
		return R.layout.fragment_budejie;
	}

}
