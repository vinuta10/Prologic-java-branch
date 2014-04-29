package com.synel.synergy.synergy2416.persistent;

import java.util.List;

public interface PunchDataDao {
	
	public PunchDataPOJO getPunchDataById(int id);
	
	public int savePunchData(PunchDataPOJO pd);
	
	public List<PunchDataPOJO> getPunchDataList();

}
