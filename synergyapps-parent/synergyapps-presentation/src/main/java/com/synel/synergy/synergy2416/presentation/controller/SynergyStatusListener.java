package com.synel.synergy.synergy2416.presentation.controller;

import com.synel.synergy.synergy2416.presentation.controller.SynergyEventDispatcher.SYNERGY_STATUS;

public interface SynergyStatusListener {
	//This is similar to the Signal portion of QT's signal-slot idiom...
		public void synergyStatusChanged(SYNERGY_STATUS ss);
}
