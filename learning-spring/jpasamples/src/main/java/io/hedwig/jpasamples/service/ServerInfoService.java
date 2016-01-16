package io.hedwig.jpasamples.service;

import com.google.common.collect.Lists;
import io.hedwig.jpasamples.domain.server.ServerAdditionalAttributeValue;
import io.hedwig.jpasamples.domain.server.ServerInfo;
import io.hedwig.jpasamples.enums.Status;
import io.hedwig.jpasamples.repository.server.ServerAddlAttrValueRepository;
import io.hedwig.jpasamples.repository.server.ServerInfoRepository;
import io.hedwig.jpasamples.service.predicates.EntityPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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



    /**
     * 获取ServerInfo
     *
     * @param ids
     * @param status
     * @return
     */
    public List<ServerInfo> findServerInfoByIdsAndStatus(String ids, Status status) {
        //validator
        List<ServerInfo> result = Lists.newArrayList();
        if(StringUtils.isEmpty(ids)){
            result = serverInfoRepository.findAll();
            return result.stream().filter(EntityPredicates.statusPredicate(status)
            ).collect(Collectors.toList());
        }else{
            return serverInfoRepository.findAll(parseToList(ids, ","))
                    .stream().filter(EntityPredicates.statusPredicate(status)
                    ).collect(Collectors.toList());
        }

    }


    public List<ServerAdditionalAttributeValue> findServerAddlValueByIdsAndStatus(String ids
            , Status status) {
        //validator
        return serverAddlAttrValueRepository.findAll(parseToList(ids, ","))
                .stream().filter(EntityPredicates.statusPredicate(status))
                .collect(Collectors.toList());
    }


    public ServerInfoRepository getServerInfoRepository() {
        return serverInfoRepository;
    }


    public ServerAddlAttrValueRepository getServerAddlAttrValueRepository() {
        return serverAddlAttrValueRepository;
    }

}
