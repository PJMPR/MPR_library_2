package library.dao.uow;

import library.domain.IHaveId;

public class Entity {

	IHaveId entity;
	EntityState state;
	
	IUnitOfWorkRepository _repository;
	
	public Entity(IUnitOfWorkRepository repository){
		_repository = repository;
	}
	
	public IHaveId getEntity() {
		return entity;
	}
	
	public void setEntity(IHaveId entity) {
		this.entity = entity;
	}
	
	public EntityState getState() {
		return state;
	}
	
	public void setState(EntityState state) {
		this.state = state;
	}

	public void persist() {
		switch(state){
		case Changed:
			_repository.persistUpdate(this);
			break;
		case Deleted:
			_repository.persistDelete(this);
			break;
		case New:
			_repository.persistAdd(this);
			break;
		default:
			break;}
		
	}
	
	
	
}
