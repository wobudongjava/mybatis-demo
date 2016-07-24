package com.sunny.mybatis_demo.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.sunny.mybatis_demo.entity.PhoneNumber;

/**
 * @ClassName PhoneTypeHandler
 * @Description TODO mybatis自定义类型处理器	
 * @author Sunny
 * @date 2016-7-23上午6:40:51
 * @version V1.0
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnName));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnIndex));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return new PhoneNumber(cs.getString(columnIndex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, parameter.getAsString());
	}

}
