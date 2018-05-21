package com.cn.sys.user.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlHandler {

	private Document document;
	private String filePath;
	private static Logger logger = Logger.getLogger(XmlHandler.class);

	public void loadXmlFile(String filePath) throws IOException, DocumentException {
		this.filePath = filePath;
		SAXReader xmlReader = new SAXReader();
		document = xmlReader.read(new File(this.filePath));
	}

	public void loadXmlFile(InputStream inputStream) throws IOException, DocumentException {
		SAXReader xmlReader = new SAXReader();
		xmlReader.setEncoding("UTF-8");
		document = xmlReader.read(inputStream);
	}

	public void write() {
		write(this.filePath);
	}

	public void write(String filePath) {
		try {
			FileWriter fw = new FileWriter(filePath);
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("GB2312");
			XMLWriter writer = new XMLWriter(fw, format);
			writer.write(document);
			writer.close();
			fw.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public byte[] toByteArray() {
		ByteArrayOutputStream baos = null;
		DataOutputStream dos = null;
		byte[] byteArray = null;
		try {
			baos = new ByteArrayOutputStream();
			dos = new DataOutputStream(baos);
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("GB2312");
			XMLWriter writer = new XMLWriter(dos, format);
			writer.write(document);
			writer.close();
			byteArray = baos.toByteArray();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (dos != null)
				try {
					dos.close();
				} catch (IOException e) {
				}
			if (baos != null)
				try {
					baos.close();
				} catch (IOException e) {
				}
		}
		return byteArray;
	}

	public void addData(String xpath, String element, String attrib[], String value[]) {
		List list = document.selectNodes(xpath);
		if (list != null) {
			Element e = (Element) list.get(0);
			Element user = e.addElement(element);
			for (int i = 0; i < attrib.length; i++)
				if (value[i] != null)
					user.addAttribute(attrib[i], value[i]);

		}
	}

	public void addElements(String xpath, String key, String value, HashMap map) {
		Element me = null;
		List list = document.selectNodes(xpath);
		for (int i = 0; i < list.size(); i++) {
			Element e = (Element) list.get(i);
			for (Iterator it = e.attributeIterator(); it.hasNext();) {
				Attribute attrib = (Attribute) it.next();
				if (attrib.getName().equals(key) && attrib.getValue().equals(value))
					me = e;
			}

		}

		if (me != null) {
			String name;
			for (Iterator it = map.keySet().iterator(); it.hasNext(); me.addAttribute(name, (String) map.get(key)))
				name = (String) it.next();

		}
	}

	public List<HashMap<String, String>> getDataList(String xpath) {
		List list = new ArrayList();
		if (document == null) {
			return list;
		}
		List nodes = document.selectNodes(xpath);
		Iterator iter = nodes.iterator();
		while (iter.hasNext()) {
			Element element = (Element) iter.next();
			HashMap map = new HashMap();
			if (element.attributeCount() > 0) {
				for (Iterator it = element.attributeIterator(); it.hasNext();) {
					Attribute attrib = (Attribute) it.next();
					map.put(attrib.getName(), attrib.getValue());
				}
			}
			list.add(map);
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getTextList(String xpath){
		List list = new ArrayList();
		if (document == null) {
			return list;
		}
		List nodes = document.selectNodes(xpath);
		Iterator iter = nodes.iterator();
		while (iter.hasNext()) {
			Element element = (Element) iter.next();
			list.add(element.getText());
		}
		return list;
	}

	public HashMap<String, String> getDataMap(String xpath) {

		HashMap<String, String> map = new HashMap<String, String>();

		if (document == null) {
			return map;
		}

		List nodes = document.selectNodes(xpath);
		Iterator iter = nodes.iterator();
		while (iter.hasNext()) {
			Element element = (Element) iter.next();
			if (element.attributeCount() > 0) {
				for (Iterator it = element.attributeIterator(); it.hasNext();) {
					Attribute attrib = (Attribute) it.next();
					map.put(attrib.getName(), attrib.getValue());
				}
			}
		}
		return map;
	}

	public String getData(String xpath, String key, String value, String str) {
		Element me = null;
		String s = "";
		List list = document.selectNodes(xpath);
		for (int i = 0; i < list.size(); i++) {
			Element e = (Element) list.get(i);
			for (Iterator it = e.attributeIterator(); it.hasNext();) {
				Attribute attrib = (Attribute) it.next();
				if (attrib.getName().equals(key) && attrib.getValue().equals(value))
					me = e;
			}

		}

		if (me != null && me.attributeCount() > 0) {
			for (Iterator ite = me.attributeIterator(); ite.hasNext();) {
				Attribute attrib = (Attribute) ite.next();
				if (attrib.getName().equals(str))
					s = attrib.getValue();
			}

		}
		return s;
	}

	public void removeData(String xpath, String key, String value) {
		List list = document.selectNodes(xpath);
		for (int i = 0; i < list.size(); i++) {
			Element e = (Element) list.get(i);
			for (Iterator it = e.attributeIterator(); it.hasNext();) {
				Attribute attrib = (Attribute) it.next();
				if (attrib.getName().equals(key) && attrib.getValue().equals(value)) {
					Element p = e.getParent();
					p.remove(e);
				}
			}

		}

	}

	public void removeAll(String xpath) {
		List list = document.selectNodes(xpath);
		for (int i = 0; i < list.size(); i++) {
			Element e = (Element) list.get(i);
			e.getParent().remove(e);
		}

	}

	public void updateData(String xpath, String key, String value, String ma, String mv) {
		Element me = null;
		List list = document.selectNodes(xpath);
		for (int i = 0; i < list.size(); i++) {
			Element e = (Element) list.get(i);
			for (Iterator it = e.attributeIterator(); it.hasNext();) {
				Attribute attrib = (Attribute) it.next();
				if (attrib.getName().equals(key) && attrib.getValue().equals(value))
					me = e;
			}

		}

		if (me != null && me.attributeCount() > 0) {
			for (Iterator ite = me.attributeIterator(); ite.hasNext();) {
				Attribute attrib = (Attribute) ite.next();
				if (attrib.getName().equals(ma))
					attrib.setValue(mv);
			}

		}
	}

	public void updateData(String xpath, String key, String value, Map map) {
		Element me = null;
		List list = document.selectNodes(xpath);
		for (int i = 0; i < list.size(); i++) {
			Element e = (Element) list.get(i);
			for (Iterator it = e.attributeIterator(); it.hasNext();) {
				Attribute attrib = (Attribute) it.next();
				if (attrib.getName().equals(key) && attrib.getValue().equals(value))
					me = e;
			}

		}

		ArrayList updatedList = new ArrayList();
		ArrayList deleteList = new ArrayList();
		if (me != null && me.attributeCount() > 0) {
			for (Iterator ite = me.attributeIterator(); ite.hasNext();) {
				Attribute attrib = (Attribute) ite.next();
				for (Iterator it = map.keySet().iterator(); it.hasNext();) {
					String k = (String) it.next();
					if (attrib.getName().equals(k)) {
						attrib.setValue((String) map.get(k));
						if (attrib.getValue() == null)
							deleteList.add(attrib);
						updatedList.add(k);
					}
				}

			}

			for (int i = 0; i < deleteList.size(); i++)
				me.remove((Attribute) deleteList.get(i));

			for (int i = 0; i < updatedList.size(); i++) {
				String updatedKey = (String) updatedList.get(i);
				map.remove(updatedKey);
			}

			String attrib;
			String value_;
			for (Iterator it = map.keySet().iterator(); it.hasNext(); me.addAttribute(attrib, value_)) {
				attrib = (String) it.next();
				value_ = (String) map.get(attrib);
			}

		}
	}

	public void update(String xpath, String key, String value) {
		List list = document.selectNodes(xpath);
		for (int i = 0; i < list.size(); i++) {
			Element e = (Element) list.get(i);
			for (Iterator it = e.attributeIterator(); it.hasNext();) {
				Attribute attrib = (Attribute) it.next();
				if (attrib.getName().equals(key)){
					attrib.setValue(value);
					updateToFile();	
				}
			}

		}

	}

	private Element findElementByKey(String xpath, String key, String value) {
		Element e = null;
		List list = document.selectNodes(xpath);
		if (list != null && list.size() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				if (element.attributeCount() > 0) {
					for (Iterator it = element.attributeIterator(); it.hasNext();) {
						Attribute attrib = (Attribute) it.next();
						if (value == null)
							e = element;
						else if (attrib.getName().equals(key) && attrib.getValue().equals(value))
							e = element;
					}

				}
			}

		}
		return e;
	}
	
	public String getData(String xpath) {
		Element e;
		try{
			e = (Element) document.selectObject(xpath);
		}catch(Exception ex){
			return null;
		}
		return e.getText();
	}

	public String getData(String xpath, String key) {
		Element e;
		try{
			e = (Element) document.selectObject(xpath);
		}catch(Exception ex){
			return null;
		}
		for (Iterator it = e.attributeIterator(); it.hasNext();) {
			Attribute attrib = (Attribute) it.next();
			if (attrib.getName().equals(key))
				return attrib.getText();
		}
		return null;
	}
	
	public String getSonName(String xpath,int num){
		try{
			Element e =(Element) document.selectObject(xpath);
			Element son = (Element) e.elements().get(num);
			return son.getName();
		}catch(Exception ex){
			return null;
		}
	}
	private void updateToFile(){
		XMLWriter output;
		try {
			output = new XMLWriter(new FileWriter(
					new File(filePath)));
			output.write(document);
			output.close();
		} catch (IOException e1) {
			logger.error(e1.getMessage(), e1);
		}
	}
}
