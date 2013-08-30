package com.t2.h2h4h;

import java.util.ArrayList;
import java.util.List;

import com.t2.dataouthandler.DataOutHandler;
import com.t2.dataouthandler.DataOutHandlerException;
import com.t2.dataouthandler.DataOutHandlerTags;
import com.t2.dataouthandler.DataOutPacket;


public class H2H4h {
	DataOutHandler sDataOutHandler;
	
	public H2H4h() throws DataOutHandlerException {
		sDataOutHandler = DataOutHandler.getInstance();	
	}
	
	public List<Habit> getHabits() throws DataOutHandlerException {

		ArrayList<Habit> habits = new ArrayList<Habit>();
		
		ArrayList<DataOutPacket> habitsDOP = sDataOutHandler.getPacketList("StructureType in ('" + DataOutHandlerTags.STRUCTURE_TYPE_HABIT + "')");		

		for (DataOutPacket packetDOP : habitsDOP) {
			Habit habit = new Habit(packetDOP);
			habits.add(habit);
		}
		
		return habits;
	}
	

}
