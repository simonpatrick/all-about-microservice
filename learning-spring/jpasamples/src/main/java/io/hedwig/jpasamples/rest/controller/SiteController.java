package io.hedwig.jpasamples.rest.controller;

import io.hedwig.jpasamples.domain.site.Site;
import io.hedwig.jpasamples.repository.site.SiteRepository;
import io.hedwig.jpasamples.rest.dto.SiteDTO;
import io.hedwig.jpasamples.tools.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by patrick on 16/1/15.
 */
@RequestMapping(value = "/site")
@RestController
public class SiteController {

    @Autowired
    private SiteRepository siteRepository;
    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<SiteDTO> findAll(){
        List<Site> sites = siteRepository.findAll();
        return BeanMapper.mapList(sites,SiteDTO.class);
    }
}
