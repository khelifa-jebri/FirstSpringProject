package com.example.demo.utils;

import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObjectUtils {

	private static final Logger logger = LogManager.getLogger(ObjectUtils.class);

	/**
	 * Copies properties from the source object to the target object. The source and
	 * target objects must be of the same type.
	 *
	 * @param source the source object
	 * @param target the target object
	 * @param <T>    the type of the objects
	 */
	public static <T> void copyProperties(T source, T target) {
		if (source == null || target == null) {
			throw new IllegalArgumentException("Source and target must not be null.");
		}
		Class<?> clazz = source.getClass();
		Class<?> targetClazz = target.getClass();
		while (clazz != null) {
			for (Field field : clazz.getDeclaredFields()) {
				try {
					field.setAccessible(true);
					Field targetField = null;
					try {
						targetField = targetClazz.getDeclaredField(field.getName());
					} catch (NoSuchFieldException e) {
						continue; // Ignore if target doesn't have the field
					}
					targetField.setAccessible(true);
					Object value = field.get(source);
					targetField.set(target, value);
				} catch (Exception e) {
					logger.error("Failed to copy property '" + field.getName() + "' from " + clazz.getName() + " to "
							+ targetClazz.getName(), e);
					throw new RuntimeException("Failed to copy property '" + field.getName() + "'", e);
				}
			}
			clazz = clazz.getSuperclass();
		}
	}
}