package com.raw.kamaq.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataTableConverter {

	private Collection<?> collection;
	private static String[] columns;
	private List<Map<?, ?>> table;
	private String columnAsLink;
	private String columnId;

	public DataTableConverter(Collection<?> collection, String[] columns) {
		this.collection = collection;
		this.columns = columns;
		this.convert();
	}

	private void convert() {
		table = new ArrayList<Map<?, ?>>();
		for (Object row : collection) {
			Map<String, Object> map = new TreeMap<String, Object>();
			map = DataTableConverter.getNonNullProperties(row);
			table.add(map);
		}
	}

	public static Map<String, Object> getNonNullProperties(final Object object) {
		final Map<String, Object> nonNullProperties = new TreeMap<String, Object>();
		try {
			final BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
			for (final PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
				try {
					final Object propertyValue = descriptor.getReadMethod().invoke(object);
					if (Arrays.asList(columns).contains(descriptor.getName())) {
						if (propertyValue != null) {
							String index = Integer.toString(Arrays.asList(columns).indexOf(descriptor.getName()));
							nonNullProperties.put(index + "." + descriptor.getName(), propertyValue);
							// nonNullProperties.put(descriptor.getName(),
							// propertyValue);
						}
					}
				} catch (final IllegalArgumentException e) {
					System.out.println(e);
				} catch (final IllegalAccessException e) {
					System.out.println(e);
				} catch (final InvocationTargetException e) {
					System.out.println(e);
				}
			}
		} catch (final IntrospectionException e) {
			System.out.println(e);
		} catch (Exception e) {
			// System.out.println(e);
		}
		return nonNullProperties;

	}

	public void print() {
		for (Map<?, ?> row : this.table) {
			for (Map.Entry<?, ?> entry : row.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getColumnAsLink() {
		return columnAsLink;
	}

	public void setColumnAsLink(String columnAsLink) {
		this.columnAsLink = columnAsLink;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public List<Map<?, ?>> getTable() {
		return table;
	}

	public void setTable(List<Map<?, ?>> table) {
		this.table = table;
	}

}
