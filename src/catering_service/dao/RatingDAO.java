package catering_service.dao;

import java.util.List;
import catering_service.entity.Rating;

public interface RatingDAO {
	
	List<Rating> findAll();
	Rating findById(int ratingId);
	List <Rating> findMaxScore();
	int save(Rating rating);
	int update(Rating rating);
	int delete(Rating rating);

}
