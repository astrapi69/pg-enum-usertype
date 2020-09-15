package de.alpharogroup.db;

public enum DatabaseDefaults
{
	TYPE_DEF_PARAMETER_NAME(DatabaseDefaults.ENUM_CLASS_NAME);

	public static final String ENUM_CLASS_NAME = "enumClassName";
	/** The name */
	private final String name;

	DatabaseDefaults(final String name)
	{
		this.name = name;
	}

	/**
	 * Gets the specific name
	 *
	 * @return the specific name
	 */
	public String getName()
	{
		return name;
	}

}
