package library.dao.uow;

public interface IUnitOfWork {

	public void saveChanges();
	public void rollback();
	
	public void markAsNew(Entity entity);
	public void markAsDeleted(Entity entity);
	public void markAsChanged(Entity entity);
	
}
