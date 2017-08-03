package com.respire.pocketshop.service;

import com.respire.pocketshop.domain.Feedback;
import com.respire.pocketshop.repository.FeedbackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Feedback.
 */
@Service
@Transactional
public class FeedbackService {

    private final Logger log = LoggerFactory.getLogger(FeedbackService.class);

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    /**
     * Save a feedback.
     *
     * @param feedback the entity to save
     * @return the persisted entity
     */
    public Feedback save(Feedback feedback) {
        log.debug("Request to save Feedback : {}", feedback);
        return feedbackRepository.save(feedback);
    }

    /**
     *  Get all the feedbacks.
     *
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Feedback> findAll() {
        log.debug("Request to get all Feedbacks");
        return feedbackRepository.findAll();
    }

    /**
     *  Get one feedback by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Feedback findOne(Long id) {
        log.debug("Request to get Feedback : {}", id);
        return feedbackRepository.findOne(id);
    }

    /**
     *  Delete the  feedback by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Feedback : {}", id);
        feedbackRepository.delete(id);
    }
}
