package com.cg.hbm.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cg.hbm.dto.ReviewDTO;

@Service
public interface IReviewService {
	ReviewDTO createReview(ReviewDTO reviewDto,int userId,int hotelId);
	ReviewDTO updateReview(ReviewDTO reviewDto,int reviewId);
	void deleteReview(int reviewId);
	ReviewDTO getReviewById(int reviewId);
	List<ReviewDTO> getAllReviews();
	List<ReviewDTO> getReviewsForHotel(int hotelId);
	double getAverageRatingForHotel(int hotelId);

}
