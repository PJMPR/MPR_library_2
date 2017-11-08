

    package library.dao.repositories;
     
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.List;
     
    import library.domain.BookInformation;
     
    public class BookInformationRepository extends RepositoryBase {
     
        public BookInformationRepository(Connection connection) {
            super(connection);
        }
     
        @Override
        protected String getTableName() {
        return "bookInformation";
        }
        @Override
        protected String getUpdateSql() {
        return "UPDATE bookInformation SET (id, title)=(?,?) WHERE id=?";
        }
        @Override
        protected String getInsertSql() {
        return "INSERT INTO bookInformation(id, title) VALUES(?,?)";
        }
           
     
        public void delete(BookInformation bookInformation){
     
            try {
                delete.setInt(1, bookInformation.getId());
                delete.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void update(BookInformation bookInformation){
     
            try {
                update.setString(1, bookInformation.getTitle());
                update.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     
        public BookInformation get(int id){
            BookInformation bookInformation = null;
     
            try {
                selectById.setInt(1, id);
                ResultSet rs = selectById.executeQuery();
                while(rs.next()){
                    bookInformation=new BookInformation();
                    bookInformation.setTitle(rs.getString("title"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
     
            return bookInformation;
     
        }
     
        public List<BookInformation> getPage(int offset, int limit){
     
            List<BookInformation> result = new ArrayList<BookInformation>();
            try {
                selectByPage.setInt(1, offset);
                selectByPage.setInt(2, limit);
                ResultSet rs = selectByPage.executeQuery();
                while(rs.next()){
                    BookInformation bI = new BookInformation();
                    bI.setId(rs.getInt("id"));
                    bI.setTitle(rs.getString("title"));
                    result.add(bI);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }
     
        public void add(BookInformation bookInformation){
     
            try {
                insert.setString(1, bookInformation.getTitle());
                insert.executeUpdate();
     
            } catch (SQLException e) {
                e.printStackTrace();
            }
     
        }
     
        public void createTable(){
     
            String createTableSql = "CREATE TABLE bookInformation("
                    + "id bigint GENERATED BY DEFAULT AS IDENTITY,"
                    + "title VARCHAR(20)"
                    + ")";
     
            try {
                Statement createTable = _connection.createStatement();
                if(!tableExists)
                    createTable.executeUpdate(createTableSql);
     
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     
     
    }

