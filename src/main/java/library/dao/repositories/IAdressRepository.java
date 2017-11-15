package library.dao.repositories;


import java.util.List;

        import library.domain.Address;

public interface IAdressRepository extends IRepository<Address> {

    public List<Address> withCity(String city);
    public List<Address> withPostal(String postal);
    public List<Address> withStreet(String street);

}