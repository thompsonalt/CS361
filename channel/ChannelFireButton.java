package channel;

import race.Racer;

/**
 -- ChronoTimer 1009 --
 Author:  The Joker
 Date:  2/28/2016 - 1:22 AM
 */
public class ChannelFireButton extends Sensor{

	private int name;
	double elapsedTime;

	// need this for test
	public ChannelFireButton(Channel channel, String type, boolean state, int name) {
		super(channel, type, state);
		this.name = name;
	}

	// THIS BUTTON STATE SHOULD ALWAYS BE TRUE!!!

	// use this for regular activities
	public ChannelFireButton(Channel channel) {
		super(channel, "FIRE_BUTTON", true);
		this.name = channel.getName();
	}

	@Override
	public void enable() {
		// TODO Auto-generated method stub
		System.out.println("Error: Channel# " + whichChannelShouldReceiveEvent.getName() +" start/finish button can not be enabled or disabled");

	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		System.out.println("Error: Channel# " + whichChannelShouldReceiveEvent.getName() +" start/finish button can not be enabled or disabled");

	}

	public void trigger(Racer racer) {

		elapsedTime =  (double) (System.nanoTime() - ChronoTimer.pcTime)/ 1000000000.0;

		if(whichChannelShouldReceiveEvent.wasFired()){
			System.out.println("Sort of error: channel # " + whichChannelShouldReceiveEvent.getName() + " was fired from somewhere else");
			System.out.println("Reset channel and then use this button");
		}else{
//			racer.addHistory(ChronoTimer.currentEventType + " racer " + racer.getNumber() + " triggered " + super.getType() + " # " + name + " at " +ChronoTimer.format.format(ChronoTimer.pcTime));
//			super.trigger(super.getType() + " " + name + " at " + ChronoTimer.format.format(ChronoTimer.pcTime));
			racer.addHistory(ChronoTimer.currentEventType + " racer " + racer.getNumber() + " triggered " + super.getType() + " # " + name + " at " + elapsedTime + "\n");
			super.trigger(super.getType() + " " + name + " at " + elapsedTime);

		}



	}



}