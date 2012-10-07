package ch.spacebase.openclassic.api.component;

public abstract class Component {

	private ComponentHolder holder;
	
	public boolean attachTo(ComponentHolder holder) {
		if(this.holder != null || !this.canAttach(holder)) return false;
		this.holder = holder;
		this.onAttached();
		return true;
	}
	
	public boolean detach() {
		if(this.holder == null || !this.canDetach()) return false;
		ComponentHolder old = this.holder;
		this.holder = null;
		this.onDetached(old);
		return true;
	}
	
	public ComponentHolder getHolder() {
		return this.holder;
	}
	
	public boolean canAttach(ComponentHolder holder) {
		return true;
	}
	
	public boolean canDetach() {
		return true;
	}
	
	public void onAttached() {
	}
	
	public void onDetached(ComponentHolder holder) {
	}
	
	public boolean canTick() {
		return true;
	}
	
	public void tick(float delta) {
	}
	
}
