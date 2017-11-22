package library.dao.repositories;

import java.util.List;


import library.domain.User;

public interface IUserRepository extends IRepository<User> {
	public List<User> withStatus(boolean status);
	public List<User> withLogin(String login);

}
