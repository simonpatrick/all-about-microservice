package io.hedwig.jpasamples.service;

import io.hedwig.jpasamples.domain.server.ServerAdditionalAttribute;
import io.hedwig.jpasamples.domain.server.ServerAdditionalAttributeValue;
import io.hedwig.jpasamples.domain.server.ServerInfo;
import io.hedwig.jpasamples.repository.server.ServerAddlAttrRepository;
import io.hedwig.jpasamples.repository.server.ServerAddlAttrValueRepository;
import io.hedwig.jpasamples.repository.server.ServerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static io.hedwig.jpasamples.tools.CollectionsHelper.parseToList;

/**
 * Created by patrick on 16/1/15.
 */
@Service
public class ServerInfoService {

    @Autowired
    private ServerInfoRepository serverInfoRepository;

    @Autowired
    private ServerAddlAttrValueRepository serverAddlAttrValueRepository;

    @Autowired
    private ServerAddlAttrRepository serverAdditionalAttribute;

    public List<ServerInfo> findServerInfoByIds(String ids){
        //validator
       return serverInfoRepository.findAll(parseToList(ids,","));
    }

    public List<ServerAdditionalAttributeValue> findServerAddlValue(String ids){
        //validator
        return serverAddlAttrValueRepository.findAll(parseToList(ids,","));
    }

    public List<ServerAdditionalAttribute> findServerAttributes(String serverType){
        return Collections.emptyList();
    }

}
