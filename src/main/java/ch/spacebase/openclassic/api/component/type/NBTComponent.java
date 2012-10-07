package ch.spacebase.openclassic.api.component.type;

import ch.spacebase.openclassic.api.component.Component;
import ch.spacebase.openclassic.api.data.NBTData;

public class NBTComponent extends Component {

	private NBTData data;
	
	@Override
	public boolean canDetach() {
		return false;
	}
	
	@Override
	public boolean canTick() {
		return false;
	}
	
	public void load(String name, String file) {
		this.data = new NBTData(name);
		this.data.load(file);
	}
	
	public NBTData getData() {
		return this.data;
	}
	
}
