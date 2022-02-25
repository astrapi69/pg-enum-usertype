/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.db.postgres.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;
import org.postgresql.util.PGobject;

import io.github.astrapi69.db.DatabaseDefaults;

/**
 * The class {@link PGEnumUserType} maps string to enum and back. Can be used only with Postgres
 * database and hibernate.
 *
 * Note: Only use with Postgres and hibernate 5!!!
 *
 * @author Asterios Raptis
 */
public class PGEnumUserType implements EnhancedUserType, ParameterizedType
{

	/** The Constant INSTANCE. */
	public static final PGEnumUserType INSTANCE = new PGEnumUserType();
	private static final Logger log = Logger.getLogger(PGEnumUserType.class.getName());
	/** The enum class. */
	@SuppressWarnings("rawtypes")
	private Class<Enum> enumClass;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException
	{
		return deepCopy(cached);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object deepCopy(Object value) throws HibernateException
	{
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Serializable disassemble(Object value) throws HibernateException
	{
		return (Enum)deepCopy(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object x, Object y) throws HibernateException
	{
		return Objects.equals(x, y);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object fromXMLString(String xmlValue)
	{
		return Enum.valueOf(enumClass, xmlValue);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode(Object object) throws HibernateException
	{
		return Objects.hashCode(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isMutable()
	{
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * Retrieve an instance of the mapped class from a JDBC result set.
	 *
	 * @param rs
	 *            the JDBC result set
	 * @param names
	 *            the column names
	 * @param session
	 *            the session
	 * @param owner
	 *            the entity that contains the enum.
	 * @return the object
	 * @throws HibernateException
	 *             is thrown if an error from hibernate occured
	 * @throws SQLException
	 *             is thrown if an error with sql
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
		SharedSessionContractImplementor session, Object owner)
		throws HibernateException, SQLException
	{
		final String columnName = names[0];
		final Object columnValue = rs.getObject(columnName);
		Object params[] = { columnName, columnValue };
		log.log(Level.FINE, "Result set column {0} value is {1}", params);
		if (rs.wasNull())
		{
			return null;
		}
		// Notice how Object is mapped to PGobject. This makes this
		// implementation Postgres specific
		if (columnValue instanceof PGobject)
		{
			final PGobject pg = (PGobject)columnValue;
			return Enum.valueOf(enumClass, pg.getValue());
		}
		// Try to get over the name of the enum value.
		if (columnValue != null && enumClass != null)
		{
			final String enumValueName = columnValue.toString().trim();
			return Enum.valueOf(enumClass, enumValueName);
		}
		return null;
	}

	/**
	 * Write an instance of the mapped class to a prepared statement. A multi-column type should be
	 * written to parameters starting from <tt>index</tt>.
	 *
	 * @param st
	 *            a JDBC prepared statement
	 * @param value
	 *            the object to write
	 * @param index
	 *            the statement parameter index
	 * @param session
	 *            the session
	 * @throws HibernateException
	 *             is thrown if an error from hibernate occured
	 * @throws SQLException
	 *             is thrown if an error with sql
	 */
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
		SharedSessionContractImplementor session) throws HibernateException, SQLException
	{
		if (value == null)
		{
			log.log(Level.FINE, "Binding null to parameter {0} ", index);
			st.setNull(index, Types.OTHER);
			// UPDATE: To support NULL insertion, change to:
			// st.setNull(index, 1111);
		}
		else
		{
			Object params[] = { value, index };
			log.log(Level.FINE, "Result set column {0} value is {1}", params);
			// Notice 1111 which java.sql.Type for Postgres Enum
			st.setObject(index, (value), Types.OTHER);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public String objectToSQLString(Object value)
	{
		return '\'' + ((Enum)value).name() + '\'';
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException
	{
		return deepCopy(original);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Class returnedClass()
	{
		return enumClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setParameterValues(Properties parameters)
	{
		final String enumClassName = parameters.getProperty(DatabaseDefaults.ENUM_CLASS_NAME);
		try
		{
			enumClass = (Class<Enum>)Class.forName(enumClassName);
		}
		catch (final ClassNotFoundException cnfe)
		{
			throw new HibernateException("Enum class not found", cnfe);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int[] sqlTypes()
	{
		// UPDATE: To support NULL insertion, change to:
		// return new int[] { 1111 };
		return new int[] { Types.VARCHAR };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public String toXMLString(Object value)
	{
		return ((Enum)value).name();
	}

}
