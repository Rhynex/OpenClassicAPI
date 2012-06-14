package ch.spacebase.openclassic.api.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.opennbt.stream.NBTInputStream;
import ch.spacebase.opennbt.stream.NBTOutputStream;
import ch.spacebase.opennbt.tag.*;
import ch.spacebase.opennbt.tag.custom.*;

public class NBTData {

	private CompoundTag data;
	
	public NBTData(String name) {
		this.data = new CompoundTag(name);
	}
	
	public void load(String file) {
		File f = new File(file);
		if(!f.exists()) {
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			
			try {
				f.createNewFile();
			} catch (IOException e) {
				OpenClassic.getLogger().severe("Failed to create new file for NBTData " + this.data.getName() + "!");
				e.printStackTrace();
				return;
			}
			
			return;
		}
		
		NBTInputStream in = null;
		
		try {
			in = new NBTInputStream(new FileInputStream(f));
			CompoundTag tag = (CompoundTag) in.readTag();
			this.data.clear();
			
			for(String name : tag.keySet()) {
				this.data.put(name, tag.get(name));
			}
		} catch (IOException e) {
			OpenClassic.getLogger().severe("Failed to open stream for NBTData " + this.data.getName() + "!");
			e.printStackTrace();
			return;
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void save(String file) {
		File f = new File(file);
		if(!f.exists()) {
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			
			try {
				f.createNewFile();
			} catch (IOException e) {
				OpenClassic.getLogger().severe("Failed to create new file for NBTData " + this.data.getName() + "!");
				e.printStackTrace();
				return;
			}
		}
		
		NBTOutputStream out = null;
		
		try {
			out = new NBTOutputStream(new FileOutputStream(f));
			out.writeTag(this.data);
		} catch (IOException e) {
			OpenClassic.getLogger().severe("Failed to open stream for NBTData " + this.data.getName() + "!");
			e.printStackTrace();
			return;
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Tag put(String name, byte b) {
		return this.data.put(name, new ByteTag(name, b));
	}
	
	public Tag put(String name, byte b[]) {
		return this.data.put(name, new ByteArrayTag(name, b));
	}
	
	public Tag put(CompoundTag compound) {
		return this.data.put(compound.getName(), compound);
	}
	
	public Tag put(String name, double d) {
		return this.data.put(name, new DoubleTag(name, d));
	}
	
	public Tag put(String name, double d[]) {
		return this.data.put(name, new DoubleArrayTag(name, d));
	}
	
	public Tag put(EndTag tag) {
		return this.data.put(tag.getName(), tag);
	}
	
	public Tag put(String name, float f) {
		return this.data.put(name, new FloatTag(name, f));
	}
	
	public Tag put(String name, float f[]) {
		return this.data.put(name, new FloatArrayTag(name, f));
	}
	
	public Tag put(String name, int i) {
		return this.data.put(name, new IntTag(name, i));
	}
	
	public Tag put(String name, int i[]) {
		return this.data.put(name, new IntArrayTag(name, i));
	}
	
	public <T extends Tag> Tag put(String name, Class<T> clazz, List<T> l) {
		return this.data.put(name, new ListTag<T>(name, clazz, l));
	}
	
	public Tag put(String name, long l) {
		return this.data.put(name, new LongTag(name, l));
	}
	
	public Tag put(String name, long l[]) {
		return this.data.put(name, new LongArrayTag(name, l));
	}
	
	public Tag put(String name, short s) {
		return this.data.put(name, new ShortTag(name, s));
	}
	
	public Tag put(String name, short s[]) {
		return this.data.put(name, new ShortArrayTag(name, s));
	}
	
	public Tag put(String name, String s) {
		return this.data.put(name, new StringTag(name, s));
	}
	
	public Tag put(String name, String s[]) {
		return this.data.put(name, new StringArrayTag(name, s));
	}
	
	public Tag put(String name, Object o) {
		return this.data.put(name, new ObjectTag(name, o));
	}
	
	public Tag put(String name, Object o[]) {
		return this.data.put(name, new ObjectArrayTag(name, o));
	}
	
	public Tag get(String name) {
		return this.data.get(name);
	}
	
	public Tag remove(String name) {
		return this.data.remove(name);
	}
	
	public Set<String> keySet() {
		return this.data.keySet();
	}
	
	public Collection<Tag> values() {
		return this.data.values();
	}
	
	public int size() {
		return this.data.size();
	}
	
	public void clear() {
		this.data.clear();
	}
	
}
