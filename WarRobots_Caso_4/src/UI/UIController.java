package UI;

import utils.IObserver;
import utils.Observable;

public class UIController implements IObserver{
	private UIWindow controlledFrame;
	
	public void setWindow(UIWindow pFrame) {
		controlledFrame = pFrame;
		
	}

	@Override
	public void update(Observable pObservable, Object args) {
		// TODO Auto-generated method stub
		
	}
}
