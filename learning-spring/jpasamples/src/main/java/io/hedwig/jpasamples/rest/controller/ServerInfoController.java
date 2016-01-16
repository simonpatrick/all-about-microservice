package io.hedwig.jpasamples.rest.controller;

import com.google.common.collect.Lists;
import io.hedwig.jpasamples.domain.server.ServerAdditionalAttributeValue;
import io.hedwig.jpasamples.domain.server.ServerInfo;
import io.hedwig.jpasamples.enums.Status;
import io.hedwig.jpasamples.rest.adaptor.ServerInfoDTOAdaptor;
import io.hedwig.jpasamples.rest.dto.ServerInfoDTO;
import io.hedwig.jpasamples.service.ServerInfoService;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by patrick on 16/1/15.
 */
@RequestMapping(value = "/server")
@RestController
public class ServerInfoController {

    @Autowired
    private ServerInfoService serverInfoService;

    @Autowired
    private ServerInfoDTOAdaptor serverInfoDTOAdaptor;


    @RequestMapping(value = "/{serverId}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ServerInfoDTO getServerInfo(@PathVariable(value = "serverId")
                                       String serverId) {

        List<ServerInfo> serverInfos = serverInfoService.findServerInfoByIdsAndStatus(serverId, Status.ACTIVE);
        if (serverInfos.size() != 0) {
            return serverInfoDTOAdaptor.
                    convertToDTO(serverInfos.get(0)
                            , serverInfoService.findServerAddlValueByIdsAndStatus(serverId, Status.ACTIVE));
        }

        return new ServerInfoDTO();
    }


    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ServerInfoDTO saveServerInfo(ServerInfoDTO serverInfoDTO) {
        //validation,validate in cache
        ServerInfo serverInfo = serverInfoDTOAdaptor.convertToServerInfo(serverInfoDTO);
        List<ServerAdditionalAttributeValue> values = serverInfoDTOAdaptor.convertToServerAddlValues(serverInfoDTO);
        serverInfo = serverInfoService.getServerInfoRepository().save(serverInfo);
        values = serverInfoService.getServerAddlAttrValueRepository().save(values);

        return serverInfoDTOAdaptor.convertToDTO(serverInfo, values);
    }

    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ServerInfoDTO> getServerInfoByIds(String serverId) {
        List<ServerInfoDTO> dtos = Lists.newArrayList();
        List<ServerInfo> serverInfos;
        //todo validation
//        if(!StringHelper.isEmpty(serverId)){
        serverInfos = serverInfoService.findServerInfoByIdsAndStatus(serverId, Status.ACTIVE);
        dtos.addAll(serverInfos
                .stream()
                .map(getServerInfoServerInfoDTOFunction())
                .collect(Collectors.toList()));
//        }

        return dtos;
    }


    private Function<ServerInfo, ServerInfoDTO> getServerInfoServerInfoDTOFunction() {
        return serverInfo ->
                serverInfoDTOAdaptor.convertToDTO(serverInfo, serverInfoService.findServerAddlValueByIdsAndStatus(serverInfo.getId().toString(), Status.ACTIVE));
    }


}
