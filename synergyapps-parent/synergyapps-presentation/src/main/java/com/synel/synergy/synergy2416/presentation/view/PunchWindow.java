package com.synel.synergy.synergy2416.presentation.view;

public class PunchWindow {
	private boolean m_allowedToPunch = false;
	private boolean m_punchkeypressed = false;
	private String m_badgenum;
	private int m_punchType;
	private long m_timestamp;

	public boolean isM_allowedToPunch() {
		return m_allowedToPunch;
	}
	public void setM_allowedToPunch(boolean allowedToPunch) {
		this.m_allowedToPunch = allowedToPunch;
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
	public boolean isM_punchkeypressed() {
		return m_punchkeypressed;
	}
	public void setM_punchkeypressed(boolean m_punchkeypressed) {
		this.m_punchkeypressed = m_punchkeypressed;
	}
}
