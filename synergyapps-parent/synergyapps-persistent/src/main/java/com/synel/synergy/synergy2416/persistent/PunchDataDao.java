package com.synel.synergy.synergy2416.persistent;

import java.util.List;

import com.xacttime.PunchData;

public interface PunchDataDao {
	
	public PunchData getPunchDataById(int id);
	
	public int savePunchData(PunchData pd);
	
	public List<PunchData> getPunchDataList();

}
