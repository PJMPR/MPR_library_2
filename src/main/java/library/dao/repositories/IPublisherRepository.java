package library.dao.repositories;

import java.util.List;

import library.domain.Publisher;

public interface IPublisherRepository extends IRepository<Publisher> {
	
	public List<Publisher> withName(String name);
	public List<Publisher> selectAll();
}
