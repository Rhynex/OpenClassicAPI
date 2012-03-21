package me.steveice10.openclassic.api.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import me.steveice10.openclassic.api.MathHelper;
import me.steveice10.openclassic.api.OpenClassic;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

@SuppressWarnings("unchecked")
public class Configuration {

	protected Map<String, Object> data;
	protected Set<ConfigurationNode> nodes;
	
	private File configFile;
	private Yaml yaml;

	public Configuration(File file) {
		this.data = new HashMap<String, Object>();
		this.nodes = new HashSet<ConfigurationNode>();
		this.configFile = file;
		
		DumperOptions options = new DumperOptions();

		options.setIndent(4);
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

		this.yaml = new Yaml(new SafeConstructor(), new EmptyNullRepresenter(), options);
	}

	public void load() {
		try {
			if (!this.configFile.exists()) {
				if(this.configFile.getParentFile() != null) this.configFile.getParentFile().mkdirs();
				this.configFile.createNewFile();
			}

			FileInputStream in = new FileInputStream(configFile);
			this.data = (Map<String, Object>) yaml.load(in);
			
			if(this.data == null) this.data = new HashMap<String, Object>();
		} catch (IOException e) {
			OpenClassic.getLogger().severe("Failed to load config file " + this.configFile.getName() + "!");
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			if (!this.configFile.exists()) {
				if(this.configFile.getParentFile() != null) this.configFile.getParentFile().mkdirs();
				this.configFile.createNewFile();
			}

			FileOutputStream out = new FileOutputStream(configFile);
			OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");

			for (ConfigurationNode node : nodes) {
				node.setConfiguration(this);
			}
			
			this.yaml.dump(data, writer);
		} catch (IOException e) {
			OpenClassic.getLogger().severe("Failed to save config file " + this.configFile.getName() + "!");
			e.printStackTrace();
		}
	}

	public Object getValue(String path) {
		if(path.equals("")) return new HashMap<String, Object>(this.data);
		
		if (!path.contains(".")) {
			Object value = data.get(path);
			return value;
		}

		String[] parts = path.split("\\.");
		Map<String, Object> node = data;

		for (int index = 0; index < parts.length; index++) {
			Object obj = node.get(parts[index]);

			if (obj == null) {
				return null;
			}

			if (index == parts.length - 1) {
				return obj;
			}

			try {
				node = (Map<String, Object>) obj;
			} catch (ClassCastException e) {
				return null;
			}
		}

		return null;
	}

	public void setValue(String path, Object value) {
		if (!path.contains(".")) {
			data.put(path, value);
			return;
		}

		String[] parts = path.split("\\.");
		Map<String, Object> node = data;

		for (int index = 0; index < parts.length; index++) {
			Object obj = node.get(parts[index]);

			if (index == parts.length - 1) {
				node.put(parts[index], value);
				return;
			}

			if (obj == null || !(obj instanceof Map)) {
				obj = new HashMap<String, Object>();
				node.put(parts[index], obj);
			}

			node = (Map<String, Object>) obj;
		}
	}
	
	public void remove(String path) {
		if (!path.contains(".")) {
			data.remove(path);
			return;
		}

		String[] parts = path.split("\\.");
		Map<String, Object> node = data;

		for (int index = 0; index < parts.length; index++) {
			Object obj = node.get(parts[index]);

			if (index == parts.length - 1) {
				node.remove(parts[index]);
				return;
			}

			if (obj == null || !(obj instanceof Map)) {
				return;
			}

			node = (Map<String, Object>) obj;
		}
	}

	public Set<ConfigurationNode> getNodes() {
		return new HashSet<ConfigurationNode>(nodes);
	}

	public void removeNode(String path) {
		for (ConfigurationNode node : nodes) {
			if (node.getPath().equalsIgnoreCase(path)) {
				nodes.remove(node);
			}
		}
	}

	public void addNode(ConfigurationNode node) {
		Object value = this.getValue(node.getPath());
		if (value == null) {
			this.setValue(node.getPath(), node.getValue());
		} else {
			node.setValue(value, false);
		}

		nodes.add(node);
		node.config = this;
	}

	public ConfigurationNode addNode(String path, Object value) {
		ConfigurationNode node = new ConfigurationNode(path, value);
		node.setConfiguration(this);
		return node;
	}

	public void addNodes(ConfigurationNode... nodes) {
		for (ConfigurationNode node : nodes) {
			node.setConfiguration(this);
		}
	}

	public ConfigurationNode getNode(String path, Object def) {
		ConfigurationNode node = new ConfigurationNode(path, def);
		Object value = this.getValue(node.getPath());
		if (value == null) {
			value = def;
		}

		node.setValue(value, true);
		node.setConfiguration(this);
		return node;
	}
	
	/* public Map<String, Object> getNode(String path) {
		if(path == "") return this.data;
		
		try {
			return (Map<String, Object>) this.getValue(path);
		} catch (ClassCastException e) {
			return null;
		}
	} */

	public String getString(String path) {
		return this.getString(path, "");
	}

	public String getString(String path, String def) {
		Object value = this.getValue(path);

		if (value instanceof String) {
			return (String) value;
		}

		if (value == null) {
			this.setValue(path, def);
			save();
		}

		return def;
	}

	public int getInteger(String path) {
		return this.getInteger(path, 0);
	}

	public int getInteger(String path, int def) {
		Object value = this.getValue(path);
		Integer intValue = MathHelper.castInt(this.getValue(path));

		if (intValue != null) {
			return intValue;
		}

		if (value == null) {
			this.setValue(path, def);
			save();
		}

		return def;
	}

	public double getDouble(String path) {
		return this.getDouble(path, 0);
	}

	public double getDouble(String path, double def) {
		Object value = this.getValue(path);
		Double doubleValue = MathHelper.castDouble(value);

		if (doubleValue != null) {
			return doubleValue;
		}

		if (value == null) {
			this.setValue(path, def);
			save();
		}

		return def;
	}

	public float getFloat(String path) {
		return this.getFloat(path, 0);
	}

	public float getFloat(String path, float def) {
		Object value = this.getValue(path);
		Float floatValue = MathHelper.castFloat(value);

		if (floatValue != null) {
			return floatValue;
		}

		if (value == null) {
			this.setValue(path, def);
			save();
		}

		return def;
	}

	public boolean getBoolean(String path) {
		return this.getBoolean(path, false);
	}

	public boolean getBoolean(String path, boolean def) {
		Object value = this.getValue(path);
		Boolean booleanValue = MathHelper.castBoolean(value);

		if (booleanValue != null) {
			return booleanValue;
		}

		if (value == null) {
			this.setValue(path, def);
			save();
		}

		return def;
	}

	public List<Object> getList(String path) {
		return this.getList(path, null);
	}

	public List<Object> getList(String path, List<Object> def) {
		Object value = this.getValue(path);

		if (value != null && value instanceof List) {
			return (List<Object>) value;
		}

		if (value == null) {
			this.setValue(path, def);
			save();
		}

		return def;
	}

	public List<String> getStringList(String path) {
		return this.getStringList(path, null);
	}

	public List<String> getStringList(String path, List<String> def) {
		List<Object> raw = this.getList(path);

		if (raw != null) {
			List<String> list = new ArrayList<String>();

			for (Object obj : raw) {
				list.add(obj.toString());
			}

			return list;
		}

		return def;
	}

	public List<Integer> getIntegerList(String path) {
		return this.getIntegerList(path, null);
	}

	public List<Integer> getIntegerList(String path, List<Integer> def) {
		List<Object> raw = this.getList(path);

		if (raw != null) {
			List<Integer> list = new ArrayList<Integer>();

			for (Object obj : raw) {
				Integer integerValue = MathHelper.castInt(obj);

				list.add(integerValue);
			}

			return list;
		}

		return def;
	}

	public List<Double> getDoubleList(String path) {
		return this.getDoubleList(path, null);
	}

	public List<Double> getDoubleList(String path, List<Double> def) {
		List<Object> raw = this.getList(path);

		if (raw != null) {
			List<Double> list = new ArrayList<Double>();

			for (Object obj : raw) {
				Double doubleValue = MathHelper.castDouble(obj);

				list.add(doubleValue);
			}

			return list;
		}

		return def;
	}

	public List<Float> getFloatList(String path) {
		return this.getFloatList(path, null);
	}

	public List<Float> getFloatList(String path, List<Float> def) {
		List<Object> raw = this.getList(path);

		if (raw != null) {
			List<Float> list = new ArrayList<Float>();

			for (Object obj : raw) {
				Float floatValue = MathHelper.castFloat(obj);

				list.add(floatValue);
			}

			return list;
		}

		return def;
	}

	public List<Boolean> getBooleanList(String path) {
		return this.getBooleanList(path, null);
	}

	public List<Boolean> getBooleanList(String path, List<Boolean> def) {
		List<Object> raw = this.getList(path);

		if (raw != null) {
			List<Boolean> list = new ArrayList<Boolean>();

			for (Object obj : raw) {
				Boolean booleanValue = MathHelper.castBoolean(obj);

				list.add(booleanValue);
			}

			return list;
		}

		return def;
	}

	public Set<String> getKeys(String path) {
		Set<String> keys = new HashSet<String>();
		String[] sections = path.split("\\.");
		Map<String, Object> section = this.data;

		for (int index = 0; index < sections.length && section != null; index++) {
			String sec = sections[index];

			try {
				section = (Map<String, Object>) section.get(sec);
			} catch (Exception e) {
				OpenClassic.getLogger().warning("[Configuration] Invalid path!");
				e.printStackTrace();
			}
		}

		if (section != null) {
			keys = section.keySet();
		}

		return keys;
	}
	
	public Map<String, Object> getData() {
		return new HashMap<String, Object>(this.data);
	}

}
