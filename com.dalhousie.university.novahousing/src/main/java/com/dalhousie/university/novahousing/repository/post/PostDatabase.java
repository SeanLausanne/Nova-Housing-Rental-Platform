// Author: Xiao Ling

package com.dalhousie.university.novahousing.repository.post;

import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.model.post.Property;
import com.dalhousie.university.novahousing.services.filters.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
@Primary
public class PostDatabase extends JdbcDaoSupport implements PostPersistence {

	@Autowired
	public PostDatabase(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public int savePostToDatabse(Post post) {
		String id = post.getId();
		Property property = post.getProperty();
		String type = property.getType();
		String postDate = post.getPostDate();
		String adminApproved = post.getAdminApproved();
		int area = property.getArea();
		int bedroomNumber = property.getBedroomNumber();
		double bathroomNumber = property.getBathroomNumber();

		String query = String.format(
				"INSERT INTO Posts (id, postDate, propertyType, area, bedroomNumber, bathroomNumber, adminApproved) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
		int update = this.getJdbcTemplate().update(query,
				new Object[] { id, postDate, type, area, bedroomNumber, bathroomNumber, adminApproved });

		System.out.println("update = " + String.valueOf(update));

		return update;
	}

	@Override
	public int removePostFromDatabase(Post post) {
		String id = post.getId();
		String query = String.format("DELETE FROM Posts WHERE id = ?");
		int update = this.getJdbcTemplate().update(query, new Object[] { id });

		System.out.println("update = " + String.valueOf(update));

		return update;
	}

	@Override
	public int removePostFromDatabaseById(String id) {
		String query = String.format("DELETE FROM Posts WHERE id = ?");
		int update = this.getJdbcTemplate().update(query, new Object[] { id });

		System.out.println("update = " + String.valueOf(update));

		return update;
	}

	@Override
	public int updatePostInDatabase(Post post) {
		String id = post.getId();
		Property property = post.getProperty();
		String type = property.getType();
		String postDate = post.getPostDate();
		int area = property.getArea();
		int bedroomNumber = property.getBedroomNumber();
		double bathroomNumber = property.getBathroomNumber();

		String query = String.format(
				"UPDATE Posts set postDate = ?, propertyType = ?, area = ?, bedroomNumber = ?, bathroomNumber = ? where id = ?");
		int update = this.getJdbcTemplate().update(query,
				new Object[] { postDate, type, area, bedroomNumber, bathroomNumber, id });

		System.out.println("update = " + String.valueOf(update));

		return update;
	}

	@Override
	public List<Map<String, Object>> searchPostInDatabase(List<SearchFilter> filters) {

		StringBuilder sb = new StringBuilder();
		sb.append("select * from Posts");

		for (int i = 0; i < filters.size(); i++) {

			SearchFilter filter = filters.get(i);
			String filterCategory = filter.getFilterCategory();
			String filterValue = filter.getFilterValue();

			String clause;
			String linkingWord;

			if (i == 0) {
				linkingWord = " where ";
			} else {
				linkingWord = " and ";
			}

			clause = linkingWord + filterCategory + " = " + filterValue;
			sb.append(clause);
		}

		String query = sb.toString();
		System.out.println(query);

		List<Map<String, Object>> results = this.getJdbcTemplate().queryForList(query);

		return results;
	}
}
