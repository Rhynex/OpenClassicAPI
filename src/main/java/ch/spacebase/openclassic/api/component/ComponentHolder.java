package ch.spacebase.openclassic.api.component;

import java.util.List;

public interface ComponentHolder {

	public <T extends Component> T add(Class<T> type);
	
	public <T extends Component> T detach(Class<T> type);
	
	public <T extends Component> T get(Class<T> type);
	
	public <T extends Component> T getExact(Class<T> type);
	
	public boolean has(Class<? extends Component> type);
	
	public boolean hasExact(Class<? extends Component> type);
	
	public List<Component> getComponents();
	
}
