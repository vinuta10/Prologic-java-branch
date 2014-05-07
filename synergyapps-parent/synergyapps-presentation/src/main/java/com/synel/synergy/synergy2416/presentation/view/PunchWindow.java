package com.synel.synergy.synergy2416.presentation.view;

public class PunchWindow {
	private boolean m_punchaccepted = false;
	private String m_badgenum;
	private int m_punchType;
	private long m_timestamp;

	public boolean isM_punchaccepted() {
		return m_punchaccepted;
	}
	public void setM_punchaccepted(boolean m_punchaccepted) {
		this.m_punchaccepted = m_punchaccepted;
	}
	public String getM_badgenum() {
		return m_badgenum;
	}
	public void setM_badgenum(String m_badgenum) {
		this.m_badgenum = m_badgenum;
	}
	public int getM_punchType() {
		return m_punchType;
	}
	public void setM_punchType(int m_punchType) {
		this.m_punchType = m_punchType;
	}
	public long getM_timestamp() {
		return m_timestamp;
	}
	public void setM_timestamp(long m_timestamp) {
		this.m_timestamp = m_timestamp;
	}
}
