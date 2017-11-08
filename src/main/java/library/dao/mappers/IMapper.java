package library.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapper<TEntity> {

	public TEntity map(ResultSet rs) throws SQLException;
}
