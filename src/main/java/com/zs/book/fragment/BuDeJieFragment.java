package com.zs.book.fragment;

import com.zs.book.base.BaseFragment;
import com.zs.book.R;
import com.zs.book.xlistview.XListView;


public class BuDeJieFragment extends BaseFragment {

	private XListView xlv_budejie;

	@Override
	protected void init() {
		xlv_budejie = (XListView) layout.findViewById(R.id.xlv_budejie);

		xlv_budejie.setPullRefreshEnable(true);
		xlv_budejie.setPullLoadEnable(true);
		setPicToList();
		xlv_budejie.setXListViewListener(xlv);
	}

	private boolean loadOrRefresh = false;

	private void setPicToList() {
//		ShowDataUtils.getBudejie(WebDataUtils.getBUDEJIE(newPage),
//				new AsyncCallBack<List<ContentlistBuDeJieBean>>() {
//					@Override
//					public void onSuccess(List<ContentlistBuDeJieBean> t) {
//						if (loadOrRefresh) {
//							budejieAdapter.addListAtLast(t);
//						} else {
//							budejieAdapter.addList(t);
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
		xlv_budejie.stopRefresh();
		xlv_budejie.stopLoadMore();
	}


	@Override
	protected int getLayout() {
		return R.layout.fragment_budejie;
	}

}
