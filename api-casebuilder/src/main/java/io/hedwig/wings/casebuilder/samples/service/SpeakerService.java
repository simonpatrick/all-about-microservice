package io.hedwig.wings.casebuilder.samples.service;

import io.hedwig.wings.casebuilder.samples.domain.Speaker;
import io.hedwig.wings.casebuilder.samples.domain.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by patrick on 15/12/28.
 */
public class SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    public List<Speaker> getSpeakerByCondition(Predicate<Speaker> predicate) {
        List<Speaker> rawResult = (List<Speaker>) speakerRepository.findAll();
        if (null == predicate) return rawResult;
        return rawResult.parallelStream().filter(predicate).collect(Collectors.toList());
    }

    public SpeakerRepository getSpeakerRepository() {
        return speakerRepository;
    }

    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }
}
