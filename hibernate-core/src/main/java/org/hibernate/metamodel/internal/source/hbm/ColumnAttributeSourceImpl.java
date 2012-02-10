/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2011, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.internal.source.hbm;

import org.hibernate.TruthValue;
import org.hibernate.metamodel.spi.relational.Datatype;
import org.hibernate.metamodel.spi.relational.Size;
import org.hibernate.metamodel.spi.source.ColumnSource;

/**
 * Implementation of a {@link ColumnSource} when the column is declared as just the name via the column XML
 * attribute.  For example, {@code <property name="socialSecurityNumber" column="ssn"/>}.
 *
 * @author Steve Ebersole
 */
class ColumnAttributeSourceImpl implements ColumnSource {
	private final String tableName;
	private final String columnName;
	private TruthValue includedInInsert;
	private TruthValue includedInUpdate;
    private TruthValue nullable;

	ColumnAttributeSourceImpl(
			String tableName,
			String columnName,
			TruthValue includedInInsert,
			TruthValue includedInUpdate) {
		this( tableName, columnName, includedInInsert, includedInUpdate, TruthValue.UNKNOWN );
	}

    ColumnAttributeSourceImpl(
			String tableName,
			String columnName,
			TruthValue includedInInsert,
			TruthValue includedInUpdate,
            TruthValue nullable) {
		this.tableName = tableName;
		this.columnName = columnName;
		this.includedInInsert = includedInInsert;
		this.includedInUpdate = includedInUpdate;
        this.nullable = nullable;
	}

	@Override
	public Nature getNature() {
		return Nature.COLUMN;
	}

	@Override
	public TruthValue isIncludedInInsert() {
		return includedInInsert;
	}

	@Override
	public TruthValue isIncludedInUpdate() {
		return includedInUpdate;
	}

	@Override
	public String getContainingTableName() {
		return tableName;
	}

	@Override
	public String getName() {
		return columnName;
	}

	@Override
	public TruthValue isNullable() {
		return nullable;
	}

	@Override
	public String getDefaultValue() {
		return null;
	}

	@Override
	public String getSqlType() {
		return null;
	}

	@Override
	public Datatype getDatatype() {
		return null;
	}

	@Override
	public Size getSize() {
		return null;
	}

	@Override
	public String getReadFragment() {
		return null;
	}

	@Override
	public String getWriteFragment() {
		return null;
	}

	@Override
	public boolean isUnique() {
		return false;
	}

	@Override
	public String getCheckCondition() {
		return null;
	}

	@Override
	public String getComment() {
		return null;
	}
}