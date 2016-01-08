package io.hedwig.bootsamples.config.meta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.boot.configurationmetadata.ConfigurationMetadataGroup;
import org.springframework.boot.configurationmetadata.ConfigurationMetadataProperty;
import org.springframework.boot.configurationmetadata.ConfigurationMetadataRepository;

public abstract class MetadataUtils {

	public static final Comparator<ConfigurationMetadataGroup> GROUP_COMPARATOR = new GroupComparator();

	public static final Comparator<ConfigurationMetadataProperty> PROPERTY_COMPARATOR = new PropertyComparator();

	/**
	 * sort groups
	 * @param groups
	 * @return
	 */
	public static List<ConfigurationMetadataGroup> sortGroups(
			Collection<ConfigurationMetadataGroup> groups) {
		List<ConfigurationMetadataGroup> result
				= new ArrayList<>(groups);
		Collections.sort(result, GROUP_COMPARATOR);
		return result;
	}

	/**
	 * sort properties
	 * @param properties
	 * @return
	 */
	public static  List<ConfigurationMetadataProperty> sortProperties(
			Collection<ConfigurationMetadataProperty> properties) {
		List<ConfigurationMetadataProperty> result =
				new ArrayList<>(properties);
		Collections.sort(result, PROPERTY_COMPARATOR);
		return result;
	}

	/**
	 * 比较器
	 */
	private static class GroupComparator implements Comparator<ConfigurationMetadataGroup> {

		@Override
		public int compare(ConfigurationMetadataGroup o1, ConfigurationMetadataGroup o2) {
			if (ConfigurationMetadataRepository.ROOT_GROUP.equals(o1.getId())) {
				return -1;
			}
			if (ConfigurationMetadataRepository.ROOT_GROUP.equals(o2.getId())) {
				return 1;
			}
			return o1.getId().compareTo(o2.getId());
		}
	}

	/**
	 * id 比较
	 */
	private static class PropertyComparator implements Comparator<ConfigurationMetadataProperty> {
		@Override
		public int compare(ConfigurationMetadataProperty o1, ConfigurationMetadataProperty o2) {
			return o1.getId().compareTo(o2.getId());
		}
	}
}
