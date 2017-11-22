package library.dao.repositories.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.dao.mappers.IMapper;
import library.dao.repositories.IAdressRepository;
import library.dao.uow.IUnitOfWork;
import library.domain.Address;


public class AddressRepository extends RepositoryBase<Address> implements IAdressRepository{

	protected PreparedStatement selectByCity;
	protected PreparedStatement selectByPostal;
	protected PreparedStatement selectByStreet;

	private void selectStatements(Connection connection) throws SQLException {
		selectByCity = connection.prepareStatement( "SELECT * FROM address WHERE city=?");
		selectByPostal = connection.prepareStatement( "SELECT * FROM address WHERE postalcode=?");
		selectByStreet = connection.prepareStatement( "SELECT * FROM address WHERE street=?");

	}

	public AddressRepository(Connection connection, IMapper<Address> mapper, IUnitOfWork uow) throws SQLException{
		super(connection, mapper, uow);
	}
	
	@Override
	protected String createTableSql() {
		return "CREATE TABLE address("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "city VARCHAR(20),"
				+ "postalcode Varchar(7),"
				+ "street VARCHAR(32),"
				+ "apnumber VARCHAR(8)"
				+ ")";
	}

	@Override
	protected String getUpdateSql() {
		return "UPDATE address SET (city, postalcode, street, apnumber)=(?,?,?,?) WHERE id=?";
	}

	@Override
	protected String getTableName() {
		return "address";
	}

	@Override
	protected String getInsertSql() {
		return "INSERT INTO address(city,postalcode,street,apnumber) VALUES(?,?,?,?)";
	}

	@Override
	protected void setUpdate(Address adress) throws SQLException {
		update.setString(1, adress.getCity());
		update.setString(2, adress.getPostalCode());
		update.setString(3, adress.getStreet());
		update.setString(4, adress.getApNumber());
		update.setInt(5, adress.getId());
	}

	protected void setInsert(Address adress) throws SQLException {
		insert.setString(1,adress.getCity());
		insert.setString(2,adress.getPostalCode());
		insert.setString(3,adress.getStreet());
		insert.setString(4,adress.getApNumber());
	}
	public List<Address> withCity(String city) {

		List<Address> Addresses = new ArrayList<Address>();
		try {
			ResultSet rs = selectByCity.executeQuery();
			while(rs.next()){
				Addresses.add(_mapper.map(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Addresses;

	}

	public List<Address> withPostal(String postal) {
		List<Address> Addresses = new ArrayList<Address>();
		try {
			ResultSet rs = selectByPostal.executeQuery();
			while(rs.next()){
				Addresses.add(_mapper.map(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Addresses;
	}
	public List<Address> withStreet(String street) {
		List<Address> Addresses = new ArrayList<Address>();
		try {
			ResultSet rs = selectByStreet.executeQuery();
			while(rs.next()){
				Addresses.add(_mapper.map(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Addresses;
	}

}
