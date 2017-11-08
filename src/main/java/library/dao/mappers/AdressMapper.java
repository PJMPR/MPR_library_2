package library.dao.mappers;

import library.domain.Adress;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdressMapper implements IMapper<Adress> {

    public Adress map(ResultSet rs) throws SQLException {
        Adress adress = new Adress();
        adress.setId(rs.getInt("id"));
        adress.setCity(rs.getString("city"));
        adress.setPostalCode(rs.getString("postalcode"));
        adress.setStreet(rs.getString("street"));
        adress.setApNumber(rs.getString("apnumber"));
        return adress;
    }
}
