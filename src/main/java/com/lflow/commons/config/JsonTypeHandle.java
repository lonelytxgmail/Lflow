package com.lflow.commons.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lflow.commons.exception.InternalException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.bson.Document;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description:
 * @Title: TypeHandle
 * @Package com.lflow.commons.config
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/21 11:28
 */

@MappedTypes(value = Document.class)
@MappedJdbcTypes(value = JdbcType.VARCHAR)
public class JsonTypeHandle extends BaseTypeHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        try {
            String s = null;
            if (preparedStatement != null) {
                s = objectMapper.writeValueAsString(o);
            }
            preparedStatement.setString(i, s);
        } catch (JsonProcessingException e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getDocument(resultSet.getString(s));
    }

    private Object getDocument(String s) {
        if (s != null && s.startsWith("{") && s.endsWith("}")) {
            try {
                return objectMapper.readValue(s, Document.class);
            } catch (JsonProcessingException e ){
                throw new InternalException(e.getMessage());
            }
        }
        return s;
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {

        return getDocument(resultSet.getString(i));
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getDocument(callableStatement.getString(i));
    }
}
