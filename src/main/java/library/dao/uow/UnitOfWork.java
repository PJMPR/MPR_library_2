package library.dao.uow;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork implements IUnitOfWork{

	private List<Entity> entities = new ArrayList<Entity>();
	Connection _connection;
	
	public UnitOfWork(Connection connection) throws SQLException{
		_connection= connection;
		_connection.setAutoCommit(false);
	}
	
	public void saveChanges() {
		
		for(Entity entity: entities){
			entity.persist();
		}
		
		try {
			_connection.commit();
			entities.clear();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}

	public void rollback() {
		entities.clear();
		
	}

	public void markAsNew(Entity entity) {
		entity.setState(EntityState.New);
		entities.add(entity);
	}

	public void markAsDeleted(Entity entity) {
		entity.setState(EntityState.Deleted);
		entities.add(entity);
	}

	public void markAsChanged(Entity entity) {
		entity.setState(EntityState.Changed);
		entities.add(entity);
	}

}
