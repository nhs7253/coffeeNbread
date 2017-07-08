package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.EventProductDao;
import com.cnb.dao.StoreEventDao;
import com.cnb.service.StoreEventService;
import com.cnb.vo.EventProduct;
import com.cnb.vo.StoreEvent;

@Service
public class StoreEventServiceImpl implements StoreEventService{

	@Autowired
	private StoreEventDao dao;
	
	@Autowired
	private EventProductDao epdao;
	
	@Override
	public int addStoreEvent(StoreEvent storeEvent,EventProduct eventProduct) {
		int cnt = dao.insertStoreEvent(storeEvent);
		if( epdao.selectEventProductByEventNoANDProductId(eventProduct.getProductId(), storeEvent.getEventNo())== null
				&& eventProduct.getEventNo() == storeEvent.getEventNo()){
			epdao.insertEventProduct(eventProduct);
			return cnt;
		}
		return cnt;
	}

	@Override
	public int modifyStoreEvent(StoreEvent storeEvent,EventProduct eventProductAfter,EventProduct eventProductBefore) {
		int cnt = dao.updateStoreEvent(storeEvent);
		if( (epdao.selectEventProductByEventNoANDProductId(eventProductBefore.getProductId(), storeEvent.getEventNo()))!=null
				&& (epdao.selectEventProductByEventNoANDProductId(eventProductAfter.getProductId(), storeEvent.getEventNo()
				))==null){
		epdao.updateEventProduct(eventProductAfter, eventProductBefore);
		return cnt;
		}
		return cnt;
		
	}

	@Override
	public List<StoreEvent> findStoreEventList(String storeId) {
		
		return dao.selectStoreEventList(storeId);
	}

}
