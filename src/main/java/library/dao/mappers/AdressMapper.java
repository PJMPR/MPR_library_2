package library.dao.mappers;

import library.domain.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdressMapper implements IMapper<Address> {

    public Address map(ResultSet rs) throws SQLException {
        Address adress = new Address();
        adress.setId(rs.getInt("id"));
        adress.setCity(rs.getString("city"));
        adress.setPostalCode(rs.getString("postalcode"));
        adress.setStreet(rs.getString("street"));
        adress.setApNumber(rs.getString("apnumber"));
        return adress;
    }
}
