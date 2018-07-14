package cn.enderqiu.bcinvestrebuild.app.review;

import cn.enderqiu.bcinvestrebuild.app.review.response.ReviewDataResponse;
import cn.enderqiu.bcinvestrebuild.app.review.serializer.ReviewDataFormSerializer;
import cn.enderqiu.bcinvestrebuild.framework.View;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewView extends View {

    public ReviewDataResponse uploadReviewData(Object companyRecord, ReviewDataFormSerializer serializer) {
        return null;
    }

    public List<ReviewDataResponse> getReviewData(Object userRecord) {
        return null;
    }

    public ReviewDataResponse setReviewStatus(ReviewDataFormSerializer serializer) {
        return null;
    }
}
