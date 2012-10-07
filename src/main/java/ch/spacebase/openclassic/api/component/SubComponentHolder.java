package ch.spacebase.openclassic.api.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubComponentHolder extends Component implements ComponentHolder {

	private Map<Class<? extends Component>, Component> components = new HashMap<Class<? extends Component>, Component>();
	
	@Override
	public void tick(float delta) {
		for(Component component : this.components.values()) {
			if(component.canTick()) {
				component.tick(delta);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Component> T add(Class<T> type) {
		if(type == null) return null;
		if(this.components.containsKey(type)) {
			return (T) this.components.get(type);
		}
		
		T component = null;
		try {
			component = type.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		if(component != null && component.attachTo(this)) {
			this.components.put(type, component);
			component.onAttached();
		}
		
		return component;
	}
	
	public <T extends Component> T detach(Class<T> type) {
		T component = this.get(type);
		if(component != null && component.detach()) {
			this.components.remove(type);
		}
		
		return component;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Component> T get(Class<T> type) {
		T component = this.getExact(type);
		if(component == null && type != null) {
			for (Component c : this.getComponents()) {
				if (type.isAssignableFrom(c.getClass())) {
					component = (T) c;
				}
			}
		}
		
		return component;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Component> T getExact(Class<T> type) {
		return type != null ? (T) this.components.get(type) : null;
	}
	
	public boolean has(Class<? extends Component> type) {
		return this.get(type) != null;
	}
	
	public boolean hasExact(Class<? extends Component> type) {
		return this.getExact(type) != null;
	}
	
	public List<Component> getComponents() {
		return Collections.unmodifiableList(new ArrayList<Component>(this.components.values()));
	}
	
}
