package dao;

public interface Query_SQL_DAO {
	float getMaxID();

	int edit();

	void rollback();

	int add();

	boolean delete();

	int checkExist();

	int getCountNumberOf();
}
