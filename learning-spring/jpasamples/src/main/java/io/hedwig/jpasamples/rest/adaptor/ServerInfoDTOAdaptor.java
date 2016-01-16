package io.hedwig.jpasamples.rest.adaptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.hedwig.jpasamples.domain.server.ServerAdditionalAttribute;
import io.hedwig.jpasamples.domain.server.ServerAdditionalAttributeValue;
import io.hedwig.jpasamples.domain.server.ServerInfo;
import io.hedwig.jpasamples.enums.Status;
import io.hedwig.jpasamples.rest.dto.ServerInfoDTO;
import io.hedwig.jpasamples.tools.BeanMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by patrick on 16/1/15.
 */

@Component
public class ServerInfoDTOAdaptor {

    /**
     * combine ServeInfo, and addl Value To ServerInfoDTO
     *
     * @param serverInfo
     * @param addlValue
     * @return
     */
    public ServerInfoDTO convertToDTO(ServerInfo serverInfo,
                                      List<ServerAdditionalAttributeValue> addlValue) {

        ServerInfoDTO dto = BeanMapper.map(serverInfo, ServerInfoDTO.class);
        Map<String, String> addlValues = Maps.newHashMap();
        addlValue.forEach(item -> {
            addlValues.put(item.getServerAdditionalAttributeName()
                    , item.getServerAdditionalAttributeValue());
        });
        dto.setServerAddlValues(addlValues);
        return dto;
    }

    /**
     * convert to ServerInfo
     * @param dto
     * @return
     */
    public ServerInfo convertToServerInfo(ServerInfoDTO dto) {
        return BeanMapper.map(dto, ServerInfo.class);
    }

    /** convert to Server Addl Value info
     *
     * @param dto
     * @return
     */

    public List<ServerAdditionalAttributeValue> convertToServerAddlValues(ServerInfoDTO dto) {

        List<ServerAdditionalAttributeValue> result = Lists.newArrayList();

        for (Map.Entry<String, String> entry : dto.getServerAddlValues().entrySet()) {
            ServerAdditionalAttributeValue value = new ServerAdditionalAttributeValue();
            value.setServerInfoId(dto.getId());
            value.setServerAdditionalAttributeName(entry.getKey());
            value.setServerAdditionalAttributeValue(entry.getValue());
            value.setStatus(Status.ACTIVE.getStatusValue());
        }

        return result;
    }

}
