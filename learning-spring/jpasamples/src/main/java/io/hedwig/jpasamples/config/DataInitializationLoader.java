package io.hedwig.jpasamples.config;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;
import io.hedwig.jpasamples.domain.server.ServerAdditionalAttribute;
import io.hedwig.jpasamples.domain.server.ServerAdditionalAttributeValue;
import io.hedwig.jpasamples.domain.server.ServerInfo;
import io.hedwig.jpasamples.domain.site.Site;
import io.hedwig.jpasamples.domain.site.SiteNode;
import io.hedwig.jpasamples.repository.server.ServerAddlAttrRepository;
import io.hedwig.jpasamples.repository.server.ServerAddlAttrValueRepository;
import io.hedwig.jpasamples.repository.server.ServerInfoRepository;
import io.hedwig.jpasamples.repository.site.SiteNodeRepository;
import io.hedwig.jpasamples.repository.site.SiteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by patrick on 16/1/16.
 */
@Component
public class DataInitializationLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializationLoader.class);
    @Autowired
    private ServerInfoRepository serverInfoRepository;

    @Autowired
    private ServerAddlAttrRepository serverAddlAttrResp;

    @Autowired
    private ServerAddlAttrValueRepository valueRepository;

    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private SiteNodeRepository siteNodeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

       // initServerData();

    }

    private void initSiteData() {

        for (int i = 0; i < 5; i++) {
            Site site = new Site();
            initObjectValue(site);
            siteRepository.save(site);
        }

        List<Site> sites = siteRepository.findAll();
        for (Site site : sites) {
            SiteNode node = new SiteNode();
            node.setSiteId(site.getId());
            node.setSiteNodeComments("this is node for site id"+site.getId());
            node.setSiteNodeIP("192.168.0.12");
            siteNodeRepository.save(node);
        }
    }


    private void initServerData() {
        serverInfoRepository.deleteAllInBatch();
        for (int i = 0; i < 10; i++) {
            ServerInfo serverInfo = new ServerInfo();
            initObjectValue(serverInfo);
            serverInfo.setStatus(1);
            serverInfoRepository.save(serverInfo);
        }

        serverAddlAttrResp.deleteAllInBatch();
        for (int i = 0; i < 5; i++) {
            ServerAdditionalAttribute addtr = new ServerAdditionalAttribute();
            addtr.setServerAdditionalAttributeName("test" + i);
            addtr.setServerType("物理机");
            addtr.setStatus(1);
            initAuditableValue(addtr);
            serverAddlAttrResp.save(addtr);
        }

        for (int i = 0; i < 5; i++) {
            ServerAdditionalAttribute addtr = new ServerAdditionalAttribute();
            addtr.setServerAdditionalAttributeName("test" + i);
            addtr.setServerType("虚拟机");
            addtr.setStatus(1);
            initAuditableValue(addtr);
            serverAddlAttrResp.save(addtr);
        }


        List<ServerInfo> infos = serverInfoRepository.findAll();
        for (ServerInfo info : infos) {
            ServerAdditionalAttributeValue value = new ServerAdditionalAttributeValue();
            value.setServerInfoId(info.getId());
            value.setServerAdditionalAttributeName("test" + new Random().nextInt(5));
            value.setServerAdditionalAttributeValue("value_added");
            value.setStatus(1);
            initAuditableValue(value);
            valueRepository.save(value);
        }
    }

    private <T extends AbstractAuditingEntity> void initAuditableValue(T value) {
        value.setCreatedBy("tester123");
        value.setCreatedDate(new Date());
        value.setLastModifiedBy("tester123");
        value.setLastModifiedDate(new Date());
    }

    private <T extends AbstractAuditingEntity> void initObjectValue(T instance) {
        for (Field field : instance.getClass().getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase("id")) continue;
            field.setAccessible(true);
            try {
                field.set(instance, "test" + new Random().nextInt(1000));
            } catch (IllegalAccessException e) {
                logger.error("init data error: {}" + e);
            }
        }

        initAuditableValue(instance);
    }

}
