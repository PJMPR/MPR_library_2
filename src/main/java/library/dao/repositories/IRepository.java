package library.dao.repositories;

import java.util.List;

import library.domain.IHaveId;

public interface IRepository<TEntity extends IHaveId> {

	public void delete(TEntity entity);

	public int count();

	public int lastId();

	public void add(TEntity entity);

	public void update(TEntity entity);

	public void createTable();

	public List<TEntity> getPage(int offset, int limit);

	public TEntity get(int id);

}