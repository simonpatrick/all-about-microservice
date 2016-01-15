package io.hedwig.jpasamples.rest.controller;

import io.hedwig.jpasamples.rest.dto.ServerInfoDTO;
import io.hedwig.jpasamples.service.ServerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Created by patrick on 16/1/15.
 */
@RequestMapping(value = "/server")
@RestController
public class ServerInfoController {

    @Autowired
    private ServerInfoService serverInfoService;

    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ServerInfoDTO> getServerInfo(@RequestParam(value = "serverIds", defaultValue = "")
                                                 String serverIds) {

        return Collections.EMPTY_LIST;
    }


    public ServerInfoService getServerInfoService() {
        return serverInfoService;
    }

    public void setServerInfoService(ServerInfoService serverInfoService) {
        this.serverInfoService = serverInfoService;
    }
}
