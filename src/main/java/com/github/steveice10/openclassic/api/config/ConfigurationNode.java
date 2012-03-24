package com.github.steveice10.openclassic.api.config;

import java.util.ArrayList;
import java.util.List;

import com.github.steveice10.openclassic.api.util.MathHelper;

@SuppressWarnings("unchecked")
public class ConfigurationNode {

	private final String path;
	protected Configuration config;
	private Object value;
	private Object def;

	public ConfigurationNode(String path, Object def) {
		this.path = path;
		this.def = def;
		this.value = def;
	}

	public String getPath() {
		return path;
	}

	public Object getValue() {
		return this.getValue(true);
	}
	
	public Object getValue(boolean useDefIfNeeded) {
		if (value != null) {
			return value;
		}

		if(useDefIfNeeded) this.setValue(def, true);
		return def;
	}

	public void setValue(Object value, boolean toConfig) {
		this.value = value;
		if (this.config != null && toConfig) {
			this.config.addNode(this);
		}
	}

	public void setDefaultValue(Object def) {
		this.def = def;
		
		if (this.value == null) {
			this.value = def;
		}
	}

	public void setConfiguration(Configuration config) {
		config.addNode(this);
	}

	public String getString() {
		return this.getString(null);
	}

	public String getString(String def) {

		if (this.value == null) {
			this.setValue(def, true);
		} else {
			return value.toString();
		}
		return def;
	}

	public int getInteger() {
		return this.getInteger(0);
	}

	public int getInteger(int def) {
		Integer i = MathHelper.castInt(value);
		if (i != null) {
			return i;
		}

		if(this.value == null) {
			this.setValue(def, true);
		}
		return def;
	}

	public double getDouble() {
		return this.getDouble(0);
	}

	public double getDouble(double def) {
		Double d = MathHelper.castDouble(value);
		if (d != null) {
			return d;
		}

		if (this.value == null) {
			this.setValue(def, true);
		}
		return def;
	}
	
	public float getFloat() {
		return this.getFloat(0);
	}

	public float getFloat(float def) {
		Float f = MathHelper.castFloat(value);
		if (f != null) {
			return f;
		}

		if (this.value == null) {
			this.setValue(def, true);
		}
		return def;
	}

	public boolean getBoolean() {
		return this.getBoolean(false);
	}

	public boolean getBoolean(boolean def) {
		Boolean b = MathHelper.castBoolean(value);
		if (b != null) {
			return b;
		}

		if (this.value == null) {
			this.setValue(def, true);
		}
		return def;
	}

	public List<Object> getList() {
		return this.getList(null);
	}

	public List<Object> getList(List<Object> def) {
		if (value != null && value instanceof List) {
			return (List<Object>) value;
		}

		if (this.value == null) {
			this.setValue(def, true);
		}
		return def;
	}

	public List<String> getStringList() {
		return this.getStringList(null);
	}

	public List<String> getStringList(List<String> def) {
		List<Object> raw = this.getList();
		if (raw != null) {
			List<String> list = new ArrayList<String>();
			for (Object obj : raw) {
				list.add(obj.toString());
			}

			return list;
		}

		return def;
	}

	public List<Integer> getIntegerList() {
		return this.getIntegerList(null);
	}

	public List<Integer> getIntegerList(List<Integer> def) {
		List<Object> raw = this.getList();
		if (raw != null) {
			List<Integer> list = new ArrayList<Integer>();
			for (Object o : raw) {
				Integer i = MathHelper.castInt(o);
				if (i != null) {
					list.add(i);
				}
			}

			return list;
		}

		return def;
	}

	public List<Double> getDoubleList() {
		return this.getDoubleList(null);
	}

	public List<Double> getDoubleList(List<Double> def) {
		List<Object> raw = this.getList();
		if (raw != null) {
			List<Double> list = new ArrayList<Double>();
			for (Object o : raw) {
				Double i = MathHelper.castDouble(o);
				if (i != null) {
					list.add(i);
				}
			}

			return list;
		}

		return def;
	}

	public List<Boolean> getBooleanList() {
		return this.getBooleanList(null);
	}

	public List<Boolean> getBooleanList(List<Boolean> def) {
		List<Object> raw = this.getList();
		if (raw != null) {
			List<Boolean> list = new ArrayList<Boolean>();
			for (Object o : raw) {
				Boolean b = MathHelper.castBoolean(o);
				if (b != null) {
					list.add(b);
				}
			}

			return list;
		}

		return def;
	}

}
