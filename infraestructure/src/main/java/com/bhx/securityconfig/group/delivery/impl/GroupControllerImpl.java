package com.bhx.securityconfig.group.delivery.impl;

import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.delivery.GroupController;
import com.bhx.securityconfig.group.delivery.converters.GroupRestConverter;
import com.bhx.securityconfig.group.delivery.request.CreateGroupDto;
import com.bhx.securityconfig.group.usecase.CreateGroupUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "KhaPhan" on 10-Jun-23
 * @project clean-architecture
 */
@RestController("/admin/group")
@RequiredArgsConstructor
@Slf4j
public class GroupControllerImpl implements GroupController {

    private final CreateGroupUseCase createGroupUseCase;
    private final GroupRestConverter groupRestConverter;

    @Override
    @PostMapping

    public ResponseEntity<Group> createGroup(@RequestBody CreateGroupDto createGroupDto) {
        log.info(createGroupDto.toString());
        try {
            Group groupCreate = groupRestConverter.mapToEntity(createGroupDto);
            createGroupUseCase.execute(groupCreate);
            return new ResponseEntity<>(groupCreate, HttpStatus.valueOf(201));
        } catch (Exception ex) {
        }
        return null;
    }


}
