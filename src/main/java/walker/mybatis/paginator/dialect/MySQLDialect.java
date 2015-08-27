package walker.mybatis.paginator.dialect;

import walker.mybatis.paginator.PageBounds;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * mysql分页Dialect
 *
 * 重写mysql的分页语句.
 *
 * @author HuQingmiao
 */
public class MySQLDialect extends Dialect {

    public MySQLDialect(MappedStatement mappedStatement, Object parameterObject, PageBounds pageBounds) {
        super(mappedStatement, parameterObject, pageBounds);
    }

    protected String getLimitString(String sql, String offsetName, int offset, String limitName, int limit) {
        StringBuffer buffer = new StringBuffer(sql.length() + 20).append(sql);
        if (offset > 0) {
            buffer.append(" LIMIT ").append(offset-1).append(",").append(limit);
        } else {
            buffer.append(" LIMIT ").append(limit);
        }
        return buffer.toString();
    }

}
