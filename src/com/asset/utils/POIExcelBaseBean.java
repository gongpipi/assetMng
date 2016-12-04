package com.asset.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class POIExcelBaseBean {
	/**
	 * 按字段取
	 * 
	 * @param fieldName
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public String get(String fieldName, POIExcelBaseBean bean) throws Exception {
		String o = null;
		Class<?> clazz = getClazz();
		o = getFieldValue(bean, clazz, fieldName);
		return o;
	}

	/**
	 * 获取类对象
	 * 
	 * @return
	 */
	private Class<?> getClazz() {
		Class<?> clazz = null;
		try {
			clazz = this.getClass();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazz;
	}

	/**
	 * 按索引取，从1开始，按定义字段的排列顺序序列
	 * 
	 * @param fieldName
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public String get(int index, POIExcelBaseBean bean) throws Exception {
		if (index <= 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		String o = null;
		Class<?> clazz = getClazz();
		Field field = clazz.getDeclaredFields()[index - 1];
		String fieldName = field.getName();
		o = getFieldValue(bean, clazz, fieldName);
		return o;
	}

	/**
	 * 获取字段值
	 * 
	 * @param bean
	 * @param clazz
	 * @param fieldName
	 * @return
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public String getFieldValue(POIExcelBaseBean bean, Class<?> clazz, String fieldName) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		String o;
		Method method = clazz.getMethod("get" + fieldName.substring(0, 1).toUpperCase()
				+ (fieldName.length() > 1 ? fieldName.substring(1) : ""));
		o = (String) method.invoke(bean);
		return o;
	}

	/**
	 * 用反射获取字段个数
	 * 
	 * @return
	 */
	public int size() {
		Class<?> clazz = getClazz();
		return clazz.getDeclaredFields().length;
	}
}
